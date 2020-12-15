package com.vander.cursoumc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vander.cursoumc.domain.Categoria;
import com.vander.cursoumc.repositories.CategoriaRepository;
import com.vander.cursoumc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		 Optional<Categoria> obj = repo.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado para o código: Id: " + id + ", Tipo: " + Categoria.class.getName()));
		} 
	
	public List<Categoria> findAll(){
		return repo.findAll();
	}

}
