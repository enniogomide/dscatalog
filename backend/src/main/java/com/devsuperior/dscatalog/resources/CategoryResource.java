package com.devsuperior.dscatalog.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dscatalog.entities.Category;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = new ArrayList<>();
		/*
		 *  inclusão de itens na lista
		 */
		list.add(new Category(1L, "Books"));
		list.add(new Category(2L, "Eletronics"));
		list.add(new Category(3L, "Appliances"));
		list.add(new Category(4L, "Computers"));
		/*
		 * realizar a resposta do list para a requisição do Entity
		 */
		return ResponseEntity.ok().body(list);
		
		
	}
	

}
