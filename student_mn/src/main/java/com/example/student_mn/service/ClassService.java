package com.example.student_mn.service;

import com.example.student_mn.entity.Class;

import java.util.List;

public interface ClassService {
    public List<Class> getAllClass();
    public Class findClassById(int id);
    public Class addClass(Class aclass);
    public Class updateClass(Class aclass);
    public void deleteClassById(int id);
}
