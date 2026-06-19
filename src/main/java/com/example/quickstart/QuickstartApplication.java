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

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating 4 new student objects");
		Student tempStudent1  = new Student("Paul","Doe","okavsar9@gmail.com");
		Student tempStudent2  = new Student("Mia","Jenny","sneakyjm@gmail.com");
		Student tempStudent3  = new Student("John","Plea","hondervue@gmail.com");
		Student tempStudent4  = new Student("Kawa","Harma","10omhedb@gmail.com");

		System.out.println("Saving the students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		studentDAO.save(tempStudent4);


		System.out.println("Saved student. Generated id: " + tempStudent1.getId() );
		System.out.println("Saved student. Generated id: " + tempStudent2.getId() );
		System.out.println("Saved student. Generated id: " + tempStudent3.getId() );
		System.out.println("Saved student. Generated id: " + tempStudent4.getId() );


		System.out.println("Retrieving student with id: " + tempStudent1.getId());
		Student student = studentDAO.foundById(tempStudent1.getId());
		System.out.println("Found the student: " + student);
	}

	@Bean
	public CommandLineRunner  commandLineRunner (StudentDAO studentDAO){
		return runner -> {
			//createMultipleStudent(studentDAO);
			readStudent(studentDAO);
		};

	}


}
