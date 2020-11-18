package br.com.pi.sebovirtual.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import br.com.pi.sebovirtual.entities.HistoricoMetodoPagamento;
import br.com.pi.sebovirtual.entities.Status;
import br.com.pi.sebovirtual.resource.BaseRepository;

public interface HistoricoMetodoPagamentoRepository extends 
	BaseRepository<HistoricoMetodoPagamento> {
	
	/**
	 * Retorna o próximo idMetodoPagamento de um usuário.
	 * @param idUsuario Id do usuário.
	 * @return O próximo idMetodoPagamento desse usuário.
	 */
	@Query(value = "SELECT MAX(id_metodo_pagamento) + 1 AS next_id FROM Historico_Metodo_Pagamento " +
			 	   "WHERE fk_id_usuario = :idUsuario", nativeQuery=true)
	public Integer getNextIdMetodoPagamento(int idUsuario);
	
	/**
	 * Retorna apenas os métodos de pagamento ativos de um usuário.
	 * @param idUsuario Id do usuário.
	 * @return Métodos de pagamento ativos desse usuário.
	 */
	@Query(value="SELECT * FROM Historico_Metodo_Pagamento " +
			     "WHERE fk_id_usuario = :id and fk_id_status IN " +
			     "(SELECT id from Status WHERE nome = '" + 
			     Status.ATIVO + "')", nativeQuery = true)
	List<HistoricoMetodoPagamento> findAllActivePaymentsMethodsByUserId(int id);
	
}