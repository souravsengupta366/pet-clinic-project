package com.sourav.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sourav.petclinic")
public class PetClinicApplication {


	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PetClinicApplication.class, args);

	}

}
