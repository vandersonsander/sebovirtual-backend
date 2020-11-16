package br.com.pi.sebovirtual.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.br.CNPJ;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Pessoa_Juridica")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
@ToString
public class PessoaJuridica extends Usuario {
	
	/**
	 * Nome fantasia da pessoa jurídica.
	 */
	@Column(name = "nome_fantasia")
	private String nomeFantasia;
	
	/**
	 * CNPJ da pessoa jurídica.
	 */
	@Column(name = "cnpj")
	//@CNPJ(message = "CNPJ inválido")
	private String cnpj;
	
	/**
	 * Razao social da pessoa jurídica.
	 */
	@Column(name = "razao_social")
	private String razaoSocial;
	
}

