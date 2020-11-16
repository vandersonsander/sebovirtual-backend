package br.com.pi.sebovirtual.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Inheritance(strategy = InheritanceType.JOINED)
public class Produto extends BaseEntity {
	@NotNull(message = "O título é obrigatório")
	protected String titulo;
	
	@NotNull(message = "A categoria é obrigatória")
	protected String categoria;
	
	@OneToMany(mappedBy = "produto")
	@JsonIgnoreProperties("produto")
	protected List<HistoricoAnuncio> anuncios;
}
