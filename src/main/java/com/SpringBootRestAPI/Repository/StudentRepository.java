package com.SpringBootRestAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBootRestAPI.Entity.StudentInfo;

public interface StudentRepository extends JpaRepository<StudentInfo, Integer> {

}
