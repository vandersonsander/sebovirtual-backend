package br.com.pi.sebovirtual.entities;

import java.time.LocalDate;

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
public class HistoricoAnuncio extends BaseEntity {
	private Integer idAnuncio;
	private Integer estoque;
	private String titulo;
	private Double preco;
	private LocalDate dataModificacao;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_produto")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_condicao")
	private Condicao condicao;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_status")
	private Status status;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_usuario")
	private Usuario usuario;
	
	// Overload do método setDataModificacao
	public void setDataModificacao(String dataModificacao) {
		this.dataModificacao = LocalDate.parse(dataModificacao);
	}
}
