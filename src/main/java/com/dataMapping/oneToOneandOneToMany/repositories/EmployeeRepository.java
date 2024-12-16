package com.dataMapping.oneToOneandOneToMany.repositories;

import com.dataMapping.oneToOneandOneToMany.entities.DepartmentEntity;
import com.dataMapping.oneToOneandOneToMany.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
