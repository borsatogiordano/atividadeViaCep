package com.api.viacep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import classes.Cliente;

@SpringBootApplication
public class ViacepApplication {

	public static void main(String[] args) {
		SpringApplication.run(ViacepApplication.class, args);

		try {
			Cliente.addCliente();

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			Cliente.addCliente();
		}
	}
}
