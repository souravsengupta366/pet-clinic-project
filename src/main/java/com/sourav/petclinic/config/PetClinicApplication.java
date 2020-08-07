package com.sourav.petclinic.config;

import com.sourav.petclinic.controller.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sourav.petclinic")
public class PetClinicApplication {


	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PetClinicApplication.class, args);

		MyController controller = (MyController) context.getBean("myController");

		String greetings = controller.sayHello();
		System.out.println(greetings);

		String langGreet = controller.i18Hello();

	}

}
