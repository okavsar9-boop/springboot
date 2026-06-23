package com.example.quickstart.rest;

import com.example.quickstart.entity.Employee;
import com.example.quickstart.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public class EmployeeRestController {
    @RestController
    @RequestMapping("/api")
    public class EmployeeRestController {
        private EmployeeService employeeService;
        @Autowired
        public EmployeeRestController (EmployeeService theEmployeeService){
            employeeService = theEmployeeService;
        }
        @GetMapping("/employees")
        public List<Employee> findAll(){
            return employeeService.findAll();
        }
    }
}
