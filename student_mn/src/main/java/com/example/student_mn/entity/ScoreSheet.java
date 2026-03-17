package com.example.student_mn.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "score_sheet")
public class ScoreSheet {
    @Id
    @Column(name = "id_sheet")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sheet;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_student")
    private Student student;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_subject")
    private Subject subject;
    @Column(name = "date_of_test")
    private LocalDate dayOfTest;
    @Column(name = "score")
    private Double score;

    public ScoreSheet() {
    }

    public ScoreSheet(Student student, Subject subject, LocalDate dayOfTest, Double score) {
        this.student = student;
        this.subject = subject;
        this.dayOfTest = dayOfTest;
        this.score = score;
    }

    public int getId_sheet() {
        return id_sheet;
    }

    public void setId_sheet(int id_sheet) {
        this.id_sheet = id_sheet;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public LocalDate getDayOfTest() {
        return dayOfTest;
    }

    public void setDayOfTest(LocalDate dayOfTest) {
        this.dayOfTest = dayOfTest;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "ScoreSheet{" +
                "id_sheet=" + id_sheet +
                ", student=" + student +
                ", subject=" + subject +
                ", dayOfTest=" + dayOfTest +
                ", score=" + score +
                '}';
    }
}
