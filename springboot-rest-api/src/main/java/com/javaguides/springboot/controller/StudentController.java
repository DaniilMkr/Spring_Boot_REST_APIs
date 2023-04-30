package com.javaguides.springboot.controller;

import com.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // HTTP GET Request
    // http://localhost:8090/student

    @GetMapping("student")
    public Student getStudent() {
        Student student = new Student(1, "Daniil", "Makarov");
        return student;
    }

    // http://localhost:8090/students
    @GetMapping("students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Andrey", "Makarov"));
        students.add(new Student(2, "Daniil", "Makarov"));
        students.add(new Student(3, "Anna", "Makarova"));
        return students;
    }

    // Spring Boot API with Path Variable
    // http://localhost:8090/students/1
    @GetMapping("students/{id}/{first-name}/{last-name}") // URI template variable
    public Student studentPathVariable(@PathVariable ("id") int studentId,
                                       @PathVariable ("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        return new Student(studentId, firstName, lastName);
    }

    // Spring Boot REST API with Request Param
    // http://localhost:8090/students/query?id=1&firstName=Daniil&lastName=Makarov   Query Parameter
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName) {
        return new Student(id, firstName, lastName );
    }

    // Spring BooT REST API that handles HTTP POST Request
    // @PostMapping and @RequestBody

    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

}
