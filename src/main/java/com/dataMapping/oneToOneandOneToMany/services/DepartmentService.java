package com.dataMapping.oneToOneandOneToMany.services;

import com.dataMapping.oneToOneandOneToMany.entities.DepartmentEntity;
import com.dataMapping.oneToOneandOneToMany.entities.EmployeeEntity;
import com.dataMapping.oneToOneandOneToMany.repositories.DepartmentRepository;
import com.dataMapping.oneToOneandOneToMany.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public DepartmentEntity getDepartmentById(Long departmentId) {

       return departmentRepository.findById(departmentId).orElse(null);
    }

    public DepartmentEntity createNewDepartment(DepartmentEntity departmentEntity) {
        return departmentRepository.save(departmentEntity);
    }

    public DepartmentEntity assigneManagerToDepartment(Long departmentId, Long employeeId) {
        Optional<DepartmentEntity> department=departmentRepository.findById(departmentId);
        Optional<EmployeeEntity> employee=employeeRepository.findById(employeeId);

        return department.flatMap(x->
                    employee.map(y-> {
                        x.setManager(y);
                    return departmentRepository.save(x);}
                    )).orElse(null);
    }

    public DepartmentEntity assignedDepartmentOfManeager(Long employeeId) {
//        Optional<EmployeeEntity> employee=employeeRepository.findById(employeeId);
//        return employee.map(x->x.getManagedDepartment()).orElse(null);
        EmployeeEntity employee=EmployeeEntity.builder().id(employeeId).build();
        return departmentRepository.findByManager(employee);
    }

    public DepartmentEntity assigneWorkerToDepartment(Long departmentId, Long employeeId) {
        Optional<EmployeeEntity> employeeEntity=employeeRepository.findById(employeeId);
        Optional<DepartmentEntity> departmentEntity=departmentRepository.findById(departmentId);

        return departmentEntity.flatMap(department->
                                                        employeeEntity.map(employee->{
                                                         employee.setWorkerDepartment(department);
                                                         employeeRepository.save(employee);
                                                           department.getWorkers().add(employee);
                                                            return department;}
                                                            )).orElse(null);


    }

    public DepartmentEntity assignFreelancerToDepartment(Long departmentId, Long employeeId) {

        Optional<EmployeeEntity> employeeEntity=employeeRepository.findById(employeeId);
        Optional<DepartmentEntity> departmentEntity=departmentRepository.findById(departmentId);

        return departmentEntity.flatMap(department->
                employeeEntity.map(employee->{
                    employee.getFreelanceDepartments().add(department);
                   employeeRepository.save(employee);
                   department.getFreelancers().add(employee);
                    return department;}
                )).orElse(null);


    }
}
