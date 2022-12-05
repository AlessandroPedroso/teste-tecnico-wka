package br.com.WKApiRest.WKApiRest.model;

import java.io.Serializable;

public class IMC implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private double IMC;
	
	public double getIMC() {
		return IMC;
	}
	
	public void setIMC(double iMC) {
		IMC = iMC;
	}

	
}
