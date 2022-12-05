package br.com.WKApiRest.WKApiRest.controllers;


import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.WKApiRest.WKApiRest.model.Contatos;
import br.com.WKApiRest.WKApiRest.model.IMC;
import br.com.WKApiRest.WKApiRest.model.MediaTipoSanguineo;
import br.com.WKApiRest.WKApiRest.model.PorcentagemObesos;
import br.com.WKApiRest.WKApiRest.model.QuantidadePossivelDoar;
import br.com.WKApiRest.WKApiRest.model.TipoSanguineoIdade;
import br.com.WKApiRest.WKApiRest.repository.ApiJson;
import br.com.WKApiRest.WKApiRest.repository.ApiJsonImpl;
import br.com.WKApiRest.WKApiRest.repository.ContatosRepository;


@RestController
public class GreetingsController {
	
	@Autowired
	private ContatosRepository contatosRepository;
	
	private ApiJson apiJson = new ApiJsonImpl();

    @GetMapping(value ="adicionaTodos")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Contatos>> adicionaContatos() {
    	
    	String urlApi = "https://s3.amazonaws.com/gupy5/production/companies/52441/emails/1669646172212/e8330670-6f23-11ed-91a8-05f5cf6759fb/data_1.json";
    	List<Contatos> lisContatos = apiJson.listaDeContatosApi(urlApi);
    	
    	
        return new ResponseEntity<List<Contatos>>(lisContatos, HttpStatus.OK);
    }
    
    // vai gravar todos os dados que vem da api no banco de dados
    @PostMapping(value ="GravaTodosBanco")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> gravaNoBanco() {
    	
    	String urlApi = "https://s3.amazonaws.com/gupy5/production/companies/52441/emails/1669646172212/e8330670-6f23-11ed-91a8-05f5cf6759fb/data_1.json";
    	
    	List<Contatos> lisContatos = apiJson.listaDeContatosApi(urlApi);
    	
    	Iterator<Contatos> iterator = lisContatos.iterator();
    	
    	if (iterator.hasNext() == false){
			
    		   return new ResponseEntity<String>("Lista com problema no retorno!", HttpStatus.FOUND);
		}else {
			
		   	for (Contatos contatos : lisContatos) {
				
	    		contatosRepository.save(contatos);
			}
		   	
		   	return new ResponseEntity<String>("Gravado com sucesso!", HttpStatus.OK);
		}
     
    }
    
