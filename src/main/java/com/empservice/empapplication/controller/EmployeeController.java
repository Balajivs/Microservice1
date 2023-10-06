package com.empservice.empapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.empservice.empapplication.employeeresponse.EmployeeResponse;
import com.empservice.empapplication.entity.Address;
import com.empservice.empapplication.entity.Employee;
import com.empservice.empapplication.service.EmployeeService;

@RestController
public class EmployeeController {


	@Autowired
	EmployeeService employeeService;

	/*@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable("id") int id) {

		Employee employee =employeeService.getEmployeeById(id);
		
		return employee;
	}*/
	
	@GetMapping("/employee/{id}")
	ResponseEntity<EmployeeResponse>  getEmployee(@PathVariable("id") int id) {
		EmployeeResponse empResponse = employeeService.getEmployeeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(empResponse);
	
}
	
	@GetMapping("/getAllemployee")
	ResponseEntity<Object>  getAllemployee() {
		List<Employee> empResponse =  employeeService.getAllEmployeeDetails();
		return new ResponseEntity<Object>(empResponse, HttpStatus.OK);
		// return new ResponseEntity<List<EmployeeResponse>>(entities, HttpStatus.OK);
	
}
	
	//
	
	
	@PostMapping("/employeeDetails")
	ResponseEntity<Employee> saveEmployeeDetails(@RequestBody Employee employee,@RequestBody Address address){
		 employeeService.addProductCatalog(employee, address);//saveEmployee(employee);
		return new ResponseEntity<Employee>(HttpStatus.CREATED);
	}

}