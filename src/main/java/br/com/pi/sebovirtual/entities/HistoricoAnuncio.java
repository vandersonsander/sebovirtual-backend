package br.com.pi.sebovirtual.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	private LocalDateTime dataModificacao;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "fk_id_produto")
	@JsonIgnoreProperties("anuncios")
	private Produto produto;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "fk_id_condicao")
	@JsonIgnoreProperties("historicoAnuncio")
	private Condicao condicao;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "fk_id_status")
	@JsonIgnoreProperties("historicoAnuncio")
	private Status status;
	
	/**
	 * Usuário que criou o anúncio.
	 */
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "fk_id_usuario")
	@JsonIgnoreProperties("historicoAnuncio")
	@JsonIgnore(false)
	private Usuario usuario;
	
	@OneToMany(mappedBy = "historicoAnuncio")
	@JsonIgnoreProperties("historicoAnuncio")
	private List<Imagem> imagens;
	
	/**
	 * Conjunto de anúncios do pedido.
	 */
	@OneToMany(mappedBy="historicoAnuncio", cascade = CascadeType.ALL)
	@JsonIgnore(true)
	private Set<PedidoTemAnuncio> itens =
		new HashSet<>();
	
	/**
	 * Usuários que favoritaram este anúncio.
	 */
	/*@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Usuario_favorita_Anuncio",
            joinColumns = @JoinColumn(name = "fk_id_anuncio"),
            inverseJoinColumns = @JoinColumn(name = "fk_id_usuario")
    )
    @JsonIgnore(true)
    private Collection<Usuario> usuarios = new HashSet<Usuario>();*/
	
	/*@ManyToMany(mappedBy = "anuncios", 
			cascade = {
					CascadeType.ALL
			    })
	@JsonIgnoreProperties({ "anuncios"})
	private List<Pedido> pedidos;*/
	
}