    @GetMapping(value ="candidatosEstados")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<String>> buscaCanditatosEstados() {
    	
    	
    	List<Contatos> lisContatos = contatosRepository.findAll();
    	
    	int AC = apiJson.quantidadeCandidatosEstados(lisContatos, "AC");
    	int AL = apiJson.quantidadeCandidatosEstados(lisContatos, "AL");
    	int AP = apiJson.quantidadeCandidatosEstados(lisContatos, "AP");
    	int AM = apiJson.quantidadeCandidatosEstados(lisContatos, "AM");
    	int BA = apiJson.quantidadeCandidatosEstados(lisContatos, "BA");
    	int CE = apiJson.quantidadeCandidatosEstados(lisContatos, "CE");
    	int DF = apiJson.quantidadeCandidatosEstados(lisContatos, "DF");
    	int ES = apiJson.quantidadeCandidatosEstados(lisContatos, "ES");
    	int GO = apiJson.quantidadeCandidatosEstados(lisContatos, "GO");
    	int MA = apiJson.quantidadeCandidatosEstados(lisContatos, "MA");
    	int MT = apiJson.quantidadeCandidatosEstados(lisContatos, "MT");
    	int MS = apiJson.quantidadeCandidatosEstados(lisContatos, "MS");
    	int MG = apiJson.quantidadeCandidatosEstados(lisContatos, "MG");
    	int PA = apiJson.quantidadeCandidatosEstados(lisContatos, "PA");
    	int PB = apiJson.quantidadeCandidatosEstados(lisContatos, "PB");
    	int PR = apiJson.quantidadeCandidatosEstados(lisContatos, "PR");
    	int PE = apiJson.quantidadeCandidatosEstados(lisContatos, "PE");
    	int PI = apiJson.quantidadeCandidatosEstados(lisContatos, "PI");
    	int RJ = apiJson.quantidadeCandidatosEstados(lisContatos, "RJ");
    	int RN = apiJson.quantidadeCandidatosEstados(lisContatos, "RN");
    	int RS = apiJson.quantidadeCandidatosEstados(lisContatos, "RS");
    	int RO = apiJson.quantidadeCandidatosEstados(lisContatos, "RO");
    	int RR = apiJson.quantidadeCandidatosEstados(lisContatos, "RR");
    	int SC = apiJson.quantidadeCandidatosEstados(lisContatos, "SC");
    	int SP = apiJson.quantidadeCandidatosEstados(lisContatos, "SP");
    	int SE = apiJson.quantidadeCandidatosEstados(lisContatos, "SE");
    	int TO = apiJson.quantidadeCandidatosEstados(lisContatos, "TO");
    	
    	List<String> candidatosEstado = new ArrayList<String>();
    	candidatosEstado.addAll(apiJson.quantidadeCandidatosString(AC,"AC"));
    	candidatosEstado.addAll(apiJson.quantidadeCandidatosString(AL,"AL"));
    	candidatosEstado.addAll(apiJson.quantidadeCandidatosString(AP,"AP"));
    	candidatosEstado.addAll(apiJson.quantidadeCandidatosString(AM,"AM"));
    	candidatosEstado.addAll(apiJson.quantidadeCandidatosString(BA,"BA"));
    	candidatosEstado.addAll(apiJson.quantidadeCandidatosString(CE,"CE"));
    	candidatosEstado.addAll(apiJson.quantidadeCandidatosString(DF,"DF"));
    	candidatosEstado.addAll(apiJson.quantidadeCandidatosString(ES,"ES"));
    	candidatosEstado.addAll(apiJson.quantidadeCandidatosString(GO,"GO"));
    	candidatosEstado.addAll(apiJson.quantidadeCandidatosString(MA,"MA"));
    	candidatosEstado.addAll(apiJson.quantidadeCandidatosString(MT,"MT"));
    	candidatosEstado.addAll(apiJson.quantidadeCandidatosString(MS,"MS"));
    	candidatosEstado.addAll(apiJson.quantidadeCandidatosString(MG,"MG"));
    	candidatosEstado.addAll(apiJson.quantidadeCandidatosString(PA,"PA"));
    	candidatosEstado.addAll(apiJson.quantidadeCandidatosString(PB,"PB"));
    	candidatosEstado.addAll(apiJson.quantidadeCandidatosString(PR,"PR"));
    	candidatosEstado.addAll(apiJson.quantidadeCandidatosString(PE,"PE"));
    	candidatosEstado.addAll(apiJson.quantidadeCandidatosString(PI,"PI"));
    	candidatosEstado.addAll(apiJson.quantidadeCandidatosString(RJ,"RJ"));
    	candidatosEstado.addAll(apiJson.quantidadeCandidatosString(RN,"RN"));
    	candidatosEstado.addAll(apiJson.quantidadeCandidatosString(RS,"RS"));
    	candidatosEstado.addAll(apiJson.quantidadeCandidatosString(RO,"RO"));
    	candidatosEstado.addAll(apiJson.quantidadeCandidatosString(RR,"RR"));
    	candidatosEstado.addAll(apiJson.quantidadeCandidatosString(SC,"SC"));
    	candidatosEstado.addAll(apiJson.quantidadeCandidatosString(SP,"SP"));
    	candidatosEstado.addAll(apiJson.quantidadeCandidatosString(SE,"SE"));
    	candidatosEstado.addAll(apiJson.quantidadeCandidatosString(TO,"TO"));
    	
        return new ResponseEntity<List<String>>(candidatosEstado, HttpStatus.OK);
    }
    
