package com.devsuperior.dscatalog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	/*
	 * declaração de dependência para o CategoryRepository
	 */
	@Autowired
	private CategoryRepository repository;
	
	/*
	 * para controle de transação: no início coloca @Transactional (importar a do spring)
	 * com readonly não trava o banco (não faz lock).
	 * Todo o controle de entidade, resolve na camada de serviço.
	 */
	@Transactional(readOnly = true)
	public List<Category> findAll() {
		return repository.findAll();
	}

}
