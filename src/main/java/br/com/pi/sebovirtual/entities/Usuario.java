package br.com.pi.sebovirtual.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.pi.sebovirtual.resource.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Usuario")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario extends BaseEntity {

	/**
	 * E-mail do usuário.
	 */
	@Column(name = "email")
	@Email(message = "Email incorreto")
	@NotNull(message="Email é obrigatório")
	private String email;
	
	/**
	 * Senha do usuário.
	 */
	@Column(name = "senha")
	@NotNull(message="Senha é obrigatória")
	private String senha;
	
	/*@Column(name = "habilitado")
	@JsonIgnore
	@NotNull(message="Habilitado é obrigatório")
	private Boolean habilitado;
	
	@Column(name = "autoridade")
	@JsonIgnore
	@NotNull(message="Autoridade é obrigatório")
	private String autoridade;*/
	
	/**
	 * Endereços do usuário.
	 */
	@OneToMany(mappedBy = "usuario")
	@JsonIgnoreProperties("usuario")
	@JsonIgnore
	private Set<HistoricoEndereco> enderecos = 
		new HashSet<HistoricoEndereco>();
	
	/**
	 * Telefones do usuário.
	 */
	@OneToMany(mappedBy = "usuario")
	@JsonIgnoreProperties("usuario")
	private Set<Telefone> telefones = 
		new HashSet<Telefone>();	
	
	/**
	 * Pagamentos que o usuário fez.
	 */
	@OneToMany(mappedBy = "usuario")
	@JsonIgnoreProperties("usuario")
	@JsonIgnore
	private Set<HistoricoMetodoPagamento> pagamentos = 
		new HashSet<HistoricoMetodoPagamento>();
	
	/**
	 * Avaliações que o usuário fez.
	 */
	@OneToMany(mappedBy = "usuario")
	//@JsonIgnoreProperties("usuario")
	@JsonIgnore
	private Set<Avaliacao> avaliacoes = new HashSet<>();
	
	/**
	 * Pedidos do usuário.
	 */
	@OneToMany(mappedBy = "usuario")
	@JsonIgnoreProperties("usuario")
	@JsonIgnore
	private Set<Pedido> pedidos = new HashSet<>();
	
	/**
	 * Mensagens do usuário enviadas para o Fale Conosco do Sevo Virtual.
	 */
	@OneToMany(mappedBy = "usuario")
	@JsonIgnoreProperties("usuario")
	@JsonIgnore
	private Set<FaleConosco> contatosFaleConosco = new HashSet<>();
	
	/**
	 * Anúncios favoritados pelo usuário.
	 */
	/*@ManyToMany
	@JoinTable(
	  name = "Usuario_favorita_Anuncio", 
	  joinColumns = @JoinColumn(name = "fk_id_usuario"), 
	  inverseJoinColumns = @JoinColumn(name = "fk_id_anuncio"))	
	private Set<HistoricoAnuncio> anuncios = new HashSet<HistoricoAnuncio>();*/	
	
}