package br.com.pi.sebovirtual.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
public class Publicacao extends Produto {
	private String ano;
	private Integer quantidadePaginas;
	private String tipoCapa;
	private String isbn10;
	private String isbn13;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_idioma")
	@JsonIgnoreProperties("publicacoes")
	private Idioma idioma;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_editora")
	@JsonIgnoreProperties("publicacoes")
	private Editora editora;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_formato_publicacao")
	@JsonIgnoreProperties("publicacoes")
	private FormatoPublicacao formatoPublicacao;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_genero")
	@JsonIgnoreProperties("publicacoes")
	private Genero genero;
//	
//	public void setTitulo(String titulo) {
//		super.setTitulo(titulo);
//	}
}
