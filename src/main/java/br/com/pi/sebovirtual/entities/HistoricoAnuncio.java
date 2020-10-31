package br.com.pi.sebovirtual.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(name = "historicoanuncio")
public class HistoricoAnuncio extends BaseEntity {	
	private Integer idAnuncio;
	private Integer estoque;
	private String titulo;
	private Double preco;
	private LocalDate dataModificacao;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_produto")
	@JsonIgnoreProperties("historicoAnuncio")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_condicao")
	@JsonIgnoreProperties("historicoAnuncio")
	private Condicao condicao;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_status")
	@JsonIgnoreProperties("historicoAnuncio")
	private Status status;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_usuario")
	@JsonIgnoreProperties("historicoAnuncio")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "historicoAnuncio")
	@JsonIgnoreProperties("historicoAnuncio")
	private List<Imagem> imagens;
	
	// Overload do método setDataModificacao
	public void setDataModificacao(String dataModificacao) {
		this.dataModificacao = LocalDate.parse(dataModificacao);
	}
}
