package com.example.student_mn.service;

import com.example.student_mn.entity.ScoreSheet;

import java.util.List;

public interface ScoreSheetService {
    public List<ScoreSheet> getAllScoreSheet();
    public ScoreSheet findScoreSheetById(int id);
    public ScoreSheet addScoreSheet(ScoreSheet scoreSheet);
    public ScoreSheet updateScoreSheet(ScoreSheet scoreSheet);
    public void deleteScoreSheetById (int id);
}
