package br.com.pi.sebovirtual.dto;

import java.util.List;

import br.com.pi.sebovirtual.entities.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaItensPedidoDTO {
	private List<ItemDTO> itens;
	private Pedido pedido;
}
