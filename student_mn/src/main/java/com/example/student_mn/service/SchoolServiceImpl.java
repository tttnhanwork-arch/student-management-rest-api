package com.example.student_mn.service;

import com.example.student_mn.dao.SchoolRepository;
import com.example.student_mn.entity.School;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService{
    private SchoolRepository schoolRepository;
    @Autowired
    public SchoolServiceImpl(SchoolRepository schoolRepository){
        this.schoolRepository=schoolRepository;
    }

    @Override
    public List<School> getAllSchool() {
        return schoolRepository.findAll();
    }

    @Override
    public School findSchoolById(int id) {
        return schoolRepository.findById(id).orElseThrow(() -> new RuntimeException("School not found!")) ;

    }

    @Override
    @Transactional
    public School addSchool(School school) {
        return schoolRepository.save(school);
    }

    @Override
    @Transactional
    public School updateSchool(School school) {
        return schoolRepository.saveAndFlush(school);
    }

    @Override
    @Transactional
    public void deleteSchoolById(int id) {
    schoolRepository.deleteById(id);
    }
}
