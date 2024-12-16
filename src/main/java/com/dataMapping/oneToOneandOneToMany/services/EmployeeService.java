package com.dataMapping.oneToOneandOneToMany.services;

import com.dataMapping.oneToOneandOneToMany.entities.EmployeeEntity;
import com.dataMapping.oneToOneandOneToMany.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;


    public EmployeeEntity createNewEmployee(EmployeeEntity employeeEntity) {

        return employeeRepository.save(employeeEntity);
    }

    public EmployeeEntity getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }
}
