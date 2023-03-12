package com.bruno.lanchonetebasico1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.lanchonetebasico1.model.TipoLanche;
import com.bruno.lanchonetebasico1.repositories.TipoLancheRepository;

@Service
public class TipoLancheService {
	
	@Autowired
	private TipoLancheRepository tipoLancheRepository;
	
	public List<TipoLanche> findAll(){
		
		List<TipoLanche> lista = tipoLancheRepository.findAll();
		
		return lista;
	}

}
