package com.vander.cursoumc.config;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.vander.cursoumc.domain.Categoria;
import com.vander.cursoumc.domain.Produto;
import com.vander.cursoumc.repositories.CategoriaRepository;
import com.vander.cursoumc.repositories.ProdutoRepository;

@Configuration
public class Initialization implements CommandLineRunner {

	@Autowired
	private CategoriaRepository cateRepo;
	@Autowired
	private ProdutoRepository prodRepo;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Inicializou.... ");

		Categoria c1 = new Categoria(null, "Informática");
		Categoria c2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", BigDecimal.valueOf(2000.00));
		Produto p2 = new Produto(null, "Impressora", BigDecimal.valueOf(800.00));
		Produto p3 = new Produto(null, "Mouse", BigDecimal.valueOf(80.00));

		c1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		c2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(c1));
		p2.getCategorias().addAll(Arrays.asList(c1,c2));
		p3.getCategorias().addAll(Arrays.asList(c1));
		
		cateRepo.saveAll(Arrays.asList(c1, c2));
		prodRepo.saveAll(Arrays.asList(p1,p2,p3));
	}

}
