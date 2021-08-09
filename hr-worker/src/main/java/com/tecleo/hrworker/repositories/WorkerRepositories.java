package com.tecleo.hrworker.repositories;

import com.tecleo.hrworker.entities.Worker;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkerRepositories extends MongoRepository<Worker, String> { }
