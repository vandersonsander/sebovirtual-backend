package br.com.pi.sebovirtual.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Eletronico")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
@ToString
public class Eletronico extends Produto {
	
	/**
	 * Marca do eletrônico.
	 */
	@ManyToOne
	@JoinColumn(name = "fk_id_marca")
	@JsonIgnoreProperties("eletronicos")	
	private Marca marca;
	
	/**
	 * Subcategoria do eletrônico.
	 */
	@ManyToOne
	@JoinColumn(name = "fk_id_subcategoria")
	@JsonIgnoreProperties("eletronicos")	
	private Subcategoria subcategoria;	
	
}
