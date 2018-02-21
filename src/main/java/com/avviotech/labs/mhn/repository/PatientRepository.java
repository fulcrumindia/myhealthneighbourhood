package com.avviotech.labs.mhn.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.avviotech.labs.mhn.dto.Patient;


public interface PatientRepository extends MongoRepository<Patient, Long> {

	@Query("{'_id':?0}")
	Patient findByid(Long id);
	
}
