package com.javaguides.springboot.controller;

import com.javaguides.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
    //http://localhost:8090/students/1
    @GetMapping("students/{id}/{first-name}/{last-name}") // URI template variable
    public Student studentPathVariable(@PathVariable ("id") int studentId,
                                       @PathVariable ("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        return new Student(studentId, firstName, lastName);
    }
}
