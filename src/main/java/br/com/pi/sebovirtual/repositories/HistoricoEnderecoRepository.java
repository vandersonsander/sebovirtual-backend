package br.com.pi.sebovirtual.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import br.com.pi.sebovirtual.entities.HistoricoEndereco;
import br.com.pi.sebovirtual.entities.Status;
import br.com.pi.sebovirtual.resource.BaseRepository;

public interface HistoricoEnderecoRepository extends BaseRepository<HistoricoEndereco> {

	/**
	 * Retorna o próximo idEndereco de um usuário.
	 * @param idUsuario Id do usuário.
	 * @return O próximo idEndereco desse usuário.
	 */
	@Query(value = "SELECT MAX(id_endereco) + 1 AS next_id FROM Historico_Endereco " +
			 	   "WHERE fk_id_usuario = :idUsuario", nativeQuery=true)
	public Integer getNextIdEndereco(int idUsuario);
	
	/**
	 * Retorna apenas os endereços ativos de um usuário.
	 * @param idUsuario Id do usuário.
	 * @return Endereços ativos desse usuário.
	 */
	@Query(value="SELECT * FROM Historico_Endereco " +
			     "WHERE fk_id_usuario = :id and fk_id_status IN " +
			     "(SELECT id from Status WHERE nome = '" + 
			     Status.ATIVO + "') ORDER BY data_modificacao DESC", nativeQuery = true)
	public List<HistoricoEndereco> findAllActiveAddressByUserId(int id);

	/**
	  * Retorna o método de pagamento principal de um usuário.
	  * @param idUsuario Id do usuário.
	  * @return Método de pagamento ativo principal desse usuário.
	  */
	 @Query(value="SELECT id FROM Historico_Endereco " +
	              "WHERE fk_id_usuario = :userId AND principal = 1 AND "
	              + "fk_id_status IN " + 
	              "(SELECT id from Status WHERE nome = '" + 
	              Status.ATIVO + "')", nativeQuery = true)
	public Integer findMainActiveAddressByUser(int userId);
	
}