package com.nttdata.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ParamsDto {

	@NotNull
    @NotEmpty
	@JsonProperty("tipo_documento")
	private String typeOfDocument;
	
	@NotNull
    @NotEmpty
	@JsonProperty("documento")
	private String document;

	public String getTypeOfDocument() {
		return typeOfDocument;
	}

	public void setTypeOfDocument(String typeOfDocument) {
		this.typeOfDocument = typeOfDocument;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}
	
}
