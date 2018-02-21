package com.avviotech.labs.mhn.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.avviotech.labs.mhn.dto.Provider;

public interface ProviderRepository extends MongoRepository<Provider, Long> {

	@Query("{'_id':?0}")
	Provider findByid(Long id);
	
	@Query("{email:'?0',password:'?1'}")
	Provider findByUser(String email,String password);
}
