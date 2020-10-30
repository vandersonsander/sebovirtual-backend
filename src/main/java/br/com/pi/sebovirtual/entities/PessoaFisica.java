package br.com.pi.sebovirtual.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.pi.sebovirtual.resource.BaseEntity;
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
public class PessoaFisica extends BaseEntity {//Usuario {
	
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

	/*public PessoaFisica(String email, String senha, Boolean habilitado, String autoridade,
			Set<HistoricoEndereco> enderecos, Set<Telefone> telefones, Set<HistoricoMetodoPagamento> pagamentos,
			String nome, String sobrenome, String cpf, LocalDate dataNascimento) {
		super(email, senha, habilitado, autoridade, enderecos, telefones, pagamentos);
		this.nome = nome;
		this.sobrenome=sobrenome;
		this.cpf=cpf;
		this.dataNascimento = dataNascimento;
	}*/

}
