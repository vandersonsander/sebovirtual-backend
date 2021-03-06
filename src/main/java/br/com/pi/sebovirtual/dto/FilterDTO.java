package br.com.pi.sebovirtual.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterDTO {
	private String filterName;
	private List<FilterOccurrencesDTO> occurrences;
}
