package com.example.student_mn.service;

import com.example.student_mn.entity.Parent;

import java.util.List;

public interface ParentService {
    public List<Parent> getAllParent();
    public Parent findParentByid(int id);
    public Parent addParent(Parent parent);
    public Parent updateParent(Parent parent);
    public void deleteParentById(int id);
}
