package com.example.quickstart;

import ch.qos.logback.core.joran.conditional.ThenAction;
import com.example.quickstart.entity.Student;
import com.example.quickstart.entity.dao.StudentDAO;
import com.example.quickstart.entity.dao.StudentDAOImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class QuickstartApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuickstartApplication.class, args);
	}

	private void queryForStudentsByTheLastNames(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByTheLastName("Plea");
		for (Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	@Bean
	public CommandLineRunner  commandLineRunner (StudentDAO studentDAO){
		return runner -> {
			//createMultipleStudent(studentDAO);
			//readStudent(studentDAO);
			queryForStudentsByTheLastNames(studentDAO);
		};

	}


}
