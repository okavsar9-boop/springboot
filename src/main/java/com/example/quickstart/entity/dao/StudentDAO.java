package com.example.quickstart.entity.dao;

import com.example.quickstart.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student foundById(Integer id);
}
