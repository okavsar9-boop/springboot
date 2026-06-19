package com.example.quickstart.entity.dao;

import com.example.quickstart.entity.Student;
import jakarta.persistence.TypedQuery;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student foundById(Integer id);
    List<Student> findAll();

    List<Student> findByTheLastName(String theLastName);


}
