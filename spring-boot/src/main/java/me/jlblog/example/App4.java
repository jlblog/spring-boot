package me.jlblog.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import me.jlblog.example.domain.Customer;

@EnableAutoConfiguration
@ComponentScan
public class App4 implements CommandLineRunner {
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public void run(String... args) throws Exception {
		String sql = "SELECT id, first_name, last_name FROM customers WHERE id = :id";
		SqlParameterSource param = new MapSqlParameterSource()
									.addValue("id", 3);
		Customer result = jdbcTemplate.queryForObject(sql, param, (rs, rowNUm) -> new Customer(rs.getInt("id"),
				rs.getString("first_name"), rs.getString("last_name"))
				);
		
		System.out.println("result = " + result);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(App4.class, args);
	}
}
