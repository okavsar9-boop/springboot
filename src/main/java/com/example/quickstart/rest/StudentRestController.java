package com.example.quickstart.rest;
import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.List;
import com.example.quickstart.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException (StubNotFoundException exc){
        StudentErrorResponse error = new StudentErrorResponse ();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }


    private List<Student> theStudent;

    @PostConstruct
    public void loadData(){
        theStudent = new ArrayList<>();

        theStudent.add(new Student("Yacine","Dilmi"));
        theStudent.add(new Student("Yacine","Dilmi"));
        theStudent.add(new Student("Yacine","Dilmi"));

    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudent;
    }

    @GetMapping("/students/{studentId}")

    public Student getStudent(@PathVariable int studentId){
        if(studentId > theStudent.size() || studentId < 0){
            throw new  StudentNotFoundException ("Student id not found - " + studentId);
        }
        return theStudent.get(studentId);
    }

}
