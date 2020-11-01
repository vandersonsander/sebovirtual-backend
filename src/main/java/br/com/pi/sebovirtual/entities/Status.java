package br.com.pi.sebovirtual.entities;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

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
public class Status extends BaseEntity {
	
	private String nome;

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
		new HashSet<HistoricoMetodoPagamento>();

}
