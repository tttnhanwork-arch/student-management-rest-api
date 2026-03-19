package com.example.student_mn.service;

import com.example.student_mn.dao.SchoolRepository;
import com.example.student_mn.dao.ScoreSheetRepository;
import com.example.student_mn.entity.ScoreSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreSheetServiceImpl implements ScoreSheetService {
    private ScoreSheetRepository scoreSheetRepository;
    @Autowired
    public ScoreSheetServiceImpl(ScoreSheetRepository scoreSheetRepository){
        this.scoreSheetRepository=scoreSheetRepository;
    }
    @Override
    public List<ScoreSheet> getAllScoreSheet() {
        return scoreSheetRepository.findAll();
    }

    @Override
    public ScoreSheet findScoreSheetById(int id) {
        return scoreSheetRepository.findById(id).orElseThrow(() -> new RuntimeException("Can not found the Score sheet by this Id"));
    }

    @Override
    public ScoreSheet addScoreSheet(ScoreSheet scoreSheet) {
        return scoreSheetRepository.save(scoreSheet);
    }

    @Override
    public ScoreSheet updateScoreSheet(ScoreSheet scoreSheet) {
        return scoreSheetRepository.saveAndFlush(scoreSheet);
    }

    @Override
    public void deleteScoreSheetById(int id) {
    scoreSheetRepository.deleteById(id);
    }
}
