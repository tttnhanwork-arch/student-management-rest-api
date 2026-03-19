package com.example.student_mn.service;

import com.example.student_mn.dao.ClassRepository;
import com.example.student_mn.dao.SchoolRepository;
import com.example.student_mn.entity.Class;
import com.example.student_mn.entity.School;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService{
    private ClassRepository classRepository;
@Autowired
    public ClassServiceImpl(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public List<Class> getAllClass() {
        return classRepository.findAll();
    }

    @Override
    public Class findClassById(int id) {
        return classRepository.findById(id).orElseThrow(() -> new RuntimeException("Class not found !!!"));
    }

    @Override
    @Transactional
    public Class addClass(Class aclass) {
        return classRepository.save(aclass);
    }

    @Override
    @Transactional
    public Class updateClass(Class aclass) {
        return classRepository.saveAndFlush(aclass);
    }

    @Override
    @Transactional
    public void deleteClassById(int id) {
classRepository.deleteById(id);
    }
}
