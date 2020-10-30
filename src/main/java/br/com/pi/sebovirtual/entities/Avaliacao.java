package br.com.pi.sebovirtual.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;

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
	@JoinColumn(name = "fk_id_usuario")
	private Usuario usuario;
}
