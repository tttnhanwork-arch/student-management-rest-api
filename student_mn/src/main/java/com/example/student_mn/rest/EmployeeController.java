package com.example.student_mn.rest;

import com.example.student_mn.entity.Employee;
import com.example.student_mn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private EmployeeService employeeService;
@Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public List<Employee> getAllEmployee(){
    return employeeService.getAllEmployee();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable int id){
    Employee employee = employeeService.findEmployeeById(id);
    if (employee!=null){
        return ResponseEntity.ok(employee);
    } else return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
    employeeService.addEmployee(employee);
    return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee){
    Employee existEmployee = employeeService.findEmployeeById(id);
    if (existEmployee!=null){
        existEmployee.setEmail(employee.getEmail());
        existEmployee.setFirstName(employee.getFirstName());
        existEmployee.setRole(employee.getRole());
        existEmployee.setPhone(employee.getPhone());
        existEmployee.setLastName(employee.getLastName());
        existEmployee.setSchool(employee.getSchool());
        employeeService.updateEmployee(existEmployee);
        return ResponseEntity.ok(existEmployee);
    } else return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id){
    Employee existEmployee = employeeService.findEmployeeById(id);
    if (existEmployee!=null){
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok().build();
    } else return ResponseEntity.notFound().build();
    }
}
