package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.RoomPojo;

public interface RoomRepository extends JpaRepository<RoomPojo,Long>{

}
