package br.com.pi.sebovirtual.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
@ToString
@Embeddable
public class PedidoTemAnuncioId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="id_pedido")
	private Long idPedido;
	
	@Column(name="id_anuncio")
	private Long idAnuncio;
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PedidoTemAnuncioId other = (PedidoTemAnuncioId) obj;
        return Objects.equals(getIdPedido(), other.getIdPedido()) && 
        	   Objects.equals(getIdAnuncio(), other.getIdAnuncio());
    }
}
