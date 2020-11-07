package br.com.pi.sebovirtual.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class Imagem extends BaseEntity {
	
	private String url;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_anuncio")
	@JsonIgnoreProperties("imagens")
	private HistoricoAnuncio historicoAnuncio;
	
	public String getUrl() {
		return "http://localhost:8080/upload/" + this.url;
	}
}
