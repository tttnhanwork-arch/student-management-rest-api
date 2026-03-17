package com.example.student_mn.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "report_card")
public class ReportCard {
    @Id
    @Column(name = "id_card")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_card;
    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_student")
    private Student student;
    @Column(name = "semester")
    private String semester;
    @Column(name = "gpa")
    private Double GPA;
    @Column(name = "conduct")
    private String conduct;
    @Column(name = "comment_of_teacher")
    private String comment;

    public ReportCard() {
    }

    public ReportCard(Student student, String semester, Double GPA, String conduct, String comment) {
        this.student = student;
        this.semester = semester;
        this.GPA = GPA;
        this.conduct = conduct;
        this.comment = comment;
    }

    public int getId_card() {
        return id_card;
    }

    public void setId_card(int id_card) {
        this.id_card = id_card;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Double getGPA() {
        return GPA;
    }

    public void setGPA(Double GPA) {
        this.GPA = GPA;
    }

    public String getConduct() {
        return conduct;
    }

    public void setConduct(String conduct) {
        this.conduct = conduct;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "ReportCard{" +
                "id_card=" + id_card +
                ", student=" + student +
                ", semester='" + semester + '\'' +
                ", GPA=" + GPA +
                ", conduct='" + conduct + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
