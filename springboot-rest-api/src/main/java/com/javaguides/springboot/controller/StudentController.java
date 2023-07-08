package com.javaguides.springboot.controller;

import com.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")  //To define base URL for REST API
public class StudentController {

    // HTTP GET Request
    // http://localhost:8090/students

    @GetMapping("students")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1, "Daniil", "Makarov");
        //return new ResponseEntity<>(student,HttpStatus.OK);
        return ResponseEntity.ok().header("custom-header", "daniil").body(student);
    }

    // http://localhost:8090/students
    @GetMapping()
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Andrey", "Orlov"));
        students.add(new Student(2, "Anton", "Ivanov"));
        students.add(new Student(3, "Kostya", "Kuznecov"));
        return students;
    }

    // Spring Boot API with Path Variable
    // http://localhost:8090/students/1
    @GetMapping("{id}/{first-name}/{last-name}") // URI template variable
    public Student studentPathVariable(@PathVariable ("id") int studentId,
                                       @PathVariable ("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        return new Student(studentId, firstName, lastName);
    }

    // Spring Boot REST API with Request Param
    // http://localhost:8090/students/query?id=1&firstName=Daniil&lastName=Makarov   Query Parameter
    @GetMapping("query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName) {
        return new Student(id, firstName, lastName );
    }

    // Spring BooT REST API that handles HTTP POST Request - creating new resource
    // @PostMapping and @RequestBody

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    // Spring BooT REST API that handles HTTP PUT Request - updating existing resource
    @PutMapping("{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }
    // Spring Boot REST API that handles HTTP Delete Request - deleting the existing resource

    @DeleteMapping("{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return "Student deleted successfully!";
    }
    // Spring Boot REST API that handles HTTP Delete Request

}
