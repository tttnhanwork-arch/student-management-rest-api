package com.example.student_mn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "school")
public class School {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_school;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "principal")
    private String principal;
    @OneToMany(mappedBy = "school", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JsonIgnore
private List<Employee> employees;
    @OneToMany(mappedBy = "school", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JsonIgnore
private List<Class> classes;
    public School() {
    }

    public School(String name, String address, String phoneNumber, String principal) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.principal = principal;
    }

    public School(String name, String address, String phoneNumber, String principal, List<Employee> employees) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.principal = principal;
        this.employees = employees;
    }

    public School(String name, String address, String phoneNumber, String principal, List<Employee> employees, List<Class> classes) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.principal = principal;
        this.employees = employees;
        this.classes = classes;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public int getId_school() {
        return id_school;
    }

    public void setId_school(int id_school) {
        this.id_school = id_school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id_school +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", principal='" + principal + '\'' +
                '}';
    }
}
