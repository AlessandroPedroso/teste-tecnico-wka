
function buscaCandidadosEstados(){
    
    let xhr = new XMLHttpRequest();
    xhr.open("GET", "http://localhost:8000/WKApiRest/candidatosEstados", true);

    xhr.addEventListener("load", function(){

            let response = xhr.responseText;

            let candidatos = JSON.parse(response);

            candidatos.forEach(function(itens){
				
				montaOl(itens);
});

    });

    xhr.send();
}

function montaOl(itens){
	
	let olCandidatosEstados = document.querySelector("#olCandidatosEstados");

    let candidatosEstadosOL = document.createElement("li");
    candidatosEstadosOL.classList.add("list-group-item");
    candidatosEstadosOL.textContent = itens;

    olCandidatosEstados.appendChild(candidatosEstadosOL);
}




