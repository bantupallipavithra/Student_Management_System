package com.student.management.service;

import java.util.List;
import com.student.management.entity.Student;

public interface StudentService {

    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(int id);

    Student updateStudent(Student student);

    void deleteStudent(int id);
}
