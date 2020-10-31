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
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Formato_Midia")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class FormatoMidia extends BaseEntity {
	
	/**
	 * Nome do formato de mídia.
	 */
	private String nome;
	
	/*@OneToMany(mappedBy = "formatomidia")
	@JsonIgnoreProperties("formatomidia")
	private Set<Midia> midias = 
		new HashSet<Midia>();*/

}
