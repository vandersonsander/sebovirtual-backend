package br.com.pi.sebovirtual.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.pi.sebovirtual.resource.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Pedido_tem_Anuncio")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
@ToString
public class PedidoTemAnuncio extends BaseEntity {
	
	@ManyToOne
    @JoinColumn(name = "id_pedido")
	@JsonIgnoreProperties("itens")	
    Pedido pedido;
	
    @ManyToOne
    @JoinColumn(name = "id_anuncio")
    @JsonIgnoreProperties("itens")
    HistoricoAnuncio historicoAnuncio;
 
	@Column(name = "quantidade")
    private Integer quantidade;

}