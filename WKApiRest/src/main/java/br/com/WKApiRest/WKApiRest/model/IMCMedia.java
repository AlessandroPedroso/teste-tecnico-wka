package br.com.WKApiRest.WKApiRest.model;

import java.io.Serializable;

public class IMCMedia implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String descricaoIMC;
	private double mediaImc;
	public String getDescricaoIMC() {
		return descricaoIMC;
	}
	public void setDescricaoIMC(String descricaoIMC) {
		this.descricaoIMC = descricaoIMC;
	}
	public double getMediaImc() {
		return mediaImc;
	}
	public void setMediaImc(double mediaImc) {
		this.mediaImc = mediaImc;
	}
	@Override
	public String toString() {
		return "IMCMedia [descricaoIMC=" + descricaoIMC + ", mediaImc=" + mediaImc + "]";
	}
	
	
	
}
