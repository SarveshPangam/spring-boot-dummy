package com.example.demo.entity;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.enums.EmployeeDesignation;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Min(1)
    private Long salary;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private EmployeeDesignation designation;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdOn;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedOn;

    public EmployeeEntity(){}

    public EmployeeEntity(Long id, String name, Long salary, EmployeeDesignation designation) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.designation = designation;
    }

    public EmployeeDto toDto() {
        return new EmployeeDto(this.id, this.name, this.salary, this.designation);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getSalary() {
        return salary;
    }

    public EmployeeDesignation getDesignation() {
        return designation;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public EmployeeEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public EmployeeEntity setName(String name) {
        this.name = name;
        return this;
    }

    public EmployeeEntity setSalary(@Min(1) Long salary) {
        this.salary = salary;
        return this;
    }

    public EmployeeEntity setDesignation(EmployeeDesignation designation) {
        this.designation = designation;
        return this;
    }

    public EmployeeEntity setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public EmployeeEntity setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }
}