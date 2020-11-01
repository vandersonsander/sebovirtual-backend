package br.com.pi.sebovirtual.entities;

import java.util.List;

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
public class Condicao extends BaseEntity {
	private String descricao;
	
	@OneToMany(mappedBy = "condicao")
	@JsonIgnoreProperties("condicao")
	private List<HistoricoAnuncio> historicoAnuncio; 
}
