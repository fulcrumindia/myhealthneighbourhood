package com.avviotech.labs.mhn.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.avviotech.labs.mhn.dto.Counter;


@Repository
public interface CounterRepository extends MongoRepository<Counter, String> {}