package com.SpringBootRestAPI.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootRestAPI.Entity.StudentInfo;
import com.SpringBootRestAPI.Service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService Studs;
	
	@PostMapping("/StudentInfo")
	public ResponseEntity<StudentInfo>  CreateStudent(@RequestBody StudentInfo info) {
		StudentInfo info2= Studs.CreateStudent(info);	
		return ResponseEntity.ok(info2);
	}
	
	@GetMapping("{Stud_id}")
	public ResponseEntity<Optional<StudentInfo>> GetStudent(@PathVariable Integer Stud_id,StudentInfo info)
	{
		Optional<StudentInfo> info2=Studs.getStudent(Stud_id);
		return ResponseEntity.ok(info2);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<StudentInfo>> GetAll(){
	  List<StudentInfo> info= Studs.getAllStudentInfo();
	  return ResponseEntity.ok(info);
	}
	
	@PutMapping("{Stud_id}")
	public ResponseEntity<StudentInfo> UpdateStudentInfo(@PathVariable Integer Stud_id,@RequestBody StudentInfo info){
	StudentInfo info2	= Studs.updaStudentInfo(Stud_id,info);
		return ResponseEntity.ok(info2);
	}
	
	@DeleteMapping("{Stud_id}")
	public ResponseEntity<StudentInfo> delete(@PathVariable Integer Stud_id,StudentInfo info){
		Studs.delete(Stud_id);
		return ResponseEntity.ok(info);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<StudentInfo> delete(StudentInfo info){
		Studs.deleteall();
		return ResponseEntity.ok(info);
	}
	

}
