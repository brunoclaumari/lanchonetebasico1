package com.bruno.lanchonetebasico1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bruno.lanchonetebasico1.model.TipoLanche;
import com.bruno.lanchonetebasico1.services.TipoLancheService;

@RestController
@RequestMapping(value = "/tipolanche")
public class TipoLancheController {
	
	@Autowired
	private TipoLancheService tipoLancheService;
	
	@GetMapping
	public ResponseEntity<List<TipoLanche>> getAllNonPaged(){
		
		List<TipoLanche> list = tipoLancheService.findAll();
		
		return ResponseEntity.ok().body(list);
	}

}
