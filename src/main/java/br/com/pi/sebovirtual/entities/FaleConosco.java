package br.com.pi.sebovirtual.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
public class FaleConosco extends BaseEntity {
	@NotNull
	@Column(name = "nome")
	private String nome;
	
	@NotNull(message = "E-mail é obrigatório")
	@Column(name = "email")
	private String email;
	
	@NotNull
	@OneToMany
	@JoinColumn(name = "fk_id_telefone")
	private Telefone telefone;
	
	@OneToMany
	@JoinColumn(name = "fk_id_usuario")
	@JsonIgnoreProperties("contatosFaleConosco")
	private Usuario usuario;
}
