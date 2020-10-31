package br.com.pi.sebovirtual.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.pi.sebovirtual.resource.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Marca")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
@ToString
public class Marca extends BaseEntity {
	
	/**
	 * Nome da marca.
	 */
	private String nome;	

}
