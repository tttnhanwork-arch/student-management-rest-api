package com.example.student_mn.rest;

import com.example.student_mn.entity.Parent;
import com.example.student_mn.entity.Student;
import com.example.student_mn.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parent")
public class ParentController {
    private ParentService parentService;
@Autowired
    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }
    @GetMapping
    public List<Parent> getAllParen(){
    return parentService.getAllParent();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Parent> findParentById(@PathVariable int id){
    Parent parent = parentService.findParentByid(id);
    if (parent!=null)
        return ResponseEntity.ok(parent);
    else return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Parent> addParent(@RequestBody Parent parent){
    parentService.addParent(parent);
    return ResponseEntity.status(HttpStatus.CREATED).body(parent);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Parent> updateParent(@PathVariable int id, @RequestBody Parent parent){
    Parent existParent = parentService.findParentByid(id);
    if (existParent!=null){
        existParent.setEmail(parent.getEmail());
        existParent.setFirstName(parent.getFirstName());
        existParent.setPhone(parent.getPhone());
        existParent.setLastName(parent.getLastName());
        parentService.updateParent(existParent);
        return ResponseEntity.ok(existParent);
    }else return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
            public ResponseEntity<Void> deleteParent(@PathVariable int id){
        Parent existParent = parentService.findParentByid(id);
        if (existParent!=null){
            List<Student> studentList = existParent.getStudents();
            for (Student s1:studentList){
                s1.setParent(null);
            }
            parentService.deleteParentById(id);
            return ResponseEntity.ok().build();
        } else return ResponseEntity.notFound().build();
    }
}
