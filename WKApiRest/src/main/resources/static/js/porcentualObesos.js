function buscaPorcentual(){
    
    let xhr = new XMLHttpRequest();
    xhr.open("GET", "http://localhost:8000/WKApiRest/percentualObesos", true);

    xhr.addEventListener("load", function(){

            let response = xhr.responseText;

            let medias = JSON.parse(response);

            medias.forEach(function(itens){
				
				adicionaPacienteNaTabelaPorcentual(itens);
});

    });

    xhr.send();
}

function adicionaPacienteNaTabelaPorcentual(itens){
	
	let tr = montaTrPorcentual(itens);
	let tabela = document.querySelector("#porcentualObesos");
	tabela.appendChild(tr);
	
}

function montaTrPorcentual(medias){
	let tr = document.createElement("tr");
	tr.appendChild(montaTdPorcentual(medias['descricao']));
	tr.appendChild(montaTdPorcentual(medias['porcentagem'] + "%"));
	
	return tr;
}

function montaTdPorcentual(dados){
	let td = document.createElement("td");
	td.textContent = dados;
	return td;
}