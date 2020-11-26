package br.com.pi.sebovirtual.dto;

import br.com.pi.sebovirtual.entities.HistoricoAnuncio;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
	private HistoricoAnuncio anuncio;
	private Integer quantidade;
}
