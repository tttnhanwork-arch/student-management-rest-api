package com.example.student_mn.dao;

import com.example.student_mn.entity.Student;
import com.example.student_mn.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
