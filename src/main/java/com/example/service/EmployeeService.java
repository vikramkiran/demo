package com.example.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.model.Employee;
import com.example.model.Result;

@Service
public interface EmployeeService {
	public  ResponseEntity<Result> createEmployee( Employee emp);
	public ResponseEntity<Result> updateEmployee(Employee emp, String employeeid);
	public ResponseEntity<List<Employee>> retriveEmployee( String empid);
	public ResponseEntity<Result> deleteEmployee(String empid) ;
	

}
