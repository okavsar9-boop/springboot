package com.example.quickstart;

import ch.qos.logback.core.joran.conditional.ThenAction;
import com.example.quickstart.entity.Student;
import com.example.quickstart.entity.dao.StudentDAO;
import com.example.quickstart.entity.dao.StudentDAOImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class QuickstartApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuickstartApplication.class, args);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		System.out.println("Creating a new students");

		Student student1 = new Student("Yacine","Dilmi Ahmed","@ycn.di");
		Student student2 = new Student("Ominakavsar","Abduganieva","@ominakavsar");
		Student student3 = new Student("Hamza","Bakr","@hamzabkr");
		Student student4 = new Student("Anas","Abu Sneineh","@anas_1");

		System.out.println("Saving the student...");

		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
		studentDAO.save(student4);

		System.out.println("Student is saved, Generated id: " + student1.getId());
		System.out.println("Student is saved, Generated id: " + student2.getId());
		System.out.println("Student is saved, Generated id: " + student3.getId());
		System.out.println("Student is saved, Generated id: " + student4.getId());


	}


	@Bean
	public CommandLineRunner  commandLineRunner (StudentDAO studentDAO){
		return runner -> {
			createMultipleStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudentsByTheLastNames(studentDAO);
			//updateStudent(studentDAO);
			//deleteTheStudent(studentDAO);
			//deleteTheAllStudents(studentDAO);
		};

	}


}
