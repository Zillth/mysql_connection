package com.alanflores.mysql_connection.service;

import com.alanflores.mysql_connection.model.Student;
import com.alanflores.mysql_connection.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public record StudentService(StudentRepository studentRepository) {

    public List<Student> getStudents() throws SQLException {
        return studentRepository.getStudents();
    }

    public Student getStudentById(String id) throws SQLException {
        return studentRepository.getStudentById(id);
    }

    public Student createStudent(Student student) throws SQLException {
        return studentRepository.createStudent(student.getId(), student.getName(), student.getEmail(), student.getPhone());
    }

    public Student updateStudent(Student student) throws SQLException {
        return studentRepository.updateStudent(student.getId(), student.getName(), student.getEmail(), student.getPhone());
    }

    public void deleteStudent(String id) throws SQLException {
        studentRepository.deleteStudent(id);
    }
}
