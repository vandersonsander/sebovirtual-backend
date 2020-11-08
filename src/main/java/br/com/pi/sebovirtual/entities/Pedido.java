package br.com.pi.sebovirtual.entities;

import java.time.LocalDate;
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
public class Pedido extends BaseEntity {
	
	@NotNull
	private LocalDate data;
	
	@NotNull
	private Float valor_total;
	
	@NotNull
	private String status;

	@ManyToOne
	@JoinColumn(name = "id_avaliacao")
	@JsonIgnoreProperties("pedidos")
	private Avaliacao avaliacao;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "fk_id_usuario")
	@JsonIgnoreProperties("pedidos")
	private Usuario usuario;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "fk_id_metodo_de_pagamento")
	@JsonIgnoreProperties("pedidos")
	private HistoricoMetodoPagamento metodoPagamento;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "fk_id_endereco")
	@JsonIgnoreProperties("pedidos")
	private HistoricoEndereco endereco;
	
	/**
	 * Conjunto de anúncios do pedido.
	 */
	/*@NotNull
	@OneToMany(mappedBy="pedido")
	//@JsonIgnoreProperties("pedido")
	private Set<PedidoTemAnuncio> itens;*/
}
