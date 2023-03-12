package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Rating_tbl")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class RatingPojo extends BaseEntityPojo {
	@Column(name="rating",nullable = false)
	private Double rating;
	
	@Column(name="comments",nullable = false)
	private String comments;
	
	@ManyToOne
	@JoinColumn(name="room",nullable=false)
	private RoomPojo room;
	
	public RatingPojo(Double rating, String comments) {
		super();
		this.rating = rating;
		this.comments = comments;
	}
	
	

}
