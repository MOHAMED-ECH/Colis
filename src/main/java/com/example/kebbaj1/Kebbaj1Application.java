package com.example.kebbaj1;

import com.example.kebbaj1.entities.CentreLocale;
import com.example.kebbaj1.entities.CentrePostale;
import com.example.kebbaj1.entities.CentreRegional;
import com.example.kebbaj1.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Kebbaj1Application {

	public static void main(String[] args) {
		SpringApplication.run(Kebbaj1Application.class, args);
	}


	@Autowired
	CentrePostalRepo centrePostalRepo;


	@Autowired
	CentreRegionalRepo centreRegionalRepo;


	@Autowired
	FacteurRepo facteurRepo;


	@Autowired
	HabitantRepo habitantRepo;

	@Autowired
	ColisRepo colisRepo;

	@Autowired
	PersonneRepo personneRepo;


	@Autowired
	CentreLocaleRepo centreLocaleRepo;








	@Bean
	CommandLineRunner coucou(){
		return args -> {
			System.out.println("coucou");


			CentreRegional centreR = new CentreRegional("jkjk", 5, "yassin", "aymane", "marwa");

			centreRegionalRepo.save(centreR);

			CentrePostale centreP = new CentrePostale("ibtihal", 4, "amal", "coucou", "coucou2");

		centreP.setCentreRegional(centreR);

			centrePostalRepo.save(centreP);

			System.out.println("<<<<<<<<<<<<<<<<<<<<<<centres postaux :");


			centrePostalRepo.findAll().forEach(System.out::println);








		};
	}

}
