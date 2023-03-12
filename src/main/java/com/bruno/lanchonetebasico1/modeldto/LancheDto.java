package com.bruno.lanchonetebasico1.modeldto;

import java.io.Serializable;

import com.bruno.lanchonetebasico1.model.Lanche;
import com.bruno.lanchonetebasico1.model.TipoLanche;

import lombok.Data;

@Data
public class LancheDto implements Serializable {	

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nome;	

	private TipoLanche tipoLanche;
	
	public LancheDto(Lanche entidade) {
		this.id = entidade.getId();
		this.nome = entidade.getNome();		
		this.tipoLanche = entidade.getTipoLanche();
	}
	
	public LancheDto() {
		
	}

}
