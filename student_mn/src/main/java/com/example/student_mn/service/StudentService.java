package com.example.student_mn.service;

import com.example.student_mn.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudent();
    public Student findStudentById(int id);
    public Student addStudent(Student student);
    public Student updateStudent(Student student);
    public void deleteStudentById(int id);
}
