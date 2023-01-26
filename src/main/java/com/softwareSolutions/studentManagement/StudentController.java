package com.softwareSolutions.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    // adding information
    @PostMapping("/add_student")
    public ResponseEntity addStudent(@RequestBody Student student) {
        String response = studentService.addStudent(student);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // getting information
    @GetMapping("/get_student")
    public ResponseEntity getStudent(@RequestParam("id") int enrollID) {
        Student student = studentService.getStudent(enrollID);

        return new ResponseEntity(student, HttpStatus.FOUND);
    }

    // updating information
    @PutMapping("/update_student")
    public ResponseEntity updateStudent(@RequestParam("id") int enrollID,@RequestParam("age") int age) {
        String response = studentService.updateStudent(enrollID, age);
        if(response==null)
            return new ResponseEntity("Invalid ID", HttpStatus.NOT_MODIFIED);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    // delete information
    @DeleteMapping("/delete_student")
    public ResponseEntity deleteStudent(@RequestParam("id") int enrollID) {
        String response = studentService.deleteStudent(enrollID);
        if (response==null)
            return new ResponseEntity<>("Invalid ID", HttpStatus.BAD_REQUEST);

        return new ResponseEntity(response, HttpStatus.OK);
    }

}
