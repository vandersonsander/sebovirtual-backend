package br.com.pi.sebovirtual.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.pi.sebovirtual.resource.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Pedido_tem_Anuncio")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class PedidoTemAnuncio extends BaseEntity {
	
	@ManyToOne(cascade=CascadeType.ALL)//(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_pedido")
	@JsonIgnore(true)
    private Pedido pedido;
	
    @ManyToOne(cascade=CascadeType.ALL)//(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_anuncio")
    @JsonIgnore(false)
    private HistoricoAnuncio historicoAnuncio;
 
	@JoinColumn(name = "quantidade")
    private Integer quantidade;
	
}
