package com.dataMapping.oneToOneandOneToMany.repositories;

import com.dataMapping.oneToOneandOneToMany.entities.DepartmentEntity;
import com.dataMapping.oneToOneandOneToMany.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
    DepartmentEntity findByManager(EmployeeEntity employee);
}
