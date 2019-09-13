package com.example.controller;

import java.net.URI;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.EmployeeDAO;
import com.example.exception.CustomException;
import com.example.model.Result;
import com.example.service.EmployeeService;
import com.example.model.Employee;


@RestController
public class EmployeeController implements EmployeeService{
	@Autowired
	EmployeeDAO employeeDAO;
	
	@RequestMapping(value="/CreateEmployee",method = RequestMethod.POST)
	public ResponseEntity<Result> createEmployee(@RequestBody Employee emp) {
		Result output = new Result();
		
		try {
			
			
			int result = employeeDAO.insertEmployee(emp);
			
			
			
			if(result>=0) {
				output.setResult(String.valueOf(result)+" records are created");
			}else {
				throw new CustomException();
			}
		 
		}catch(CustomException e) {
			 new CustomException("exception occured");
		}
		
		return new ResponseEntity<Result>(output,HttpStatus.CREATED);
			
			
	}
	
	@RequestMapping(value="/UpdateEmployee/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Result> updateEmployee(@RequestBody Employee emp,@PathVariable("id") String employeeid) {
		Result output = new Result();
		
		try {
			
			emp.setEmployeeid(employeeid);
			int result = employeeDAO.updateEmployee(emp);
			if(result>=0) {
				output.setResult(String.valueOf(result)+" records are updated");
			}else {
				throw new CustomException();
			}
				
		
		 
		}catch(CustomException e) {
			 new CustomException("exception occured");
		}
		
		return new ResponseEntity<Result>(output,HttpStatus.OK);
			
			
	}
	
	@RequestMapping(value="/RetriveEmployee/{id}",method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> retriveEmployee(@PathVariable("id") String empid) {
		List<Employee> result = new ArrayList<Employee>();
		
		try {
			
			String employeeid = empid;
			 result = employeeDAO.retriveEmployee(employeeid);
			
			
			
		
		 
		}catch(CustomException e) {
			 new CustomException("exception occured");
		}
		
		return new ResponseEntity<List<Employee>>(result,HttpStatus.OK);
			
			
	}
	
	@RequestMapping(value="/DeleteEmployee/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Result> deleteEmployee(@PathVariable("id") String empid) {
		Result output = new Result();
		int result = 0;
		
		try {
			
			String employeeid = empid;
			 result = employeeDAO.deleteEmployee(employeeid);
			
			
			if(result>=0) {
				output.setResult(String.valueOf(result)+" records are deleted");
			}else {
				throw new CustomException();
			}
				
		
		 
		}catch(CustomException e) {
			 new CustomException("exception occured");
		}
		
		return new ResponseEntity<Result>(output,HttpStatus.OK);
			
			
	}

}
