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

	@Column(name = "email")
	@Email(message = "Email incorreto")
	@NotNull(message="Email é obrigatório")
	private String email;
	
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
	
	@OneToMany(mappedBy = "usuario")
	@JsonIgnoreProperties("usuario")
	private Set<HistoricoEndereco> enderecos = 
		new HashSet<HistoricoEndereco>();
	
	@OneToMany(mappedBy = "usuario")
	@JsonIgnoreProperties("usuario")
	private Set<Telefone> telefones = 
		new HashSet<Telefone>();	
	
	@OneToMany(mappedBy = "usuario")
	@JsonIgnoreProperties("usuario")
	private Set<HistoricoMetodoPagamento> pagamentos = 
		new HashSet<HistoricoMetodoPagamento>();

	@OneToMany(mappedBy = "usuario")
	@JsonIgnoreProperties("usuario")
	private Set<Avaliacao> avaliacoes = new HashSet<>();
	
	@OneToMany(mappedBy = "usuario")
	@JsonIgnoreProperties("usuario")
	private Set<Pedido> pedidos = new HashSet<>();
	
	@OneToMany(mappedBy = "usuario")
	@JsonIgnoreProperties("usuario")
	private Set<FaleConosco> contatosFaleConosco = new HashSet<>();
	
}