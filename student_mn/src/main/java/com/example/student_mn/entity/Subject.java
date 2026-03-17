package com.example.student_mn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @Column(name = "id_subject")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_subject;
    @Column(name = "name")
    private String name;
    @Column(name = "period")
    private String period;
    @OneToMany(mappedBy = "subject", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JsonIgnore
    private List<ScoreSheet> scoreSheets;
    public Subject() {
    }

    public Subject(String name, String period, List<ScoreSheet> scoreSheets) {
        this.name = name;
        this.period = period;
        this.scoreSheets = scoreSheets;
    }

    public Subject(String name, String period) {
        this.name = name;
        this.period = period;
    }

    public int getId_subject() {
        return id_subject;
    }

    public void setId_subject(int id_subject) {
        this.id_subject = id_subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public List<ScoreSheet> getScoreSheets() {
        return scoreSheets;
    }

    public void setScoreSheets(List<ScoreSheet> scoreSheets) {
        this.scoreSheets = scoreSheets;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id_subject=" + id_subject +
                ", name='" + name + '\'' +
                ", period='" + period + '\'' +
                '}';
    }
}
