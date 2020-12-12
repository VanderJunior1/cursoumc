package com.vander.cursoumc.config;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.vander.cursoumc.domain.Categoria;
import com.vander.cursoumc.domain.Cidade;
import com.vander.cursoumc.domain.Cliente;
import com.vander.cursoumc.domain.Endereco;
import com.vander.cursoumc.domain.Estado;
import com.vander.cursoumc.domain.Produto;
import com.vander.cursoumc.domain.enums.TipoCliente;
import com.vander.cursoumc.repositories.CategoriaRepository;
import com.vander.cursoumc.repositories.CidadeRepository;
import com.vander.cursoumc.repositories.ClienteRepository;
import com.vander.cursoumc.repositories.EnderecoRepository;
import com.vander.cursoumc.repositories.EstadoRepository;
import com.vander.cursoumc.repositories.ProdutoRepository;

@Configuration
public class Initialization implements CommandLineRunner {

	@Autowired
	private CategoriaRepository cateRepo;
	@Autowired
	private ProdutoRepository prodRepo;
	@Autowired
	private EstadoRepository estadoRepo;
	@Autowired
	private CidadeRepository cidadeRepo;
	@Autowired
	private ClienteRepository cliRepo;
	@Autowired
	private EnderecoRepository endRepo;

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
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "são Paulo");
		
		Cidade cidade = new Cidade(null ,"Uberlândia", est1);
		Cidade cidade2 = new Cidade(null ,"São Paulo", est2);
		Cidade cidade3 = new Cidade(null ,"campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(cidade));
		est2.getCidades().addAll(Arrays.asList(cidade2,cidade3));
		
		estadoRepo.saveAll(Arrays.asList(est1,est2));
		cidadeRepo.saveAll(Arrays.asList(cidade,cidade2,cidade3));
		
		Cliente cli1 = new Cliente(null, "maria", "maria@hotmail.com", "cpf0999890", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("234234", "q234343"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apt 303", "jardim", "38400000", cli1, cidade);
		Endereco e2 = new Endereco(null, "Rua Cravos", "105", "Sala 3", "Centro", "38400000", cli1, cidade2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		cliRepo.saveAll(Arrays.asList(cli1));
		endRepo.saveAll(Arrays.asList(e1,e2));
	}

}
