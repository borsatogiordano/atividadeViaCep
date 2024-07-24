package com.api.viacep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import classes.Cliente;
import classes.Endereco;

@SpringBootApplication
public class ViacepApplication {

	public static void main(String[] args) {
		SpringApplication.run(ViacepApplication.class, args);

		Cliente.addCliente();
	}
}
