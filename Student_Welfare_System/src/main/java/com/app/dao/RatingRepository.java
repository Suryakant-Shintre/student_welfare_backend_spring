package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.RatingPojo;

public interface RatingRepository extends JpaRepository<RatingPojo,Long> {

}
