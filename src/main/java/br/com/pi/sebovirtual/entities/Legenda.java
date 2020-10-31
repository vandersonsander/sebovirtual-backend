package br.com.pi.sebovirtual.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.pi.sebovirtual.resource.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Legenda")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
@ToString
public class Legenda extends BaseEntity {
	
	/**
	 * Legenda da midia.
	 */
	private String nome;
	
	@ManyToMany(mappedBy = "legendas")
	@JsonIgnoreProperties("legenda")
	private Set<Midia> midias = 
		new HashSet<Midia>();

}
