package br.com.WKApiRest.WKApiRest.model;

import java.io.Serializable;

public class PorcentagemObesos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String descricao;
	private float porcentagem;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getPorcentagem() {
		return porcentagem;
	}
	public void setPorcentagem(float porcentagem) {
		this.porcentagem = porcentagem;
	}
	
	
}
