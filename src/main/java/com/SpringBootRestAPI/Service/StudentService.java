package com.SpringBootRestAPI.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.SpringBootRestAPI.Entity.StudentInfo;
import com.SpringBootRestAPI.Repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository repository;
	
	public StudentInfo CreateStudent(StudentInfo info) {
		StudentInfo info2=repository.save(info);
		 return info2;
	}
	
	 public Optional<StudentInfo> getStudent( Integer Stud_id) {
		 Optional<StudentInfo> info2=repository.findById(Stud_id);
		 return info2;
	 }
	 
	 public List<StudentInfo> getAllStudentInfo()
	 {
		 return repository.findAll();
	 }
	 
	 public StudentInfo updaStudentInfo( Integer Stud_id, StudentInfo info) {
		 StudentInfo info2 = repository.findById(Stud_id)
		.orElseThrow(() -> new ResourceNotFoundException("student not found with id"+Stud_id));
		 info2.setName(info.getName());
		 info2.setEmail(info.getEmail());
		 info2.setPhone(info.getPhone());
		 return  repository.save(info2);
	 }
	 
	 
	 public void delete(@PathVariable Integer Stud_id) {
		 repository.deleteById(Stud_id);
	 }
	 
	 public void deleteall() {
		 repository.deleteAll();
	 }
}
