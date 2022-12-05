package br.com.WKApiRest.WKApiRest.model;

import java.io.Serializable;

public class QuantidadePossivelDoar implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private String tipoSanguineoReceptor;
	private int quantidade;
	
	public String getTipoSanguineoReceptor() {
		return tipoSanguineoReceptor;
	}
	public void setTipoSanguineoReceptor(String tipoSanguineoReceptor) {
		this.tipoSanguineoReceptor = tipoSanguineoReceptor;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	@Override
	public String toString() {
		return "QuantidadePossivelDoar [tipoSanguineoReceptor=" + tipoSanguineoReceptor + ", quantidade=" + quantidade
				+ "]";
	}
	
	
	
}