    @GetMapping(value ="imcMedio")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Object>> imcMedio() {
    	
    	List<Object> listObjects = new ArrayList<Object>();
    	List<Contatos> listContatos = contatosRepository.findAll();
    	
    	IMC imcMedio = null;
    	List<IMC> list0A10 = new ArrayList<IMC>();
    	List<IMC> list11A20 = new ArrayList<IMC>();
    	List<IMC> list21A30 = new ArrayList<IMC>();
    	List<IMC> list31A40 = new ArrayList<IMC>();
    	List<IMC> list41A50 = new ArrayList<IMC>();
    	List<IMC> list51A60 = new ArrayList<IMC>();
    	List<IMC> list60A71 = new ArrayList<IMC>();
    	List<IMC> list71A80 = new ArrayList<IMC>();
    	List<IMC> list81A90 = new ArrayList<IMC>();
    	
    	for (Contatos pessoa : listContatos) {
			
    		if(pessoa.getData_nasc().contains("")) {
    			DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    			LocalDate dataNascimento = LocalDate.parse(pessoa.getData_nasc(),date);
    			LocalDate dataAtual = LocalDate.now();
    			Period periodo = Period.between(dataNascimento, dataAtual);
    			
    			if((periodo.getYears() >= 0) && (periodo.getYears() < 11)){
    				imcMedio = new IMC();
    				
    				imcMedio.setIMC(apiJson.calculoIMC(pessoa));
    				list0A10.add(imcMedio);
    			}else if ((periodo.getYears() >=11) && (periodo.getYears() < 21)) {
    				
    				imcMedio = new IMC();
    				imcMedio.setIMC(apiJson.calculoIMC(pessoa));
    				list11A20.add(imcMedio);
    			}else if ((periodo.getYears() >=21) && (periodo.getYears() < 31)) {
    				
    				imcMedio = new IMC();
    				imcMedio.setIMC(apiJson.calculoIMC(pessoa));
    				list21A30.add(imcMedio);
    			}else if ((periodo.getYears() >=31) && (periodo.getYears() < 41)) {
    				
    				imcMedio = new IMC();
    				imcMedio.setIMC(apiJson.calculoIMC(pessoa));
    				list31A40.add(imcMedio);
    			}else if ((periodo.getYears() >= 41) && (periodo.getYears() < 51)) {
    				
    				imcMedio = new IMC();
    				imcMedio.setIMC(apiJson.calculoIMC(pessoa));
    				list41A50.add(imcMedio);
    			}else if ((periodo.getYears() >= 51) && (periodo.getYears() < 61)) {
    				
    				imcMedio = new IMC();
    				imcMedio.setIMC(apiJson.calculoIMC(pessoa));
    				list51A60.add(imcMedio);
    			}else if ((periodo.getYears() >= 61) && (periodo.getYears() < 71)) {
    				
    				imcMedio = new IMC();
    				imcMedio.setIMC(apiJson.calculoIMC(pessoa));
    				list60A71.add(imcMedio);
    			}else if ((periodo.getYears() >= 71) && (periodo.getYears() < 81)) {
    				
    				imcMedio = new IMC();
    				imcMedio.setIMC(apiJson.calculoIMC(pessoa));
    				list71A80.add(imcMedio);
    			}else if ((periodo.getYears() >= 81) && (periodo.getYears() < 91)) {
    				
    				imcMedio = new IMC();
    				imcMedio.setIMC(apiJson.calculoIMC(pessoa));
    				list81A90.add(imcMedio);
    			}
    		}
		}
    	
    	
    	listObjects.add(apiJson.IMCMedia(list0A10, "Media do IMC entre 0 a 10"));
    	listObjects.add(apiJson.IMCMedia(list11A20, "Media do IMC entre 11 a 20"));
    	listObjects.add(apiJson.IMCMedia(list21A30, "Media do IMC entre 21 a 30"));
    	listObjects.add(apiJson.IMCMedia(list31A40, "Media do IMC entre 31 a 40"));
    	listObjects.add(apiJson.IMCMedia(list41A50, "Media do IMC entre 41 a 50"));
    	listObjects.add(apiJson.IMCMedia(list51A60, "Media do IMC entre 51 a 60"));
    	listObjects.add(apiJson.IMCMedia(list60A71, "Media do IMC entre 61 a 70"));
    	listObjects.add(apiJson.IMCMedia(list71A80, "Media do IMC entre 71 a 80"));
    	listObjects.add(apiJson.IMCMedia(list81A90, "Media do IMC entre 81 a 90"));
    	
    	
    	return new ResponseEntity<List<Object>>(listObjects, HttpStatus.OK);
    }
    
