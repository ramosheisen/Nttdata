package com.nttdata.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConsultEmployee {
	
	@JsonProperty("tipo_documento")
	private String typeDocument;
	
	@JsonProperty("documento")
	private String document;
	
	public ConsultEmployee() {
		
	}
	
	public ConsultEmployee(String typeDocument, String document) {
		this.typeDocument = typeDocument;
		this.document = document;
	}

	public String getTypeDocument() {
		return typeDocument;
	}
	
	public String getDocument() {
		return document;
	}
	
}
