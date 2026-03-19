package com.example.student_mn.service;

import com.example.student_mn.dao.ReportCardRepository;
import com.example.student_mn.entity.ReportCard;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportCartServiceImpl implements ReportCartService {
    private ReportCardRepository reportCardRepository;
@Autowired
    public ReportCartServiceImpl(ReportCardRepository reportCardRepository) {
        this.reportCardRepository = reportCardRepository;
    }

    @Override
    public List<ReportCard> getAllRC() {
        return reportCardRepository.findAll();
    }

    @Override
    public ReportCard findRCById(int id) {
        return reportCardRepository.findById(id).orElseThrow(() -> new RuntimeException("Report card is not found !!!"));
    }

    @Override
    @Transactional
    public ReportCard addRC(ReportCard reportCard) {
        return reportCardRepository.save(reportCard);
    }

    @Override
    @Transactional
    public ReportCard updateRC(ReportCard reportCard) {
        return reportCardRepository.saveAndFlush(reportCard);
    }

    @Override
    @Transactional
    public void deleteRCById(int id) {
    reportCardRepository.deleteById(id);
    }
}
