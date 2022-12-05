package br.com.WKApiRest.WKApiRest.model;

import java.io.Serializable;

public class TipoSanguineoIdade implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String tipo_sanguineo;
	private int idade;
	
	public String getTipo_sanguineo() {
		return tipo_sanguineo;
	}
	public void setTipo_sanguineo(String tipo_sanguineo) {
		this.tipo_sanguineo = tipo_sanguineo;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	@Override
	public String toString() {
		return "TipoSanguineoIdade [tipo_sanguineo=" + tipo_sanguineo + ", idade=" + idade + "]";
	}
	
	

}
