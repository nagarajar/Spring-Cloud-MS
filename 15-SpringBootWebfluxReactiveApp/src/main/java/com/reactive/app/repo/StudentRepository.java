package com.reactive.app.repo;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.reactive.app.model.Student;

public interface StudentRepository extends ReactiveMongoRepository<Student, Serializable> {

}
