package com.example.student_mn.dao;

import com.example.student_mn.entity.ScoreSheet;
import com.example.student_mn.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
