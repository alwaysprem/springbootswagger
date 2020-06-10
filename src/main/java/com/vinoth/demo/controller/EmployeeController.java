package com.vinoth.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vinoth.demo.model.Employee;
import com.vinoth.demo.service.EmployeeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/rest/employee/data")
public class EmployeeController {

	@Autowired
	private EmployeeService empServiceObj;

	@ApiOperation(value = "Hello World")
	@ApiResponse(code = 200, message = "xxxxxx")
	@RequestMapping(value = "/helloworld", method = RequestMethod.GET)
	@ResponseBody
	public String postFoos() {
		return "Hello World";
	}

	@GetMapping("/get1")
	public Employee firstPage() {

		Employee emp = new Employee();

		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(3001);

		return emp;
	}

	@ApiOperation(value = "Employe Data")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Vinoth message 200"),
			@ApiResponse(code = 101, message = "Vinoth message 101") })
	@GetMapping("/get2")
	public Employee empServiceCall() {
		return empServiceObj.toGetService();
	}

	@PostMapping("/post1")
	public Employee empServicePostCall(@RequestBody Employee empdata) {
		return empServiceObj.toPostService(empdata);
	}
}
