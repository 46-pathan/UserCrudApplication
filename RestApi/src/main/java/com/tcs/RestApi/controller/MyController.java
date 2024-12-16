package com.tcs.RestApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tcs.RestApi.model.Student;
import com.tcs.RestApi.service.MyService;

@RestController
@RequestMapping("/students")
public class MyController {
	@Autowired
	private MyService myservice;
	
	@PostMapping("/student")
	public Student createStudent(@RequestBody Student student) {
		return myservice.createStudent(student);
	}
	
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable("id") int id) {
		return myservice.getStudent(id);
	}
	
	@GetMapping("/student")
	public List<Student> getAllStudents(){
		return myservice.getAllStudents();
	}
	
	@PutMapping("/student/{id}")
	public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
		return myservice.updateStudent(id, student);
	}
	
	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable int id) {
		return myservice.deleteStudent(id);
	}
	
}
