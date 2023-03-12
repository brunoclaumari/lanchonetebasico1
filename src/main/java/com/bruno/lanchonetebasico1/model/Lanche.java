package com.bruno.lanchonetebasico1.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_lanches")
public class Lanche implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	private String nome;
	
	@OneToOne//(cascade = {CascadeType.DETACH})//(orphanRemoval = true)//(cascade = CascadeType.ALL)	
	@JoinColumn(name = "tipo_lanche_id", referencedColumnName = "id")//		
	private TipoLanche tipoLanche;
	

}
