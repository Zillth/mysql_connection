package com.alanflores.mysql_connection.controller;

import com.alanflores.mysql_connection.model.Student;
import com.alanflores.mysql_connection.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/student")
public record StudentController(StudentService studentService) {

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() throws SQLException {
        List<Student> students = studentService.getStudents();
        return new ResponseEntity(students, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") String id) throws SQLException {
        Student students = studentService.getStudentById(id);
        return new ResponseEntity(students, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) throws SQLException {
        System.out.println(student.toString());
        Student students = studentService.createStudent(student);
        return new ResponseEntity(students, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) throws SQLException {
        Student updatedStudent = studentService.updateStudent(student);
        return new ResponseEntity(updatedStudent, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") String id) throws SQLException {
        studentService.deleteStudent(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
