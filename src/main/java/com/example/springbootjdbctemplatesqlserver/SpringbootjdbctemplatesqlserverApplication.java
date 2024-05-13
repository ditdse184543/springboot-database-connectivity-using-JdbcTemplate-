package com.example.springbootjdbctemplatesqlserver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication(scanBasePackages = "com.example")
public class SpringbootjdbctemplatesqlserverApplication implements CommandLineRunner {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootjdbctemplatesqlserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String sql = "select * from customers";
		List<Customer> customers =jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(Customer.class));
		for (Customer customer : customers) {
			System.out.println(customer);
			
		}
	}

}
