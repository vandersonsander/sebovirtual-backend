package br.com.pi.sebovirtual.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.pi.sebovirtual.resource.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Historico_Endereco")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class HistoricoEndereco extends BaseEntity {
	
	/**
	 * Identifica um endereço, que pode ter uma ou mais versões (histórico).
	 * É diferente do id do endereço, que é o id geral e único de um endereço. 
	 * id_endereco identifica o histórico de um endereço.
	 */
	@Column(name = "id_endereco")
	private Integer idEndereco;
	
	/**
	 * Nome do destinatário do endereço.
	 */
	@Column(name = "nome_destinatario")
	private String nomeDestinatario;
	
	/**
	 * Códido de endereçamento postal de um endereço.
	 */
	@Column(name = "cep")	
	private String cep;
	
	/**
	 * Logradouro de um endereço.
	 */
	@Column(name = "logradouro")
	private String logradouro;
	
	/**
	 * Número do endereço.
	 */
	@Column(name = "numero")	
	private String numero;
	
	/**
	 * Complemento do endereço.
	 */
	@Column(name = "complemento")
	private String complemento;
	
	/**
	 * Ponto de referência do endereço.
	 */
	@Column(name = "ponto_referencia")	
	private String pontoReferencia;
	
	/**
	 * Bairro do endereço.
	 */
	@Column(name = "bairro")	
	private String bairro;
	
	/**
	 * Cidade do endereço.
	 */
	@Column(name = "cidade")	
	private String cidade;
	
	/**
	 * Estado do endereço.
	 */
	@Column(name = "estado")	
	private String estado;
	
	/**
	 * Apelido do endereço.
	 */
	@Column(name = "apelido")	
	private String apelido;
	
	/**
	 * Data de modificação do endereço.
	 */
	@Column(name = "data_modificacao")	
	private LocalDateTime dataModificacao;
	
	/**
	 * Usuário proprietário do endereço.
	 */
	@ManyToOne
	@JoinColumn(name = "fk_id_usuario")
	@JsonIgnoreProperties("enderecos")	
	private Usuario usuario;
	
	/**
	 * Status do endereço.
	 */
	@ManyToOne
	@JoinColumn(name = "fk_id_status")
	@JsonIgnoreProperties("enderecos")
	private Status status;	
	
	/**
	 * Conjunto de pedidos enviados para este endereço.
	 */
	@OneToMany(mappedBy = "endereco")
	@JsonIgnore(true)
	private Set<Pedido> pedidos = new HashSet<Pedido>();
	
}