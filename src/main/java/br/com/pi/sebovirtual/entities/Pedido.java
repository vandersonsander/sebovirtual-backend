package br.com.pi.sebovirtual.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	@Column(name = "data")
	private LocalDateTime data;

	@NotNull
	@Column(name = "valor_total")
	private Float valorTotal;

	@NotNull
	@Column(name = "status")
	private String status;
	
	@Column(name = "data_status")
	private LocalDateTime data_status;

	@ManyToOne
	@JoinColumn(name = "id_avaliacao")
	@JsonIgnore(true)
	private Avaliacao avaliacao;

	@ManyToOne
	@JoinColumn(name = "fk_id_usuario")
	@JsonIgnore(false)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "fk_id_metodo_de_pagamento")
	@JsonIgnore(false)
	private HistoricoMetodoPagamento metodoPagamento;

	@ManyToOne
	@JoinColumn(name = "fk_id_endereco")
	@JsonIgnore(false)
	private HistoricoEndereco endereco;

	/**
	 * Conjunto de anúncios do pedido.
	 */
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	@JsonIgnore(false)
	private Set<PedidoTemAnuncio> itens = 
		new HashSet<PedidoTemAnuncio>();

}
