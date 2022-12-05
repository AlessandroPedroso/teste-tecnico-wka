package br.com.WKApiRest.WKApiRest.repository;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import br.com.WKApiRest.WKApiRest.model.Contatos;
import br.com.WKApiRest.WKApiRest.model.IMC;
import br.com.WKApiRest.WKApiRest.model.IMCMedia;
import br.com.WKApiRest.WKApiRest.model.TipoSanguineoIdade;

public class ApiJsonImpl implements ApiJson {


	@Override
	public List<Contatos> listaDeContatosApi(String urlApi) {
		
		List<Contatos> listPessoas = new ArrayList<Contatos>();

		
		try {
			
			//https://s3.amazonaws.com/gupy5/production/companies/52441/emails/1669646172212/e8330670-6f23-11ed-91a8-05f5cf6759fb/data_1.json
			URL url = new URL(urlApi);
			
			URLConnection connection = url.openConnection();
			
			InputStream inputStream = connection.getInputStream();
			
			BufferedReader br =  new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
			
			String contatos = "";
			
			StringBuilder jsonContatos = new StringBuilder();
			
			while((contatos = br.readLine()) !=null) { // enquanto conter dados
				jsonContatos.append(contatos);
			}
			
			JsonArray jsonArray = (JsonArray) JsonParser.parseString(jsonContatos.toString());
			
			
			for (JsonElement jsonElement : jsonArray) {
				
				Contatos pessoas = new Gson().fromJson(jsonElement, Contatos.class);
				listPessoas.add(pessoas);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return listPessoas;
	
	}

	@Override
	public int quantidadeCandidatosEstados(List<Contatos> contatos, String estado) {
		
		return contatos.stream().filter(p -> p.getEstado().contains(estado)).collect(Collectors.toList()).size();
	}

	@Override
	public List<String> quantidadeCandidatosString(int valor, String estado) {
		
		List<String> candidatosEstado = new ArrayList<String>();
    	candidatosEstado.add("Candidatos em " + estado +": " + valor);
    	
		return candidatosEstado;
	}

	@Override
	public List<IMCMedia> IMCMedia(List<IMC> listIMC, String descricao) {
		
		List<IMCMedia> listMedia = new ArrayList<IMCMedia>();
    	IMCMedia imcMedia = new IMCMedia();
    	imcMedia.setDescricaoIMC(descricao);
    	DecimalFormat df = new DecimalFormat("##,##");
    	double soma = 0.0;
    	
    	for (IMC imc : listIMC) {
			
    		soma = imc.getIMC() + imc.getIMC();
		}
    	
    	imcMedia.setMediaImc(Double.valueOf(df.format(soma/listIMC.size())));
    	listMedia.add(imcMedia);
		
		return listMedia;
	}

	@Override
	public double calculoIMC(Contatos contatos) {
		DecimalFormat df = new DecimalFormat("##,##");
		return Double.parseDouble(df.format(contatos.getPeso() / (contatos.getAltura() * contatos.getAltura())));
	}

	@Override
	public List<Double> IMCSEXO(List<Contatos> listaDeContatos) {
		
		List<Double> listContatos = new ArrayList<Double>();
		
    	for (Contatos contatoSexo : listaDeContatos) {
			
			if(calculoIMC(contatoSexo) > 30) {
				
				listContatos.add(calculoIMC(contatoSexo));
			}
	}
		
		return listContatos;
	}

	@Override
	public float porcentagemObesosMasculinoFeminino(int valorObtido, int valorTotal) {
		
		return (valorObtido * 100) / valorTotal;
	}

	@Override
	public List<Contatos> filtrarPorTipoSanguineo(List<Contatos> listContatos, String tipo) {
		
		return listContatos.stream().filter(tipoSanguineo -> tipoSanguineo.getTipo_sanguineo().equalsIgnoreCase(tipo.toString())).collect(Collectors.toList());
	}

	@Override
	public List<TipoSanguineoIdade> tipoSanguineoIdade(List<Contatos> tipoSangui) {
		
		List<TipoSanguineoIdade> listTipoSanguineoIdades = new ArrayList<TipoSanguineoIdade>();
		for (Contatos contatos : tipoSangui) {
			
			TipoSanguineoIdade tipoSanguineoIdade = new TipoSanguineoIdade();
			DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dataNascimento = LocalDate.parse(contatos.getData_nasc(),date);
			LocalDate dataAtual = LocalDate.now();
			Period periodo = Period.between(dataNascimento, dataAtual);
			
			tipoSanguineoIdade.setTipo_sanguineo(contatos.getTipo_sanguineo());
			tipoSanguineoIdade.setIdade(periodo.getYears());
			listTipoSanguineoIdades.add(tipoSanguineoIdade);
		}
		
		return listTipoSanguineoIdades;
	}

	@Override
	public double mediaIdadeTipoSanguineo(List<TipoSanguineoIdade> listTipoSanguineoIdades) {
		DecimalFormat df = new DecimalFormat("##");
		return Double.parseDouble(df.format(listTipoSanguineoIdades.stream().mapToInt(idade -> idade.getIdade()).average().getAsDouble()));
	}
	
	@Override
	public List<Contatos> tipoSanguineoIdadeDoador(List<Contatos> tipoSangui) {
		
		List<Contatos> listTipoSanguineoIdades = new ArrayList<Contatos>();
		for (Contatos contatos : tipoSangui) {
			
			DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dataNascimento = LocalDate.parse(contatos.getData_nasc(),date);
			LocalDate dataAtual = LocalDate.now();
			Period periodo = Period.between(dataNascimento, dataAtual);
			
			if(periodo.getYears() >= 16 && periodo.getYears() <=69 && contatos.getPeso() > 50) {
				listTipoSanguineoIdades.add(contatos);
			}
			
			
		}
		
		return listTipoSanguineoIdades;
	}
	
	

}
