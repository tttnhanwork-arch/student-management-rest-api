package com.example.student_mn.service;

import com.example.student_mn.entity.ReportCard;

import java.util.List;

public interface ReportCartService {
    public List<ReportCard> getAllRC();
    public ReportCard findRCById(int id);
    public ReportCard addRC(ReportCard reportCard);
    public ReportCard updateRC(ReportCard reportCard);
    public void deleteRCById(int id);
}
