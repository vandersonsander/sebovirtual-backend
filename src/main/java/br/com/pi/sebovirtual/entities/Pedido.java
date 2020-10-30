package br.com.pi.sebovirtual.entities;

import java.time.LocalDate;
import java.util.List;

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
public class Pedido extends BaseEntity {
	
	@NotNull
	private LocalDate data;
	@NotNull
	private Float valor_total;
	@NotNull
	private String status;

	@JoinColumn(name = "id_avaliacao")
	@JsonIgnoreProperties("pedido")
	private Avaliacao avaliacao;

	@NotNull
	@OneToOne
	@JoinColumn(name = "fk_id_usuario")
	@JsonIgnoreProperties("pedido")
	private Usuario usuario;

	@NotNull
	@OneToOne
	@JoinColumn(name = "fk_id_metodo_de_pagamento")
	@JsonIgnoreProperties("pedido")
	private HistoricoMetodoPagamento metodoPagamento;
	
	@NotNull
	@OneToMany
	@JoinColumn(name = "fk_id_endereco")
	@JsonIgnoreProperties("pedido")
	private HistoricoEndereco endereco;
}
