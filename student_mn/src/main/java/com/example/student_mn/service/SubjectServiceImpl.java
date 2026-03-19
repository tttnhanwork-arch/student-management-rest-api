package com.example.student_mn.service;

import com.example.student_mn.dao.SubjectRepository;
import com.example.student_mn.entity.Subject;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService{
    private SubjectRepository subjectRepository;
    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository){
        this.subjectRepository=subjectRepository;
    }
    @Override
    public List<Subject> getAllSubject() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject findSubjectById(int id) {
        return subjectRepository.findById(id).orElseThrow(() -> new RuntimeException("Can not found Subject by this Id"));
    }

    @Override
    @Transactional
    public Subject addSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    @Transactional
    public Subject updateSubject(Subject subject) {
        return subjectRepository.saveAndFlush(subject);
    }

    @Override
    @Transactional
    public void deleteSubjectById(int id) {
subjectRepository.deleteById(id);
    }
}
