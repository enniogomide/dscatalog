package com.devsuperior.dscatalog.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.services.CategoryService;
import com.devsuperior.dscatalog.services.exceptions.EntityNotFoundException;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	/*
	 * declaração de dependência para o CategoryService
	 */
	@Autowired
	private CategoryService service;
	/*
	 * List ao categories
	 */
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll() {
		/*
		 * Busca através do service a lista de todos os registros no banco.
		 */
		List<CategoryDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	/*
	 *  list category by id
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoryDTO> findById(@PathVariable Long id) {

		CategoryDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}	

}
