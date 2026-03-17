package com.example.student_mn.dao;

import com.example.student_mn.entity.School;
import com.example.student_mn.entity.ScoreSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreSheetRepository extends JpaRepository<ScoreSheet, Integer> {
}
