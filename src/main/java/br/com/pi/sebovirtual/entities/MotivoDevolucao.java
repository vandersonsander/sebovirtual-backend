package br.com.pi.sebovirtual.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.pi.sebovirtual.resource.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Motivo_Devolucao")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
@ToString
public class MotivoDevolucao extends BaseEntity {
	
	/**
	 * Descrição do motivo de devolução.
	 */
	private String descricao;

}
