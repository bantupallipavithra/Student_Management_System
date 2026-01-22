package com.student.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.student.management.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    // No code needed 😎
}
