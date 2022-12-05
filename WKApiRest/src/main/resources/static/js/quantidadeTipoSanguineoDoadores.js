function buscaQuantidadeTipoSanguineo(){
    
    let xhr = new XMLHttpRequest();
    xhr.open("GET", "http://localhost:8000/WKApiRest/quantidadePossiveisDoadores", true);

    xhr.addEventListener("load", function(){

            let response = xhr.responseText;

            let medias = JSON.parse(response);

            medias.forEach(function(itens){
				
				adicionaPacienteNaTabelaQuantidadeTipoSanguineo(itens);
});

    });

    xhr.send();
}

function adicionaPacienteNaTabelaQuantidadeTipoSanguineo(itens){
	
	let tr = montaTrQuantidadeTipoSanguineo(itens);
	let tabela = document.querySelector("#quantidadeDoadoresTipoSanguineo");
	tabela.appendChild(tr);
	
}

function montaTrQuantidadeTipoSanguineo(medias){
	let tr = document.createElement("tr");
	tr.appendChild(montaTdQuantidadeTipoSanguineo(medias['tipoSanguineoReceptor']));
	tr.appendChild(montaTdQuantidadeTipoSanguineo(medias['quantidade']));
	
	return tr;
}

function montaTdQuantidadeTipoSanguineo(dados){
	let td = document.createElement("td");
	td.textContent = dados;
	return td;
}