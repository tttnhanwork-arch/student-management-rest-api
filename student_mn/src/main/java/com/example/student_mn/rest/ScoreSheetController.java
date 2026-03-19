package com.example.student_mn.rest;

import com.example.student_mn.entity.ScoreSheet;
import com.example.student_mn.service.SchoolService;
import com.example.student_mn.service.ScoreSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scoresheet")
public class ScoreSheetController {
    private ScoreSheetService scoreSheetService;
    @Autowired
    public ScoreSheetController(ScoreSheetService scoreSheetService){
        this.scoreSheetService=scoreSheetService;
    }
    @GetMapping
    public List<ScoreSheet> getAllScoreSheet(){
        return scoreSheetService.getAllScoreSheet();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ScoreSheet> findScoreSheetById(@PathVariable int id){
        ScoreSheet scoreSheet = scoreSheetService.findScoreSheetById(id);
        if (scoreSheet!=null)
            return ResponseEntity.ok(scoreSheet);
        else return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<ScoreSheet> addScoreSheet(@RequestBody ScoreSheet scoreSheet){
        scoreSheetService.addScoreSheet(scoreSheet);
        return ResponseEntity.status(HttpStatus.CREATED).body(scoreSheet);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ScoreSheet> updateScoreSheet(@PathVariable int id, @RequestBody ScoreSheet scoreSheet){
        ScoreSheet existScoreSheet = scoreSheetService.findScoreSheetById(id);
        if (existScoreSheet!=null){
            existScoreSheet.setScore(scoreSheet.getScore());
            existScoreSheet.setStudent(scoreSheet.getStudent());
            existScoreSheet.setSubject(scoreSheet.getSubject());
            existScoreSheet.setDayOfTest(scoreSheet.getDayOfTest());
            scoreSheetService.updateScoreSheet(existScoreSheet);
            return ResponseEntity.ok(existScoreSheet);
        } else return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScoreSheetById(@PathVariable int id){
        ScoreSheet existScoreSheet = scoreSheetService.findScoreSheetById(id);
        if (existScoreSheet!=null){
            scoreSheetService.deleteScoreSheetById(id);
            return ResponseEntity.ok().build();
        }
            else return ResponseEntity.notFound().build();
    }
}
