function buscaMediaIdade(){
    
    let xhr = new XMLHttpRequest();
    xhr.open("GET", "http://localhost:8000/WKApiRest/mediaIdadeTipoSanguineo", true);

    xhr.addEventListener("load", function(){

            let response = xhr.responseText;

            let medias = JSON.parse(response);

            medias.forEach(function(itens){
				
				adicionaPacienteNaTabelaMediaIdade(itens);
});

    });

    xhr.send();
}

function adicionaPacienteNaTabelaMediaIdade(itens){
	
	let tr = montaTrMediaIdade(itens);
	let tabela = document.querySelector("#mediaIdadeTipoSanguineo");
	tabela.appendChild(tr);
	
}

function montaTrMediaIdade(medias){
	let tr = document.createElement("tr");
	tr.appendChild(montaTdMediaIdade(medias['descricao']));
	tr.appendChild(montaTdMediaIdade(medias['mediaIdade']));
	
	return tr;
}

function montaTdMediaIdade(dados){
	let td = document.createElement("td");
	td.textContent = dados;
	return td;
}