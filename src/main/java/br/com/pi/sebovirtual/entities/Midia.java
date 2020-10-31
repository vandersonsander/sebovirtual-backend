package br.com.pi.sebovirtual.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Midia")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class Midia extends Produto {
	
	/**
	 * Quantidade de mídias do produto.
	 */
	@Column(name = "quantidade_midias")
	private Integer quantidade_midias;
	
	/**
	 * Ano de lançamento da mídia.
	 */
	private LocalDate ano;
	
	/**
	 * Quantidade de faixas da mídia.
	 */
	@Column(name = "quantidade_faixas")
	private Integer quantidade_faixas;	
	
	/**
	 * Tempo de execução.
	 */
	@Column(name = "tempo_execucao")
	private LocalTime tempo_execucao;	
	
	/**
	 * Artista da mídia.
	 */
	@Column(name = "artista")	
	private String artista;
	
	/**
	 * Formato da mídia. Por exemplo: cd, dvd ou disco de vinil.
	 */
	@ManyToOne
	@JoinColumn(name = "fk_id_formato_midia")
	@JsonIgnoreProperties("midias")	
	private FormatoMidia formatoMidia;
	
	/**
	 * Gravadora da mídia.
	 */
	@ManyToOne
	@JoinColumn(name = "fk_id_gravadora")
	@JsonIgnoreProperties("midias")	
	private Gravadora gravadora;	
	
	/**
	 * Gênero da mídia.
	 */
	@ManyToOne
	@JoinColumn(name = "fk_id_genero")
	@JsonIgnoreProperties("midias")	
	private Genero genero;	
	
	/**
	 * Idioma da mídia.
	 */
	@ManyToOne
	@JoinColumn(name = "fk_id_idioma")
	@JsonIgnoreProperties("midias")	
	private Idioma idioma;		
	
	/**
	 * Legendas da midia.
	 */
	@ManyToMany
	@JoinTable(
	  name = "Midia_tem_Legenda", 
	  joinColumns = @JoinColumn(name = "fk_id_produto"), 
	  inverseJoinColumns = @JoinColumn(name = "fk_id_legenda"))	
	private Set<Legenda> legendas = new HashSet<Legenda>();	
	
}
