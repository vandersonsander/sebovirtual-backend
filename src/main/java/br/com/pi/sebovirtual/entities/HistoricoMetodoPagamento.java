package br.com.pi.sebovirtual.entities;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.pi.sebovirtual.resource.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Historico_Metodo_Pagamento")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class HistoricoMetodoPagamento extends BaseEntity {
	
	/**
	 * Identifica um método de pagamento, que pode ter uma ou 
	 * mais versões (histórico). É diferente do id do método de pagamento, 
	 * que é o id geral e único de um método de pagamento. 
	 * id_metodo_pagamento identifica o histórico de um método de pagamento.
	 */
	@Column(name = "id_metodo_pagamento")
	private Integer idMetodoPagamento;
	
	/**
	 * Email do método de pagamento.
	 */
	@Column(name = "email")
	@Email(message = "Email incorreto")
	@NotNull(message="Email é obrigatório")	
	private String email;
	
	/**
	 * Data de modificação do método de pagamento.
	 */
	@Column(name = "data_modificacao")	
	private LocalDate dataModificacao;
	
	/**
	 * Tipo do método de pagamento.
	 */
	@ManyToOne
	@JoinColumn(name = "fk_id_tipo_metodo_pag")
	@JsonIgnoreProperties("pagamentos")	
	private TipoMetodoPagamento tipo_metodo_pagamento;
	
	/**
	 * Status do método de pagamento.
	 */
	@ManyToOne
	@JoinColumn(name = "fk_id_status")
	@JsonIgnoreProperties("pagamentos")	
	private Status status;	
	
	/**
	 * Usuário proprietário do método de pagamento.
	 */
	@ManyToOne
	@JoinColumn(name = "fk_id_usuario")
	@JsonIgnoreProperties("pagamentos")	
	private Usuario usuario;	
	
	/**
	 * Conjunto de pedidos usados com este método de pagamento.
	 * Descomentar as três linhas abaixo quando a entidade Pedido estiver 
	 * no repositório.
	 */
	/*@OneToOne(mappedBy = "historico_metodo_pagamento")
	@JsonIgnoreProperties("historico_metodo_pagamento")
	private Set<Pedido> pedidos = new HashSet<Pedido>();*/
	
}