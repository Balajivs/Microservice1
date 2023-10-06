package com.empservice.empapplication.service;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.empservice.empapplication.employeerepository.EmployeeRepository;
import com.empservice.empapplication.employeeresponse.AddressResponse;
import com.empservice.empapplication.employeeresponse.EmployeeResponse;
import com.empservice.empapplication.entity.Address;
import com.empservice.empapplication.entity.Employee;

@Service
public class EmployeeService {

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	//@Autowired
	//private AddressClient addressClient;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${addreeservice.base.url}")
	private String addressBaseURL;
	
	@Value("${addresssaveservice.base.url}")
	private String addresssaveserviceURL;
	
	
	/*public EmployeeService(RestTemplateBuilder builder) {
		
		this.restTemplate = builder
							.rootUri(addressURL)
		                    .build();
		
	}*/
	
	
	
	//@Autowired
	//private RestTemplate restTemlate;
	
	//@Autowired
	//@private AddressResponse addressResponse;
	
	
	
	/*public Employee getEmployeeById(int id) {
		Employee employee = employeeRepository.findById(id).get();

		return employee;
	}*/
	
	
	/*public EmployeeResponse getEmployeeById(int id) {
	
		Employee employee = employeeRepository.findById(id).get();
		EmployeeResponse employeeResponse = new EmployeeResponse();
		
		employeeResponse.setId(employee.getId());
		employeeResponse.setName(employee.getName());
		employeeResponse.setBloodgroup(employee.getBloodgroup());
		employeeResponse.setEmail(employee.getEmail());
	
		return employeeResponse;
		
}*/
	
	

	public EmployeeResponse getEmployeeById(int id) {
		
		
		// addressResponse ->set data by making a rest api call 
		
		
		Employee employee = employeeRepository.findById(id).get();
		
		EmployeeResponse employeeResponse= modelMapper.map(employee, EmployeeResponse.class);
		
		AddressResponse addressResponse = restTemplate.getForObject(addressBaseURL + "/address/{id}", AddressResponse.class,id); 
		
		employeeResponse.setAddressResponse(addressResponse);
		
		return employeeResponse;
	}
	
	public List<Employee> getAllEmployeeDetails() {
		
		List<Employee> employeeList = employeeRepository.findAll();
		
		
		List<EmployeeResponse>  empList = Arrays.asList(modelMapper.map(employeeList, EmployeeResponse.class));
		
		//ResponseEntity<List<AddressResponse>>  employeeResponse = addressClient.getAllAddress();
		  
		//List<AddressResponse> addressRes  = employeeResponse.getBody();
		
		//EmployeeResponse response = new EmployeeResponse();
		
		//body
		//AddressResponse addResponse = restTemplate.getForObject(addressBaseURL + "/address/{id}", AddressResponse.class);
		
		//employeeResponse.setAddressResponse(addResponse);
		
		return employeeList;
		
	}

	/*
	 * public List<Employee> saveEmployeeDetails() {
	 * 
	 * 
	 * return null; }
	 */
	
	
	public void addProductCatalog(Employee employye, Address address) {

		 employeeRepository.save(employye);
		
		ResponseEntity<Object> response = restTemplate.postForEntity(" http://localhost:8090/address-app/api/address", employye,
				null, address);
		
	}

	/*public Employee saveEmployee(Employee employee) {

		Address address = new Address();

		return employeeRepository.save(employee);

	}*/
	
	
}
