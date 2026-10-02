package com.module1.firstModule.services;

import com.module1.firstModule.dto.EmployeeDto;
import com.module1.firstModule.entities.EmployeeEntity;
import com.module1.firstModule.exceptions.ResourcesNotFoundException;
import com.module1.firstModule.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeEntity> empList = employeeRepository.findAll();
        return empList
                .stream()
                .map(emp -> modelMapper.map(emp, EmployeeDto.class))
                .toList();
//                .collect();
    }

    public EmployeeDto createEmployee(EmployeeDto body) {
        EmployeeEntity emp = modelMapper.map(body,EmployeeEntity.class);
        EmployeeEntity savedEmp = employeeRepository.save(emp);
        return modelMapper.map(savedEmp, EmployeeDto.class);
    }

    public EmployeeDto getEmpById(Long empId) {
        EmployeeEntity emp = getEmployeeById(empId);
        return modelMapper.map(emp,EmployeeDto.class);
    }

    private EmployeeEntity getEmployeeById(Long empId){
        return employeeRepository
                .findById(empId)
                .orElseThrow(()-> new ResourcesNotFoundException("Employee not found by id "+empId));
    }
}
