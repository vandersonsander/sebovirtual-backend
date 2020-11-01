package br.com.pi.sebovirtual.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Avaliacao extends BaseEntity {
	private Integer notaDescricao;
	private Integer notaRapidezEnvio;
	private Integer notaEmbalagem;
	private String comentarios;
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
