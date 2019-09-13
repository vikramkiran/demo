package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.example.dao.EmployeeDAO;



@Configuration
public class BeanConfig {
	
	@Bean
	public EmployeeDAO testDao() {
        return new EmployeeDAO();
    }
	
//	@Bean
//	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(){
//		return new NamedParameterJdbcTemplate(dataSource);
//	}

}
