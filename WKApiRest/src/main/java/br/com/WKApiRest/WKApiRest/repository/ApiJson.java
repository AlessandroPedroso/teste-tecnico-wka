package br.com.WKApiRest.WKApiRest.repository;

import java.util.List;

import br.com.WKApiRest.WKApiRest.model.Contatos;
import br.com.WKApiRest.WKApiRest.model.IMC;
import br.com.WKApiRest.WKApiRest.model.IMCMedia;
import br.com.WKApiRest.WKApiRest.model.TipoSanguineoIdade;

public interface ApiJson {
	
	List<Contatos> listaDeContatosApi (String url);
	int quantidadeCandidatosEstados (List<Contatos> contatos,String estado);
	List<String> quantidadeCandidatosString (int valor, String estado);
	List<IMCMedia> IMCMedia (List<IMC> listIMC, String descricao);
	double calculoIMC (Contatos contatos);
	List<Double> IMCSEXO (List<Contatos> listaDeContatos);
	float porcentagemObesosMasculinoFeminino (int valorObtidoFeminino, int valorTotal);
	List<Contatos> filtrarPorTipoSanguineo(List<Contatos> listContatos,String string);
	List<TipoSanguineoIdade> tipoSanguineoIdade(List<Contatos> tipoAmais);
	double mediaIdadeTipoSanguineo(List<TipoSanguineoIdade> listTipoSanguineoIdadesAmais);
	List<Contatos> tipoSanguineoIdadeDoador(List<Contatos> tipoAmais);

}
