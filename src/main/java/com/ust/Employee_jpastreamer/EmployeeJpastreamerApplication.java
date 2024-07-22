package com.ust.Employee_jpastreamer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages={"com.ust.Employee_jpastreamer", "com.speedment.jpastreamer"})
public class EmployeeJpastreamerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeJpastreamerApplication.class, args);
	}

}
