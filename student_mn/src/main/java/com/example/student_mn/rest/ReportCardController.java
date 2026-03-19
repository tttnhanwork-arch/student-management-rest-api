package com.example.student_mn.rest;

import com.example.student_mn.entity.ReportCard;
import com.example.student_mn.service.ReportCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reportcard")
public class ReportCardController {
    private ReportCartService reportCartService;
@Autowired
    public ReportCardController(ReportCartService reportCartService) {
        this.reportCartService = reportCartService;
    }
    @GetMapping
    public List<ReportCard> getAllRC(){
    return reportCartService.getAllRC();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ReportCard> findRCById(@PathVariable int id){
    ReportCard reportCard = reportCartService.findRCById(id);
    if (reportCard!=null){
        return ResponseEntity.ok(reportCard);
    }else return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<ReportCard> addRC(@RequestBody ReportCard reportCard){
    reportCartService.addRC(reportCard);
    return ResponseEntity.status(HttpStatus.CREATED).body(reportCard);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ReportCard> updateRC(@PathVariable int id, @RequestBody ReportCard reportCard){
    ReportCard existReportCard = reportCartService.findRCById(id);
    if (existReportCard!=null){
        existReportCard.setComment(reportCard.getComment());
        existReportCard.setGPA(reportCard.getGPA());
        existReportCard.setSemester(reportCard.getSemester());
        existReportCard.setConduct(reportCard.getConduct());
        existReportCard.setStudent(reportCard.getStudent());
        reportCartService.updateRC(existReportCard);
        return ResponseEntity.ok(existReportCard);
    } else return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRCById(@PathVariable int id){
    ReportCard existReportCard = reportCartService.findRCById(id);
    if (existReportCard!=null){
        reportCartService.deleteRCById(id);
        return ResponseEntity.ok().build();
    } else return ResponseEntity.notFound().build();
    }
}
