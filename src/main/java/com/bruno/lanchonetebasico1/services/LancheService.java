package com.bruno.lanchonetebasico1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bruno.lanchonetebasico1.model.Lanche;
import com.bruno.lanchonetebasico1.model.TipoLanche;
import com.bruno.lanchonetebasico1.modeldto.LancheDto;
import com.bruno.lanchonetebasico1.repositories.LancheRepository;
import com.bruno.lanchonetebasico1.repositories.TipoLancheRepository;

@Service
public class LancheService {
	
	@Autowired
	private LancheRepository lancheRepository;
	
	@Autowired
	private TipoLancheRepository tipoRepository;
	
	public List<Lanche> findAll(){
		
		List<Lanche> lista = lancheRepository.findAll();
		//Page<Lanche> pagina = (Page)lista;
		return lista;
	}
	
	@Transactional
	public Lanche insert(LancheDto dto) {		

		Lanche entity = new Lanche();
		copyDtoToEntity(dto, entity);		

		entity = lancheRepository.save(entity);

		return entity;
	}
	
	private void copyDtoToEntity(LancheDto dto, Lanche entity) {
		Long tipoId = dto.getTipoLanche().getId();	
		
		TipoLanche tipo = tipoRepository.findById(tipoId).get();		
		entity.setNome(dto.getNome());
		entity.setTipoLanche(tipo);			
	}

}
