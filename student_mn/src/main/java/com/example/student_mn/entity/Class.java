package com.example.student_mn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.Year;
import java.util.List;

@Entity
@Table(name = "class")
public class Class {
    @Id
    @Column(name = "id_class")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_class;
    @Column(name = "name")
    private String name;
    @Column(name = "grade")
    private int grade;
    @Column(name = "year")
    private String year;
    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_teacher")
    private Employee teacher;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_school")
    private School school;
    @OneToMany(mappedBy = "aClass", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JsonIgnore
    private List<Student> students;
    public Class() {
    }

    public Class(String name, int grade, String year, Employee teacher, School school, List<Student> students) {
        this.name = name;
        this.grade = grade;
        this.year = year;
        this.teacher = teacher;
        this.school = school;
        this.students = students;
    }

    public Class(String name, int grade, String year, Employee teacher, School school) {
        this.name = name;
        this.grade = grade;
        this.year = year;
        this.teacher = teacher;
        this.school = school;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getId_class() {
        return id_class;
    }

    public void setId_class(int id_class) {
        this.id_class = id_class;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Employee getTeacher() {
        return teacher;
    }

    public void setTeacher(Employee teacher) {
        this.teacher = teacher;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id_class=" + id_class +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", year=" + year +
                ", teacher=" + teacher +
                ", school=" + school +
                '}';
    }
}
