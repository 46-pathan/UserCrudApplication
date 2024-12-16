package com.tcs.RestApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.RestApi.model.Student;

public interface MyRepo extends JpaRepository<Student,Integer> {

}
