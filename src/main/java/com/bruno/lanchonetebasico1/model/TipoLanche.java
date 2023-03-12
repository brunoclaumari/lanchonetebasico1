package com.bruno.lanchonetebasico1.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_tipo_lanche")
public class TipoLanche implements Serializable{	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome_tipo")
	private String nomeTipo;
	
	/*//Esse foi o que deu mais certo, mas não faz sentido
	@JsonIgnore//, orphanRemoval = true, cascade = CascadeType.ALL
	@OneToMany(mappedBy = "tipoLanche",orphanRemoval = true)//	
	private Set<Lanche> lanche;
	 * 
	 * */
	//@ManyToOne(targetEntity = TipoLanche.class)
	//@JoinColumn(name = "id", insertable = false, updatable = false)
	
	@JsonIgnore //não pode tirar isso daqui nem a pau
	@OneToOne//(cascade = {CascadeType.DETACH})
	@JoinColumn(name = "id", referencedColumnName = "tipo_lanche_id", insertable = false, updatable = false)
	private Lanche lanche;

}
