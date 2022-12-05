package br.com.WKApiRest.WKApiRest.model;

import java.io.Serializable;

public class MediaTipoSanguineo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String descricao;
	private double mediaIdade;
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getMediaIdade() {
		return mediaIdade;
	}
	public void setMediaIdade(double mediaIdade) {
		this.mediaIdade = mediaIdade;
	}
	@Override
	public String toString() {
		return "MediaTipoSanguineo [descricao=" + descricao + ", mediaIdade=" + mediaIdade + "]";
	}
	
	

}
