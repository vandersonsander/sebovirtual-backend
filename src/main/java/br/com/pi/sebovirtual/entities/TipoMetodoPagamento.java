package br.com.pi.sebovirtual.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.pi.sebovirtual.resource.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Tipo_Metodo_Pagamento")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class TipoMetodoPagamento extends BaseEntity {
	
	/**
	 * Nome do método de pagamento.
	 */
	@Column(name = "nome")	
	private String nome;
	
	/*@OneToMany(mappedBy = "tipo_metodo_pagamento")
	//@JsonIgnoreProperties("tipo_metodo_pagamento")
	@JsonIgnore(true)
	private Set<HistoricoMetodoPagamento> pagamentos = 
		new HashSet<HistoricoMetodoPagamento>();*/
}
