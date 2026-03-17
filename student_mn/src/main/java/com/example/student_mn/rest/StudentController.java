package com.example.student_mn.rest;

import com.example.student_mn.entity.Student;
import com.example.student_mn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private StudentService studentService;
@Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> getAllStudent(){
    return studentService.getAllStudent();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id){
    Student student = studentService.findStudentById(id);
    if (student!=null){
        return ResponseEntity.ok(student);
    }
    else return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
    studentService.addStudent(student);
    return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable int id, @RequestBody Student student){
    Student existStudent = studentService.findStudentById(id);
    if (existStudent!=null){
        existStudent.setaClass(student.getaClass());
        existStudent.setDOB(student.getDOB());
        existStudent.setEmail(student.getEmail());
        existStudent.setParent(student.getParent());
        existStudent.setFirstName(student.getFirstName());
        existStudent.setLastName(student.getLastName());
        studentService.updateStudent(existStudent);
        return ResponseEntity.ok(existStudent);
    }else return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable int id){
    Student existStudent = studentService.findStudentById(id);
    if (existStudent!=null){
        studentService.deleteStudentById(id);
        return ResponseEntity.ok().build();
    }
    else return ResponseEntity.notFound().build();
    }
}
