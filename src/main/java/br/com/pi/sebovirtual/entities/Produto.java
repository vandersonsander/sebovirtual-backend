package br.com.pi.sebovirtual.entities;

import java.util.List;

import javax.persistence.Entity;
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
public class Produto extends BaseEntity {
	@NotNull(message = "O título é obrigatório")
	private String titulo;
	
	@OneToMany(mappedBy = "produto")
	@JsonIgnoreProperties("produto")
	private List<HistoricoAnuncio> historicoAnuncio;
	
	@OneToOne(mappedBy = "produto")
	@JsonIgnoreProperties("produto")
	private Publicacao publicacao;
}