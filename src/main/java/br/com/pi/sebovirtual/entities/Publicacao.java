package br.com.pi.sebovirtual.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.pi.sebovirtual.resource.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Publicacao extends BaseEntity {
	private String ano;
	private Integer quantidadePaginas;
	private String tipoCapa;
	private String isbn10;
	private String isbn13;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_idioma")
	private Idioma idioma;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_editora")
	private Editora editora;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_formato_publicacao")
	private FormatoPublicacao formatoPublicacao;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_genero")
	private Genero genero;
}
