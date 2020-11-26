package br.com.pi.sebovirtual.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	private String edicao;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "fk_id_idioma")
	@JsonIgnoreProperties("publicacoes")
	private Idioma idioma;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "fk_id_editora")
	@JsonIgnoreProperties("publicacoes")
	private Editora editora;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "fk_id_formato_publicacao")
	@JsonIgnoreProperties("publicacoes")
	private FormatoPublicacao formatoPublicacao;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "fk_id_genero")
	@JsonIgnoreProperties("publicacoes")
	private Genero genero;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name = "Publicacao_Tem_Autor",
			joinColumns = @JoinColumn(name = "fk_id_produto"),
			inverseJoinColumns = @JoinColumn(name = "fk_id_autor"))
	private List<Autor> autores;
}
