package com.pack.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pack.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
