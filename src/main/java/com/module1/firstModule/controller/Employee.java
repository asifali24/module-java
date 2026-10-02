package com.module1.firstModule.controller;


import com.module1.firstModule.dto.EmployeeDto;
import com.module1.firstModule.entities.EmployeeEntity;
import com.module1.firstModule.repository.EmployeeRepository;
import com.module1.firstModule.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path = "/employee")
public class Employee {

    private final EmployeeService employeeService;

    public Employee(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getEmployee(){
        System.out.println("Employee.....");
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody @Valid EmployeeDto body){
        EmployeeDto emp =  employeeService.createEmployee(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(emp);
    }

    @GetMapping("/{empId}")
    public ResponseEntity<EmployeeDto> GetEmployeeById(@PathVariable Long empId){
        EmployeeDto emp = employeeService.getEmpById(empId);
        if(emp == null ) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(emp);
    }



}
