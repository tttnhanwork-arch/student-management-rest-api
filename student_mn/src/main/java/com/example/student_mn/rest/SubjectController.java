package com.example.student_mn.rest;

import com.example.student_mn.entity.ScoreSheet;
import com.example.student_mn.entity.Subject;
import com.example.student_mn.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {
    private SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public List<Subject> getAllSubject() {
        return subjectService.getAllSubject();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subject> findSubjectById(@PathVariable int id) {
        Subject subject = subjectService.findSubjectById(id);
        if (subject != null)
            return ResponseEntity.ok(subject);
        else return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Subject> addSubject(@RequestBody Subject subject) {
        subjectService.addSubject(subject);
        return ResponseEntity.status(HttpStatus.CREATED).body(subject);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable int id, @RequestBody Subject subject) {
        Subject existSubject = subjectService.findSubjectById(id);
        if (existSubject != null) {
            existSubject.setName(subject.getName());
            existSubject.setPeriod(subject.getPeriod());
            subjectService.addSubject(existSubject);
            return ResponseEntity.ok(existSubject);
        } else
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubjectById(@PathVariable int id){
        Subject existSubject = subjectService.findSubjectById(id);
        if (existSubject!=null){
            List<ScoreSheet> scoreSheetsList = existSubject.getScoreSheets();
            for (ScoreSheet sc:scoreSheetsList){
                sc.setSubject(null);
            }
            subjectService.deleteSubjectById(id);
            return ResponseEntity.ok().build();
        } else return ResponseEntity.notFound().build();
    }
}
