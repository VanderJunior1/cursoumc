package com.vander.cursoumc.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vander.cursoumc.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@GetMapping
	public List<Categoria> listar(){
		Categoria c1 = new Categoria(1, "Informática");
		Categoria c2 = new Categoria(2, "Escritório");
		 List<Categoria> lista = new ArrayList<>();
		 lista.addAll(Arrays.asList(c1,c2));
		 return lista;
	}

}