    @GetMapping(value ="percentualObesos")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<PorcentagemObesos>> obesosFemininoMasculino() {
    	
    	List<PorcentagemObesos> listPorcentagemObesos = new ArrayList<PorcentagemObesos>();
    	PorcentagemObesos porcentagemObesosFeminino = new PorcentagemObesos();
    	PorcentagemObesos porcentagemObesosMasculino = new PorcentagemObesos();
    	
    	List<Contatos> listContatos = contatosRepository.findAll();
    	
    	List<Contatos> listFeminino = listContatos.stream().filter(contatos -> contatos.getSexo().equalsIgnoreCase("feminino")).collect(Collectors.toList());
    	List<Contatos> listMasculino = listContatos.stream().filter(contatos -> contatos.getSexo().equalsIgnoreCase("masculino")).collect(Collectors.toList());
    	
    	List<Double> imcFeminino = apiJson.IMCSEXO(listFeminino);
    	List<Double> imcMaculino = apiJson.IMCSEXO(listMasculino);
    
    	porcentagemObesosFeminino.setDescricao("Porcentagem de Obesos entre Mulheres");
    	porcentagemObesosFeminino.setPorcentagem(apiJson.porcentagemObesosMasculinoFeminino(imcFeminino.size(), listFeminino.size()));
    	
    	porcentagemObesosMasculino.setDescricao("Porcentagem de Obesos entre Homens");
    	porcentagemObesosMasculino.setPorcentagem(apiJson.porcentagemObesosMasculinoFeminino(imcMaculino.size(), listMasculino.size()));
    	
    	listPorcentagemObesos.add(porcentagemObesosFeminino);
    	listPorcentagemObesos.add(porcentagemObesosMasculino);
    	
    	//double valorTotalImcFeminino = imcFeminino.stream().mapToDouble(valor -> valor).sum();
    	//double valorTotalImcMasculino = imcMaculino.stream().mapToDouble(valor -> valor).sum();
    	
    	return new ResponseEntity<List<PorcentagemObesos>>(listPorcentagemObesos,HttpStatus.OK);
    
    }
    
