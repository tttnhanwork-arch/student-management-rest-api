package com.example.student_mn.dao;

import com.example.student_mn.entity.Parent;
import com.example.student_mn.entity.ReportCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportCardRepository extends JpaRepository<ReportCard, Integer> {
}
