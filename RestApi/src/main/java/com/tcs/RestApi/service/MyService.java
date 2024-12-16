package com.tcs.RestApi.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.RestApi.model.Student;
import com.tcs.RestApi.repository.MyRepo;

@Service
public class MyService {
	
	@Autowired
	private MyRepo myrepo;
	
	
	public Student createStudent(Student student) {
		return myrepo.save(student);
	}

	public Student getStudent(int id) {
		Optional<Student> student=myrepo.findById(id);
		if(student.isPresent()) {
			return student.get();
		}
		return null;
	}
	
	public List<Student> getAllStudents(){
		List<Student> students=myrepo.findAll();
		return students;
	}
	
	public Student updateStudent(int id,Student student) {
		Optional<Student> isstudent=myrepo.findById(id);
		if(isstudent.isPresent()) {
			Student newstudent=isstudent.get();
			if(Objects.nonNull(student.getName()) && !"".equalsIgnoreCase(student.getName())){
				newstudent.setName(student.getName());
			}
			if(Objects.nonNull(student.getCourse()) && !"".equalsIgnoreCase(student.getCourse())) {
				newstudent.setCourse(student.getCourse());
			}
			return myrepo.save(newstudent);
		}
		return null;
	}
	
	public String deleteStudent(int id) {
		if(myrepo.findById(id).isPresent()) {
			myrepo.deleteById(id);
			return "Deleted";
		}
		return "No record";
	}

}
