package br.com.pi.sebovirtual.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class Imagem extends BaseEntity {
	private String url;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_anuncio")
	private HistoricoAnuncio anuncio;
}
