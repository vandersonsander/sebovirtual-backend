package br.com.pi.sebovirtual.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Pessoa_Fisica")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
@ToString
public class PessoaFisica extends Usuario {
	
	/**
	 * Primeiro nome do usuário.
	 */
	@Column(name = "nome")
	private String nome;
	
	/**
	 * Último nome do usuário.
	 */
	@Column(name = "sobrenome")
	private String sobrenome;
	
	/**
	 * CPF do usuário.
	 */
	@Column(name = "cpf")
	@CPF(message = "CPF inválido")
	private String cpf;
	
	/**
	 * Data de nascimento do usuário.
	 */
	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;
	
	/**
	 * Gênero do usuário.
	 */
	@Column(name = "sexo")
	private String sexo;

}
