package com.example.student_mn.service;

import com.example.student_mn.dao.ParentRepository;
import com.example.student_mn.entity.Parent;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentServiceImpl implements ParentService{
    private ParentRepository parentRepository;
@Autowired
    public ParentServiceImpl(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    public List<Parent> getAllParent() {
        return parentRepository.findAll();
    }

    @Override
    public Parent findParentByid(int id) {
        return parentRepository.findById(id).orElseThrow(() -> new RuntimeException("Parent is not found !!!"));
    }

    @Override
    @Transactional
    public Parent addParent(Parent parent) {
        return parentRepository.save(parent);
    }

    @Override
    @Transactional
    public Parent updateParent(Parent parent) {
        return parentRepository.saveAndFlush(parent);
    }

    @Override
    @Transactional
    public void deleteParentById(int id) {
    parentRepository.deleteById(id);
    }
}
