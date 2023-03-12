package com.app.pojos;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Service_tbl")
@Getter
@Setter
@NoArgsConstructor
@ToString

public class ServicePojo extends BaseEntityPojo {
	
	@Column(name="Service_Name")
	private String serviceName;
	
	@Column(name="Description",length=200)
	private String description;
	
	@ManyToOne
	@JoinColumn(name="UserID",nullable=false)
	private UserPojo userRole;
	
	@OneToMany(mappedBy="service",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<RoomPojo> room = new ArrayList<>();
	
	public ServicePojo(String serviceName, String description) {
		super();
		this.serviceName = serviceName;
		this.description = description;
	}
	
	private void addRoom(RoomPojo room) {
		this.room.add(room);
		room.setService(this);
	}



}
