package com.avviotech.labs.mhn.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.avviotech.labs.mhn.dto.Booking;

public interface BookingRepository extends MongoRepository<Booking, Long> {

	@Query("{'_id':?0}")
	Booking findByid(Long id);

}
