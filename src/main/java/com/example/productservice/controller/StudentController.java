package com.example.productservice.controller;

import com.example.productservice.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students=new ArrayList<>(
            List.of(
                    new Student(1,"Summu", "90"),
                    new Student(2,"sharru", "85"),
                    new Student(3,"karri", "95")
            )
    );

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }
}
