package br.com.pi.sebovirtual.dto;

import java.util.List;

import lombok.Data;

@Data
public class SearchDTO {
	private List<?> content;
	private List<FilterDTO> filters;
	private Long results;
	private Integer pages;
	private Integer currentPage;
}
