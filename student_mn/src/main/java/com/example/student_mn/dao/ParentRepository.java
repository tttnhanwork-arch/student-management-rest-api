package com.example.student_mn.dao;

import com.example.student_mn.entity.Employee;
import com.example.student_mn.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Integer> {
}
