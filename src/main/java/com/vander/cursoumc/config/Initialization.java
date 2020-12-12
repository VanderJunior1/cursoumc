package com.vander.cursoumc.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.vander.cursoumc.domain.Categoria;
import com.vander.cursoumc.repositories.CategoriaRepository;

@Configuration
public class Initialization implements CommandLineRunner {

	@Autowired
	private CategoriaRepository cateRepo;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Inicializou.... ");

		Categoria c1 = new Categoria(null, "Informática");
		Categoria c2 = new Categoria(null, "Escritório");

		cateRepo.saveAll(Arrays.asList(c1, c2));

	}

}
