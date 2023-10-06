package com.empservice.empapplication.employeerepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empservice.empapplication.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{


	//@Query("SELECT c FROM ClassMst c WHERE c.school.id=:id AND c.active=:active")
	//List<ClassMst> getClassesBySchoolId(@Param("id") Long id,@Param("active") boolean active);

	//@Query("SELECT * FROM emp e,address a WHERE e.id=:a.Id")
	//List<Employee> getAllEmployeeDetailsById(@Param("id") Long id);

}
