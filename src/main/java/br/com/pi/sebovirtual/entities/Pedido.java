package br.com.pi.sebovirtual.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
public class Pedido extends BaseEntity {

	@NotNull
	@Column(name = "data")
	private LocalDate data;

	@NotNull
	@Column(name = "valor_total")
	private Float valorTotal;

	@NotNull
	@Column(name = "status")
	private String status;

	@ManyToOne
	@JoinColumn(name = "id_avaliacao")
	//@JsonIgnoreProperties("pedidos")
	@JsonIgnore
	private Avaliacao avaliacao;

	@ManyToOne
	@JoinColumn(name = "fk_id_usuario")
	//@JsonIgnoreProperties("pedidos")
	@JsonIgnore
	private Usuario usuario;

	@OneToOne
	@JoinColumn(name = "fk_id_metodo_de_pagamento")
	//@JsonIgnoreProperties("pedidos")
	@JsonIgnore
	private HistoricoMetodoPagamento metodoPagamento;

	@ManyToOne
	@JoinColumn(name = "fk_id_endereco")
	//@JsonIgnoreProperties("pedidos")
	@JsonIgnore
	private HistoricoEndereco endereco;

	/**
	 * Conjunto de anúncios do pedido.
	 */
	@OneToMany(mappedBy = "pedido")
	@JsonIgnore
	private Set<PedidoTemAnuncio> itens = new HashSet<PedidoTemAnuncio>();

}
