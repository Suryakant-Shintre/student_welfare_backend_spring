package com.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.RoomPojo;
import com.app.service.ImageHandlingService;
import com.app.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {
	@Autowired
	private RoomService roomService;
	@Autowired
	private ImageHandlingService imageService;
	@PostMapping
	public ResponseEntity<?> saveRoom(@RequestBody RoomPojo room){
		return new ResponseEntity<>(roomService.saveRoom(room),HttpStatus.CREATED);
		
	}
	@DeleteMapping("/{roomId}")
	public ResponseEntity<?>deleteRoom(@PathVariable Long roomId){
		roomService.deleteRoom(roomId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?>getAllRooms(){
		return new ResponseEntity<>(roomService.findAllRooms(),HttpStatus.OK) ;
		
	}
	@PostMapping(value="/{roomId}/image",consumes = "multipart/form-data")
 	public ResponseEntity<?> uploadImageToServerSideFolder(@RequestParam MultipartFile imageFile,
 			@PathVariable Long roomId
 			) throws IOException {
 		System.out.println("in upload img " + roomId + " " + imageFile.getOriginalFilename());
 		return new ResponseEntity<>(imageService.uploadImage(roomId, imageFile), HttpStatus.CREATED);
 	}
	@GetMapping(value = "/{roomId}/image", produces = { MediaType.IMAGE_GIF_VALUE, 
 			MediaType.IMAGE_JPEG_VALUE,
 			MediaType.IMAGE_PNG_VALUE })
 	public ResponseEntity<?> serveImageFromServerSideFolder(@PathVariable Long roomId) throws IOException {
 		System.out.println("in serve img " + roomId);
 		return new ResponseEntity<>(imageService.serveImage(roomId), HttpStatus.OK);
 	}


}
