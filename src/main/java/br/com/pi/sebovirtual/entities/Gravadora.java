package br.com.pi.sebovirtual.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.pi.sebovirtual.resource.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Gravadora")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
@ToString
public class Gravadora extends BaseEntity {
	
	/**
	 * Nome da gravadora.
	 */
	private String nome;
	
	@OneToMany(mappedBy = "gravadora")
	@JsonIgnoreProperties("gravadora")
	private Set<Midia> midias = 
		new HashSet<Midia>();

}
