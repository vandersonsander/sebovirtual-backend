package br.com.pi.sebovirtual.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "Fale_Conosco")
public class FaleConosco extends BaseEntity {
	
	@NotNull
	@Column(name = "nome")
	private String nome;
	
	@NotNull(message = "E-mail é obrigatório")
	@Column(name = "email")
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_usuario")
	//@JsonIgnoreProperties("contatosFaleConosco")
	@JsonIgnore
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_telefone")
	//@JsonIgnoreProperties("contatosFaleConosco")
	@JsonIgnore
	private Telefone telefone;
}
