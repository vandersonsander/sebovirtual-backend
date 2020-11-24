package br.com.pi.sebovirtual.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.pi.sebovirtual.entities.Pedido;

@Repository
@Transactional
public interface PesquisaMeusPedidosRepository extends 
	JpaRepository<Pedido, Integer> {
	/**
	 * Pesquisa todos os pedidos de um usuário.
	 * 
	 * @param query Query de pesquisa.
	 * @param userId Id do usuário.
	 * @param pageable Informação de paginação.
	 * @return
	 */
	@Query(value = "SELECT p FROM Pedido p WHERE p.usuario.id = ?1")
	Page<Pedido> searchByQuery(int userId, Pageable pageable);
	
}
