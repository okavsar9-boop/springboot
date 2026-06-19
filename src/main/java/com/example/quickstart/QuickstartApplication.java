package com.example.quickstart;

import com.example.quickstart.entity.Student;
import com.example.quickstart.entity.dao.StudentDAO;
import com.example.quickstart.entity.dao.StudentDAOImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QuickstartApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuickstartApplication.class, args);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating a new student object");
		Student tempStudent  = new Student("Paul","Doe","okavsar9@gmail.com");

		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: " + tempStudent.getId() );
	}

	@Bean
	public CommandLineRunner  commandLineRunner (StudentDAO studentDAO){
		return runner -> {
			createStudent(studentDAO);
		};

	}


}
