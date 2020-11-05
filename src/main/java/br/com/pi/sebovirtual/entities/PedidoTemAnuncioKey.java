package br.com.pi.sebovirtual.entities;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
@ToString
@EqualsAndHashCode
public class PedidoTemAnuncioKey implements Serializable {

	@Column(name="id_pedido")
	Long idPedido;
	
	@Column(name="id_anuncio")
	Long idAnuncio;
}
