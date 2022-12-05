function buscaMediaIdades(){
    
    let xhr = new XMLHttpRequest();
    xhr.open("GET", "http://localhost:8000/WKApiRest/imcMedio", true);

    xhr.addEventListener("load", function(){

            let response = xhr.responseText;

            let medias = JSON.parse(response);

            medias.forEach(function(itens){
				
				adicionaPacienteNaTabela(itens);
});

    });

    xhr.send();
}


function adicionaPacienteNaTabela(medias){
	
	medias.forEach(function(itens){
	let tr = montaTr(itens);
	let tabela = document.querySelector("#tabelaMediaIdade");
	tabela.appendChild(tr);
	});
	

	
}

function montaTr(medias){
	let tr = document.createElement("tr");
	tr.appendChild(montaTd(medias['descricaoIMC']));
	tr.appendChild(montaTd(medias['mediaImc']));
	
	return tr;
}

function montaTd(dados){
	let td = document.createElement("td");
	td.textContent = dados;
	return td;
}