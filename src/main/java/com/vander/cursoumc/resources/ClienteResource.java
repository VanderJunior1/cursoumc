package com.vander.cursoumc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vander.cursoumc.domain.Cliente;
import com.vander.cursoumc.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping(value = "/{id}")
	public Cliente find(@PathVariable Integer id){
		 return service.find(id);
	}
	
	@GetMapping
	public List<Cliente> listar(){
		return service.findAll();
	}

}
