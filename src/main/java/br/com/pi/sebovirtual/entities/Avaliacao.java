package br.com.pi.sebovirtual.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@Table(name = "avaliacao")
public class Avaliacao extends BaseEntity {
	@Column(name = "nota_descricao")
	private Integer notaDescricao;
	
	@Column(name = "nota_rapidez_envio")
	private Integer notaRapidezEnvio;
	
	@Column(name = "nota_embalagem")
	private Integer notaEmbalagem;
	
	@Column(name = "comentarios")
	private String comentarios;
	
	@Column(name = "anonimo")
	private Integer anonimo;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "fk_id_usuario")
	@JsonIgnoreProperties("avaliacoes")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "avaliacao")
	@JsonIgnoreProperties("avaliacoes")
	private Set<Pedido> pedidos = new HashSet<>();
}
