package org.dta.alexendrie.model;

public enum MediaType {
	Livre("Livre"), CD("CD"), DVD("DVD");

	private String value;

	private MediaType(String value) {
		this.value = value;
	}
}