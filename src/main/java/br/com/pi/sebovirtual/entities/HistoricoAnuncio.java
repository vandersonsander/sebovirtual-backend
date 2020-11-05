package br.com.pi.sebovirtual.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import org.springframework.data.annotation.LastModifiedDate;

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
public class HistoricoAnuncio extends BaseEntity {
	@Version
	private Integer idAnuncio;
	private Integer estoque;
	private String titulo;
	private Double preco;
	private String descricao;
	
	@LastModifiedDate
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
	
	/**
	 * Conjunto de anúncios do pedido.
	 */
	@OneToMany(mappedBy="historicoAnuncio")
	@JsonIgnoreProperties("historicoAnuncio")
	private Set<PedidoTemAnuncio> itens;
	
}