package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.exception.CustomException;
import com.example.mapper.MappingResponse;
import com.example.model.Employee;


@Repository
public class EmployeeDAO {
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	MappingResponse mappingResponse;
	
	@Transactional
	public int insertEmployee(Employee emp) throws CustomException {
		int result = 0;
		final String sql = "insert into employee(employeeid, firstname,lastname , email,addressline,city) values(:employeeid,:firstname,:lastname,:email,:addressline,:city)";
		        
		        SqlParameterSource param = new MapSqlParameterSource()
		.addValue("employeeid", Integer.valueOf((emp.getEmployeeid())))
		.addValue("firstname", emp.getFirstname())
		.addValue("lastname", emp.getLastname())
		.addValue("email", emp.getEmail())
		.addValue("addressline",emp.getAddressline())
		.addValue("city",emp.getCity()) ;
		       
		       
				result = namedParameterJdbcTemplate.update(sql, param);
		
				return result;
		}
	
	@Transactional
	public int updateEmployee(Employee emp) throws CustomException {
		int result = 0;
		final String sql = "update employee set firstname = :firstname,lastname=:lastname, email=:email ,addressline=:addressline,city=:city where employeeid=:employeeid";
		        
		        SqlParameterSource param = new MapSqlParameterSource()
		.addValue("employeeid", Integer.valueOf((emp.getEmployeeid())))
		.addValue("firstname", emp.getFirstname())
		.addValue("lastname", emp.getLastname())
		.addValue("email", emp.getEmail())
		.addValue("addressline",emp.getAddressline())
		.addValue("city",emp.getCity()) ;
		       
		       
				result = namedParameterJdbcTemplate.update(sql, param);
		
				return result;
		}
	
	@Transactional
	public List<Employee> retriveEmployee(String employeeid) throws CustomException {
		List<Employee> result = null;
		final String sql = "select employeeid,firstname,lastname,email,addressline,city from employee where employeeid=:employeeid";
		        
		        SqlParameterSource param = new MapSqlParameterSource()
		.addValue("employeeid", Integer.valueOf((employeeid))) ;
		       
		        System.out.println("inaisde test db");
				List<Employee> empResult = namedParameterJdbcTemplate.query(sql, param, mappingResponse);
		
				return empResult;
		}
	
	@Transactional
	public int deleteEmployee(String employeeid) throws CustomException {
		int result = 0;
		final String sql = "delete from employee where employeeid=:employeeid";
		        
		        SqlParameterSource param = new MapSqlParameterSource()
		.addValue("employeeid", Integer.valueOf((employeeid))) ;
		       
		       
				int empResult = namedParameterJdbcTemplate.update(sql, param);
		
				return empResult;
		}

}
