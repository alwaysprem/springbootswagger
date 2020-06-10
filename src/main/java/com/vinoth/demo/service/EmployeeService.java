package com.vinoth.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinoth.demo.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private Employee empModel;// =new Employee();

	public Employee toGetService() {
		empModel.setName("emp1");
		empModel.setDesignation("manager");
		empModel.setEmpId("1");
		empModel.setSalary(3002);
		return empModel;
	}

	public Employee toPostService(Employee empData) {
		return empData;

	}
}