    @GetMapping(value ="mediaIdadeTipoSanguineo")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<MediaTipoSanguineo>> mediaIdadeTipoSanguineo() {
    	
    		MediaTipoSanguineo Amais = new MediaTipoSanguineo();
    		MediaTipoSanguineo Amenos = new MediaTipoSanguineo();
    		MediaTipoSanguineo Bmais = new MediaTipoSanguineo();
    		MediaTipoSanguineo Bmenos = new MediaTipoSanguineo();
    		MediaTipoSanguineo ABmais = new MediaTipoSanguineo();
    		MediaTipoSanguineo ABmenos = new MediaTipoSanguineo();
    		MediaTipoSanguineo Omais = new MediaTipoSanguineo();
    		MediaTipoSanguineo Omenos = new MediaTipoSanguineo();
    		
    		List<MediaTipoSanguineo> listMediaTipoSanguineos = new ArrayList<MediaTipoSanguineo>();
    	
    		List<Contatos> listContatos = contatosRepository.findAll();
    		
    		List<Contatos> tipoAmais = apiJson.filtrarPorTipoSanguineo(listContatos,"A+");
    		List<Contatos> tipoAmenos = apiJson.filtrarPorTipoSanguineo(listContatos,"A-");
    		List<Contatos> tipoBmais = apiJson.filtrarPorTipoSanguineo(listContatos,"B+");
    		List<Contatos> tipoBmenos = apiJson.filtrarPorTipoSanguineo(listContatos,"B-");
    		List<Contatos> tipoABmais = apiJson.filtrarPorTipoSanguineo(listContatos,"AB+");
    		List<Contatos> tipoABmenos = apiJson.filtrarPorTipoSanguineo(listContatos,"AB-");
    		List<Contatos> tipoOmais = apiJson.filtrarPorTipoSanguineo(listContatos,"O+");
    		List<Contatos> tipoOMenos = apiJson.filtrarPorTipoSanguineo(listContatos,"O-");
    		
    		List<TipoSanguineoIdade> listTipoSanguineoIdadesAmais = apiJson.tipoSanguineoIdade(tipoAmais);
    		Amais.setDescricao("Média idade tipo sanguíneo A+");
    		Amais.setMediaIdade(apiJson.mediaIdadeTipoSanguineo(listTipoSanguineoIdadesAmais));
    		listMediaTipoSanguineos.add(Amais);
    		
    		List<TipoSanguineoIdade> listTipoSanguineoIdadesAmenos = apiJson.tipoSanguineoIdade(tipoAmenos);
    		Amenos.setDescricao("Média idade tipo sanguíneo A-");
    		Amenos.setMediaIdade(apiJson.mediaIdadeTipoSanguineo(listTipoSanguineoIdadesAmenos));
    		listMediaTipoSanguineos.add(Amenos);
    		
    		List<TipoSanguineoIdade> listTipoSanguineoIdadesBmais = apiJson.tipoSanguineoIdade(tipoBmais);
    		Bmais.setDescricao("Média idade tipo sanguíneo B+");
    		Bmais.setMediaIdade(apiJson.mediaIdadeTipoSanguineo(listTipoSanguineoIdadesBmais));
    		listMediaTipoSanguineos.add(Bmais);
    		
    		List<TipoSanguineoIdade> listTipoSanguineoIdadesBmenos = apiJson.tipoSanguineoIdade(tipoBmenos);
    		Bmenos.setDescricao("Média idade tipo sanguíneo B+");
    		Bmenos.setMediaIdade(apiJson.mediaIdadeTipoSanguineo(listTipoSanguineoIdadesBmenos));
    		listMediaTipoSanguineos.add(Bmenos);
    		
    		List<TipoSanguineoIdade> listTipoSanguineoIdadesABmais = apiJson.tipoSanguineoIdade(tipoABmais);
    		ABmais.setDescricao("Média idade tipo sanguíneo AB+");
    		ABmais.setMediaIdade(apiJson.mediaIdadeTipoSanguineo(listTipoSanguineoIdadesABmais));
    		listMediaTipoSanguineos.add(ABmais);
    		
    		List<TipoSanguineoIdade> listTipoSanguineoIdadesABmenos = apiJson.tipoSanguineoIdade(tipoABmenos);
    		ABmenos.setDescricao("Média idade tipo sanguíneo AB-");
    		ABmenos.setMediaIdade(apiJson.mediaIdadeTipoSanguineo(listTipoSanguineoIdadesABmenos));
    		listMediaTipoSanguineos.add(ABmenos);
    		
    		List<TipoSanguineoIdade> listTipoSanguineoIdadesOmais = apiJson.tipoSanguineoIdade(tipoOmais);
    		Omais.setDescricao("Média idade tipo sanguíneo O+");
    		Omais.setMediaIdade(apiJson.mediaIdadeTipoSanguineo(listTipoSanguineoIdadesOmais));
    		listMediaTipoSanguineos.add(Omais);
    		
    		List<TipoSanguineoIdade> listTipoSanguineoIdadesOmenos = apiJson.tipoSanguineoIdade(tipoOMenos);
    		Omenos.setDescricao("Média idade tipo sanguíneo O-");
    		Omenos.setMediaIdade(apiJson.mediaIdadeTipoSanguineo(listTipoSanguineoIdadesOmenos));
    		listMediaTipoSanguineos.add(Omenos);
    		
    		
    		return new ResponseEntity<List<MediaTipoSanguineo>>(listMediaTipoSanguineos,HttpStatus.OK);
    	}
    

