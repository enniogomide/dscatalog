package com.devsuperior.dscatalog.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscatalog.dto.CategoryDTO;
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
	public List<CategoryDTO> findAll() {
		List<Category> list = repository.findAll();
		
		return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
		/*
		 * Acima é a mesma da função abaixo.
		 * cria a lista DTO e alimenta com os dados retornados a lista Category
		 */
		/*
		List<CategoryDTO> listDto = new ArrayList<>();
		for (Category cat : list) {
			listDto.add(new CategoryDTO(cat));
		}
		
		return listDto;
		*/
	}
	
	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		Category entity = obj.get();
		return new CategoryDTO(entity);
	}

}
