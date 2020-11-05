package br.com.pi.sebovirtual.entities;

import javax.persistence.Entity;

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
public class Status extends BaseEntity {
	
	private String nome;

	/* NÃO DESCOMENTE ESTE TRECHO DE CÓDIGO. EM TESTE!
	@OneToMany(mappedBy = "status")
	@JsonIgnoreProperties("status")
	private List<HistoricoAnuncio> historicoAnuncio;

	@OneToMany(mappedBy = "status")
	@JsonIgnoreProperties("status")
	private Set<HistoricoEndereco> enderecos = 
		new HashSet<HistoricoEndereco>();

	@OneToMany(mappedBy = "status")
	@JsonIgnoreProperties("status")
	private Set<HistoricoMetodoPagamento> pagamentos = 
		new HashSet<HistoricoMetodoPagamento>();*/

}