    @GetMapping(value ="quantidadePossiveisDoadores")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<QuantidadePossivelDoar>> quantidadePossiveisDoadores() {
    	
    	QuantidadePossivelDoar quantidadePossivelDoar = new QuantidadePossivelDoar();
    	List<QuantidadePossivelDoar> listPossivelDoar = new ArrayList<QuantidadePossivelDoar>();
    	
    	List<Object> listaArray = new ArrayList<Object>();
    	
    	List<Contatos> listContatos = contatosRepository.findAll();
    	
    	List<Contatos> contatosDoadores = apiJson.tipoSanguineoIdadeDoador(listContatos);
    	
		List<Contatos> listtipoAmais = apiJson.filtrarPorTipoSanguineo(contatosDoadores,"A+");
		List<Contatos> listtipoAmenos = apiJson.filtrarPorTipoSanguineo(contatosDoadores,"A-");
		List<Contatos> listtipoBmais = apiJson.filtrarPorTipoSanguineo(contatosDoadores,"B+");
		List<Contatos> listtipoBmenos = apiJson.filtrarPorTipoSanguineo(contatosDoadores,"B-");
		List<Contatos> listtipoABmais = apiJson.filtrarPorTipoSanguineo(contatosDoadores,"AB+");
		List<Contatos> listtipoABmenos = apiJson.filtrarPorTipoSanguineo(contatosDoadores,"AB-");
		List<Contatos> listtipoOmais = apiJson.filtrarPorTipoSanguineo(contatosDoadores,"O+");
		List<Contatos> listtipoOMenos = apiJson.filtrarPorTipoSanguineo(contatosDoadores,"O-");
		
		int tipoAmais = listtipoAmais.size() + listtipoAmenos.size() + listtipoOmais.size() + listtipoOMenos.size();
		QuantidadePossivelDoar Apositivo = new QuantidadePossivelDoar();
		Apositivo.setTipoSanguineoReceptor("A+");
		Apositivo.setQuantidade(tipoAmais);
		listPossivelDoar.add(Apositivo);
		
		int tipoAmenos = listtipoAmenos.size() + listtipoOMenos.size();
		QuantidadePossivelDoar Anegativo = new QuantidadePossivelDoar();
		Anegativo.setTipoSanguineoReceptor("A-");
		Anegativo.setQuantidade(tipoAmenos);
		listPossivelDoar.add(Anegativo);
		
		int tipoBmais = listtipoBmais.size() + listtipoBmenos.size() + listtipoOmais.size() + listtipoOMenos.size();
		QuantidadePossivelDoar Bpositivo = new QuantidadePossivelDoar();
		Bpositivo.setTipoSanguineoReceptor("B+");
		Bpositivo.setQuantidade(tipoBmais);
		listPossivelDoar.add(Bpositivo);
		
		int tipoBmenos = listtipoBmenos.size() + listtipoOMenos.size();
		QuantidadePossivelDoar Bnegativo = new QuantidadePossivelDoar();
		Bnegativo.setTipoSanguineoReceptor("B-");
		Bnegativo.setQuantidade(tipoBmenos);
		listPossivelDoar.add(Bnegativo);
		
    	int tipoABmais = listtipoAmais.size() + listtipoAmenos.size() + listtipoBmais.size() + listtipoBmenos.size() + listtipoABmais.size() + listtipoABmenos.size() + listtipoOmais.size() + listtipoOMenos.size();
    	QuantidadePossivelDoar ABpositivo = new QuantidadePossivelDoar();
    	ABpositivo.setTipoSanguineoReceptor("AB+");
    	ABpositivo.setQuantidade(tipoABmais);
		listPossivelDoar.add(ABpositivo);
		
    	int tipoABmenos = listtipoAmenos.size() + listtipoBmenos.size() + listtipoABmenos.size() + listtipoOMenos.size();
    	QuantidadePossivelDoar ABnegativo = new QuantidadePossivelDoar();
    	ABnegativo.setTipoSanguineoReceptor("AB-");
    	ABnegativo.setQuantidade(tipoABmenos);
		listPossivelDoar.add(ABnegativo);
		
    	int tipoOmais = listtipoOmais.size() + listtipoOMenos.size();
    	QuantidadePossivelDoar Opositivo = new QuantidadePossivelDoar();
    	Opositivo.setTipoSanguineoReceptor("O+");
    	Opositivo.setQuantidade(tipoOmais);
    	listPossivelDoar.add(Opositivo);
    	
    	int tipoOMenos = listtipoOmais.size();
    	QuantidadePossivelDoar Onegativo = new QuantidadePossivelDoar();
    	Onegativo.setTipoSanguineoReceptor("O-");
    	Onegativo.setQuantidade(tipoOMenos);
    	listPossivelDoar.add(Onegativo);
    	
    	
    	return new ResponseEntity<List<QuantidadePossivelDoar>>(listPossivelDoar,HttpStatus.OK);
    	
    }
    
}
