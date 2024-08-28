package com.example.demo.dto;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.enums.EmployeeDesignation;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmployeeDto(
        Long id,
        @NotNull @NotBlank String name,
        @NotNull @Min(1) Long salary,
        @NotNull EmployeeDesignation designation
) {
    public EmployeeEntity toEntity() {
        return new EmployeeEntity(id, name, salary, designation);
    }
}
