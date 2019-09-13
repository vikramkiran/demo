package com.example.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.model.Employee;

@Component
public class MappingResponse implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		//List<Employee> empList = null ;
		// TODO Auto-generated method stub
		
		Employee emp = new Employee();
		emp.setEmployeeid(String.valueOf(rs.getInt("employeeid")));
		emp.setFirstname(rs.getString("firstname"));
		emp.setLastname(rs.getString("lastname"));
		emp.setEmail(rs.getString("email"));
		emp.setAddressline(rs.getString("addressline"));
		emp.setCity(rs.getString("city"));
		
		return emp;
	}

}
