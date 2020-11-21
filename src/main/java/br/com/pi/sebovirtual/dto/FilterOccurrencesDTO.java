package br.com.pi.sebovirtual.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterOccurrencesDTO {
	private String value;
	private Long count;
	
}
