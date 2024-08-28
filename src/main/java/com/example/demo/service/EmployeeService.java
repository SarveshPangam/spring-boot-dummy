package com.example.demo.service;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDto> getAll() {
        return employeeRepository.findAll().stream()
                .map(EmployeeEntity::toDto)
                .toList();
    }

    public EmployeeDto getById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id))
                .toDto();
    }

    public EmployeeDto save(EmployeeDto employeeDto) {
        return employeeRepository.save(employeeDto.toEntity())
                .toDto();
    }

    public EmployeeDto update(Long id, EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        employeeEntity.setName(employeeDto.name())
                .setSalary(employeeDto.salary())
                .setDesignation(employeeDto.designation());

        return save(employeeEntity.toDto());
    }

    public void deleteById(Long id) {
        if (!employeeRepository.existsById(id))
            throw new EmployeeNotFoundException(id);
        employeeRepository.deleteById(id);
    }
}
