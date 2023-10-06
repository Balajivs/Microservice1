package com.empservice.empapplication.openfeign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value="ADDRESS-SERVICE",path="/address-app/api")
public interface AddressClient {

	/*
	
	
	@GetMapping("/address/{employeeId}")
	public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable (value= "employeeId") Long employeeId);
	 
	public ResponseEntity<List<AddressResponse>> getAllAddress();
	
	*/
}
