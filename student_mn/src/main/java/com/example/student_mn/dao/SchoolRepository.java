package com.example.student_mn.dao;

import com.example.student_mn.entity.ReportCard;
import com.example.student_mn.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {
}
