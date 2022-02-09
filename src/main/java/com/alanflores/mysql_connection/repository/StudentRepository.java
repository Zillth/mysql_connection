package com.alanflores.mysql_connection.repository;

import com.alanflores.mysql_connection.MysqlConnection;
import com.alanflores.mysql_connection.model.Student;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private MysqlConnection mysqlConnection = new MysqlConnection();

    public List<Student> getStudents() throws SQLException {
        String sql = String.format("select * from student");
        ResultSet s = this.mysqlConnection.executeQuery(sql);
        List<Student> students = new ArrayList<Student>();
        while (s.next()) {
            students.add(new Student(s.getString("id"), s.getString("name"), s.getString("email"), s.getString("phone")));
        }
        this.mysqlConnection.disconnect();
        return students;
    }

    public Student getStudentById(String id) throws SQLException {
        String sql = String.format("select * from student where id = %s", id);
        ResultSet s = this.mysqlConnection.executeQuery(sql);
        Student student = new Student();
        if (s.next()) {
            student = new Student(s.getString("id"), s.getString("name"), s.getString("email"), s.getString("phone"));
        }
        this.mysqlConnection.disconnect();
        return student;
    }

    public Student createStudent(String id, String name, String email, String phone) throws SQLException {
        String sql = String.format("insert into student values ('%1$s', '%2$s', '%3$s', '%4$s')", id, name, email, phone);
        int s = this.mysqlConnection.executeUpdate(sql);
        Student student = new Student();
        if (s > 0) {
            student = new Student(id, name, email, phone);
        }
        this.mysqlConnection.disconnect();
        return student;
    }

    public Student updateStudent(String id, String name, String email, String phone) {
        String sql = String.format("update student set name = '%1$s', email = '%2$s', phone = '%3$s' where id = '%4$s'", name, email, phone, id);
        int s = this.mysqlConnection.executeUpdate(sql);
        Student student = new Student();
        if (s > 0) {
            student = new Student(id, name, email, phone);
        }
        this.mysqlConnection.disconnect();
        return student;
    }

    public void deleteStudent(String id) {
        String sql = String.format("delete from student where id = '%s'", id);
        this.mysqlConnection.executeUpdate(sql);
        this.mysqlConnection.disconnect();
    }
}
