package br.com.pi.sebovirtual.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.entities.HistoricoEndereco;
import br.com.pi.sebovirtual.entities.Status;
import br.com.pi.sebovirtual.repositories.HistoricoEnderecoRepository;
import br.com.pi.sebovirtual.repositories.StatusRepository;
import br.com.pi.sebovirtual.resource.BaseService;

@Service
public class HistoricoEnderecoService 
	extends BaseService<HistoricoEndereco, HistoricoEnderecoRepository> {
	
	@Autowired
	private HistoricoEnderecoRepository enderecoRepository;
	
	@Autowired
	private StatusRepository statusRepository;
	
	@Override
	public HistoricoEndereco store(HistoricoEndereco endereco) {
		// Obtém o id do usuário dono do endereço.
		Integer idUsuario = endereco.getUsuario().getId();
		
		// Se o ID é igual a null, significa que está cadastrando um novo endereco
		if (endereco.getIdEndereco() == null) {
			// Obtém o próximo idEndereco e o define no objeto endereco.
			endereco.setIdEndereco(enderecoRepository.getNextIdEndereco(idUsuario));
		}
		
		// O novo registro possui status ativo.
		Optional<Status> statusAtivo = 
			statusRepository.findOneByNome(Status.ATIVO);
		if (statusAtivo.isPresent()) {
			endereco.setStatus(statusAtivo.get());
		}

		endereco.setDataModificacao(java.time.LocalDateTime.now());
		return super.store(endereco);
	}
	
	@Override
	public HistoricoEndereco update(Integer id, HistoricoEndereco endereco) {
		HistoricoEndereco current = super.getOne(id);
		
		// O idEndereco não muda, pois apenas uma nova versão deste mesmo
		// endereco é cadastrada. 
		endereco.setIdEndereco(current.getIdEndereco());
		
		// O status do registro atual muda para editado.
		Optional<Status> statusEditado = 
			statusRepository.findOneByNome(Status.EDITADO);
		if (statusEditado.isPresent()) {
			current.setStatus(statusEditado.get()); // Muda o status para editado			
		}
		
		// Cria um novo registro para este endereço.
		return this.store(endereco);
	}
	
	@Override
	public void destroy(Integer id) {
		// Não apaga o registro de fato, pois ele pode estar sendo
		// referenciado por um pedido, mas seu status muda para excluído.
		HistoricoEndereco current = this.getOne(id);
		Optional<Status> status = 
			statusRepository.findOneByNome(Status.EXCLUIDO);
		if (status.isPresent()) {
			current.setStatus(status.get()); // Muda o status para excluido			
		}
	}
	
}
