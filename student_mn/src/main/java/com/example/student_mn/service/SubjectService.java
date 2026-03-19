package com.example.student_mn.service;

import com.example.student_mn.entity.Subject;

import java.util.List;

public interface SubjectService {
    public List<Subject> getAllSubject();
    public Subject findSubjectById(int id);
    public Subject addSubject(Subject subject);
    public Subject updateSubject(Subject subject);
    public void deleteSubjectById(int id);
}
