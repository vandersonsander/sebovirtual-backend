package br.com.pi.sebovirtual.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

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
public class Status extends BaseEntity {
	
	public static final String ATIVO = "ativo";
	public static final String EDITADO = "editado";
	public static final String EXCLUIDO = "excluido";
	
	private String nome;

	@OneToMany(mappedBy = "status")
	@JsonIgnore(true)
	private List<HistoricoAnuncio> historicoAnuncio;

	@OneToMany(mappedBy = "status")
	@JsonIgnore(true)
	private Set<HistoricoEndereco> enderecos = 
		new HashSet<HistoricoEndereco>();

	@OneToMany(mappedBy = "status")
	@JsonIgnore(true)
	private Set<HistoricoMetodoPagamento> pagamentos = 
		new HashSet<HistoricoMetodoPagamento>();

}