package com.vander.cursoumc.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vander.cursoumc.domain.Categoria;
import com.vander.cursoumc.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping(value = "/{id}")
	public Categoria find(@PathVariable Integer id){
		 return service.find(id);
	}
	
	@GetMapping
	public List<Categoria> listar(){
		return service.findAll();
	}

}
