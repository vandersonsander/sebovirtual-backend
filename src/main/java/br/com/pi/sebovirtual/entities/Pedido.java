package br.com.pi.sebovirtual.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
public class Pedido extends BaseEntity {
	@NotNull
	private LocalDate data;
	@NotNull
	private Float valor_total;
	@NotNull
	private String status;

	@JoinColumn(name = "id_avaliacao")
	private Avaliacao avaliacao;

	@NotNull
	@OneToMany
	@JoinColumn(name = "fk_id_usuario")
	private Usuario usuario;

	@NotNull
	@OneToMany
	@JoinColumn(name = "fk_id_metodo_de_pagamento")
	private Integer metodoPagamento;

	@NotNull
	@OneToMany
	@JoinColumn(name = "fk_id_endereco")
	private Integer endereco;
}
