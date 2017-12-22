package me.jlblog.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import me.jlblog.example.domain.Customer;
import me.jlblog.example.service.CustomerService;

@EnableAutoConfiguration
@ComponentScan
public class App3 implements CommandLineRunner {

	@Autowired 
	CustomerService customerService;
	
	@Override
	public void run(String... args) throws Exception {
		// add data
		customerService.save(new Customer(1, "Nobita", "NObi"));
		customerService.save(new Customer(2, "Takeshi", "Goda"));
		customerService.save(new Customer(3, "Suneo", "Honekawa"));
		
		// view data
		customerService.findAll().forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(App3.class, args);
	}
	

}
