package com.vander.cursoumc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vander.cursoumc.domain.Pedido;
import com.vander.cursoumc.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService service;
	
	@GetMapping(value = "/{id}")
	public Pedido find(@PathVariable Integer id){
		 return service.find(id);
	}
	
	@GetMapping
	public List<Pedido> listar(){
		return service.findAll();
	}

}
