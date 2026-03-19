package com.example.student_mn.service;

import com.example.student_mn.entity.School;

import java.util.List;

public interface SchoolService {
    public List<School> getAllSchool ();
    public School findSchoolById(int id);
    public School addSchool(School school);
    public School updateSchool(School school);
    public void deleteSchoolById(int id);
}
