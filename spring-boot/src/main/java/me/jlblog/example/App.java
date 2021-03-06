package me.jlblog.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import me.jlblog.example.app.Frontend;

@EnableAutoConfiguration
@ComponentScan
public class App {
	public static void main(String[] args) {
		try (ConfigurableApplicationContext context = SpringApplication.run(App.class, args)){
			Frontend frontend = context.getBean(Frontend.class);
			frontend.run();
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
