package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.controller.EmployeeController;
import com.example.dao.EmployeeDAO;
import com.example.exception.CustomException;
import com.example.exception.ExceptonHandlerAdvice;
import com.example.mapper.MappingResponse;
import com.example.service.EmployeeService;



@SpringBootApplication
@ComponentScan(basePackageClasses = {EmployeeController.class,EmployeeDAO.class,ExceptonHandlerAdvice.class,EmployeeService.class,CustomException.class,MappingResponse.class})
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
