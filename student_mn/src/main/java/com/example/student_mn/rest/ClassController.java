package com.example.student_mn.rest;

import com.example.student_mn.dao.ClassRepository;
import com.example.student_mn.entity.Class;
import com.example.student_mn.entity.School;
import com.example.student_mn.entity.Student;
import com.example.student_mn.service.ClassService;
import com.example.student_mn.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/class")
public class ClassController {
    private ClassService classService;
    @Autowired
    public ClassController(ClassService classService){
        this.classService=classService;
    }

    @GetMapping
    public List<Class> getAllClass(){
        return classService.getAllClass();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Class> findClassById(@PathVariable int id){
        Class aclass = classService.findClassById(id);
        if (aclass!=null)
            return ResponseEntity.ok(aclass);
        else return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Class> addClass(@RequestBody Class aclass){
        classService.addClass(aclass);
        return ResponseEntity.status(HttpStatus.CREATED).body(aclass);
    }
    @PutMapping ("/{id}")
    public ResponseEntity<Class> updateClassById(@PathVariable int id, @RequestBody Class aclass){
        Class existClass = classService.findClassById(id);
        if (existClass!=null){
            existClass.setGrade(aclass.getGrade());
            existClass.setName(aclass.getName());
            existClass.setYear(aclass.getYear());
            existClass.setSchool(aclass.getSchool());
            existClass.setTeacher(aclass.getTeacher());
            classService.updateClass(existClass);
            return ResponseEntity.ok(existClass);
        } else return ResponseEntity.notFound().build();
    }
@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClassById(@PathVariable int id){
        Class existClass = classService.findClassById(id);
        if (existClass!=null){
            List<Student> student = existClass.getStudents();
            for (Student student1:student){
                student1.setaClass(null);
            }
            classService.deleteClassById(id);
            return ResponseEntity.ok().build();
        }else  return ResponseEntity.notFound().build();
}

}
