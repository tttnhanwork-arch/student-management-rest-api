package com.example.student_mn.rest;

import com.example.student_mn.entity.School;
import com.example.student_mn.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/school")
public class SchoolController {
    private SchoolService schoolService;
    @Autowired
    public SchoolController (SchoolService schoolService){
        this.schoolService=schoolService;
    }
    @GetMapping
    public List<School> getAllSchool(){
        return schoolService.getAllSchool();
    }
    @GetMapping("/{id}")
    public ResponseEntity<School> findSchoolById(@PathVariable int id){
        School school = schoolService.findSchoolById(id);
        if (school!=null)
            return ResponseEntity.ok(school);
        else return  ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<School> saveSchool(@RequestBody School school){
        schoolService.addSchool(school);
        return ResponseEntity.status(HttpStatus.CREATED).body(school);
    }
    @PutMapping("/{id}")
    public ResponseEntity<School> updateSchool(@PathVariable int id, @RequestBody School school){
        School existSchool = schoolService.findSchoolById(id);
        if (existSchool!=null){
            existSchool.setAddress(school.getAddress());
            existSchool.setName(school.getName());
            existSchool.setPhoneNumber(school.getPhoneNumber());
            existSchool.setPrincipal(school.getPrincipal());
            schoolService.updateSchool(existSchool);
            return ResponseEntity.ok(existSchool);
        } else return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchoolById(@PathVariable int id){
        School existSchool = schoolService.findSchoolById(id);
        if (existSchool!=null){
            schoolService.deleteSchoolById(id);
            return ResponseEntity.ok().build();
        } else return ResponseEntity.notFound().build();
    }
}
