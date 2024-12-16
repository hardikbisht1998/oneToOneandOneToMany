package com.dataMapping.oneToOneandOneToMany.controllers;

import com.dataMapping.oneToOneandOneToMany.entities.DepartmentEntity;
import com.dataMapping.oneToOneandOneToMany.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{departmentId}")
    public DepartmentEntity getDepartmentById(@PathVariable Long departmentId) {
        return departmentService.getDepartmentById(departmentId);
    }

    @PostMapping
    public DepartmentEntity createNewDepartment(@RequestBody DepartmentEntity departmentEntity) {
        return departmentService.createNewDepartment(departmentEntity);
    }


    @PutMapping(path="{departmentId}/manager/{employeeId}")
    public DepartmentEntity assigneManagerToDepartment(@PathVariable Long departmentId,@PathVariable Long employeeId){
        return departmentService.assigneManagerToDepartment(departmentId,employeeId);
    }

    @GetMapping(path="/assignedDepartmentOfManeager/{employeeId}")
    public DepartmentEntity assignedDepartmentOfManeager(@PathVariable Long employeeId){
        return departmentService.assignedDepartmentOfManeager(employeeId);
    }

    @PutMapping(path="/{departmentId}/worker/{employeeId}")
    public DepartmentEntity assigneWorkerToDepartment(@PathVariable Long departmentId,@PathVariable Long employeeId){
        return departmentService.assigneWorkerToDepartment(departmentId,employeeId);
    }


    @PutMapping(path="/{departmentId}/freelancer/{employeeId}")
    public DepartmentEntity assignFreelancerToDepartment(@PathVariable Long departmentId,@PathVariable Long employeeId){
        return departmentService.assignFreelancerToDepartment(departmentId,employeeId);
    }

}