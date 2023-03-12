package com.bruno.lanchonetebasico1.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bruno.lanchonetebasico1.model.Lanche;
import com.bruno.lanchonetebasico1.modeldto.LancheDto;
import com.bruno.lanchonetebasico1.services.LancheService;

@RestController
@RequestMapping(value = "/lanches")
public class LancheController {
	
	@Autowired
	private LancheService lancheService;
	
	@GetMapping
	public ResponseEntity<List<Lanche>> getAllNonPaged(){
		
		List<Lanche> list = lancheService.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Lanche> insert(@RequestBody LancheDto dto) {
		
		Lanche entity = new Lanche();
		entity = lancheService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();

		return ResponseEntity.created(uri).body(entity);
	}

}
