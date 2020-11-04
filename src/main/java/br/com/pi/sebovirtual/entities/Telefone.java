package br.com.pi.sebovirtual.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
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

@Entity
@Table(name = "telefone")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Telefone extends BaseEntity {

	/**
	 * Código de discagem direta internacional.
	 */
	@Column(name = "ddi")
	private String ddi;

	/**
	 * Código de discagem direta à distância.
	 */
	@Column(name = "ddd")
	private String ddd;

	/**
	 * Número do telefone.
	 */
	@Column(name = "numero")
	private String numero;

	/**
	 * Tipo do número: residencial, celular, comercial, entre outros.
	 */
	@Column(name = "tipo")
	private String tipo;

	/**
	 * Usuário proprietário do telefone.
	 */
	@ManyToOne
	@JoinColumn(name = "fk_id_usuario")
	@JsonIgnoreProperties("telefones")
	private Usuario usuario;

	@OneToMany(mappedBy = "telefone")
	@JsonIgnoreProperties("telefone")
	private Set<FaleConosco> contatosFaleConosco = new HashSet<>();

}