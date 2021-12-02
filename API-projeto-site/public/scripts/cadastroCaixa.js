function cadastrar() {
    var formulario = new URLSearchParams(new FormData(form_cadastro));
    fetch("/agencias/cadastrarCaixa", {
        method: "POST",
        body: formulario
    }).then(function (response) {

        if (response.ok) {
            success();
            reload();

        } else {

            console.log('Erro ao cadastro!');
            response.text().then(function (resposta) {
                alert('Erro ao cadastrar caixa!!')
                reload();
            });
        }
    });

    return false;
}


function abrirModal1(){
    $('.close').click(function (event) {
    $('#myModal').fadeOut();
    event.preventDefault();
});
$(document).ready(function () {
    $('#myModal').modal('show');
})

$('#myModal').on('shown.bs.modal', function () {
    localStorage.setItem("modal", false);
});
}

   
function cadastrarCaixa() {
    console.log("entrei!")
    //aguardar();
    // var formulario = new URLSearchParams(new FormData());
    var formulario = new URLSearchParams(new FormData(form_cadastrar));
    // var status = 'ativo'
    // const idAgencia = sessionStorage.getItem('idAgencia');
    fetch(`/caixas/cadastrarCaixas/`, {
        method: "POST",
        body: formulario
    }).then(function (response) {

        if (response.ok) {
            alert("Cadastro realizado com sucesso!");
            window.location.href = 'cadastroCaixa.html';

        } else {

            console.log('Erro de cadastro!');
            response.text().then(function (resposta) {
                // div_erro.innerHTML = resposta;
            });
        }
    });

    return false;
}

var maquinas = [];

function obterCaixas(){

    console.log("executou obter maquinas")

    const idAgencia = sessionStorage.getItem('idAgencia');

fetch(`/caixas/${idAgencia}`).then(function (response) {
        console.log('entrou na rota')

        if (response.ok) {
            response.json().then(function (resposta) {
                console.log(`Maquinas recebidos: ${JSON.stringify(resposta)}`)

                for (i = 0; i < resposta.length; i++){
                    if (maquinas.length == 0) {
                        var novaMaquina = [];
                        novaMaquina.push(resposta[i].idMaquina, resposta[i].codigoCaixa, resposta[i].sistemaOperacional, resposta[i].totalRam, resposta[i].totalDisco, resposta[i].processador, resposta[i].status);
                        maquinas.push(novaMaquina);
                    } else {
                        var contador = 0;
                        for (j = 0; j < maquinas.length; j++) {
                            if (resposta[i].idMaquina, resposta[i].codigoCaixa, resposta[i].sistemaOperacional, resposta[i].totalRam, resposta[i].totalDisco, resposta[i].processador, resposta[i].status == maquinas[j][0]) {
                                contador++;
                            }
                        }
                        if (contador == 0) {
                            var novaMaquina = [];
                            novaMaquina.push(resposta[i].idMaquina, resposta[i].codigoCaixa, resposta[i].sistemaOperacional, resposta[i].totalRam, resposta[i].totalDisco, resposta[i].processador, resposta[i].status);
                            maquinas.push(novaMaquina);
                        }
                    }
                }
                console.log(maquinas);


                let tbody = document.getElementById('tbody');

                for (let i = 0; i < this.maquinas.length; i++) {


                    let tr = tbody.insertRow();

                    let td_id = tr.insertCell();
                    let td_codcaixa = tr.insertCell();
                    let td_so = tr.insertCell();
                    let td_ram = tr.insertCell();
                    let td_disco = tr.insertCell();
                    let td_proc = tr.insertCell();
                    let td_status = tr.insertCell();
                    let td_acoes = tr.insertCell();

                    td_id.innerText = this.maquinas[i][0];
                    td_codcaixa.innerText = this.maquinas[i][1];
                    td_so.innerText = this.maquinas[i][2];
                    td_ram.innerText = this.maquinas[i][3];
                    td_disco.innerText = this.maquinas[i][4];
                    td_proc.innerText = this.maquinas[i][5];
                    td_status.innerText = this.maquinas[i][6];

                    var status = this.maquinas[i][6];

                    let imgEdit = document.createElement('img');
                    imgEdit.src = '../assets/img/imgsCrud/update.png';
                    imgEdit.setAttribute("onClick", "editar(" + JSON.stringify(this.maquinas[i]) + ")");
                    imgEdit.setAttribute("id","idEdit");

                    let imgDisable = document.createElement('img');
                    imgDisable.src = '../assets/img/imgsCrud/desativar.png';
                    imgDisable.setAttribute("onClick", "desativar(" + this.maquinas[i][0] + ")");
                    imgDisable.setAttribute("id","idRemove");

                    let imgEnable = document.createElement('img');
                    imgEnable.src = '../assets/img/imgsCrud/enable.png';
                    imgEnable.setAttribute("onClick", "ativar(" + this.maquinas[i][0] + ")");
                    imgEnable.setAttribute("id","idRemove");

                    let imgRemove = document.createElement('img');
                    imgRemove.src = '';
                    imgRemove.setAttribute("onClick", "deletar(" + this.maquinas[i][0] + ")");
                    imgRemove.setAttribute("id","idRemove");
                    // let el = document.getElementById('idRemove');
                    // // alterando uma propriedade
                    // el.style.width = '10px'

                    td_acoes.appendChild(imgEdit);
                    
                    if(this.maquinas[i][6] == "ativo"){
                        td_acoes.appendChild(imgDisable);
                    }else if(this.maquinas[i][6] == "inativo"){
                        td_acoes.appendChild(imgEnable);
                    }

                    td_acoes.appendChild(imgRemove);

                    
                    

               }

            });
        } else {
            console.error('Nenhum dado encontrado ou erro na API');
        }
    })
        .catch(function (error) {
            console.error(`Erro na obtenção dos dados p/ alertas: ${error.message}`);
        });

}

function desativar(id){

    for (let i = 0; i < maquinas.length; i++) {
        if (maquinas[i][0] == id) {
            var nome = maquinas[i][1];
            break;
        }
    }

    if (confirm(`Deseja realmente DESATIVAR o caixa de codigo ${nome.toUpperCase()} `)) {
        fetch(`/caixas/desativar/${id}`).then(function (response) {
            console.log('entrou na rota')

            if (response.ok) {
                response.json().then(function (resposta) {
                    console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);

                }
                )
            } else { console.log("não recebeu os dados") }
        }
        )


        alert(` Maquina codigo : ${nome.toUpperCase()} deletado com sucesso !`);


        var total = maquinas.length
        for (let i = 0; i < total; i++) {
            maquinas.pop();
        }


        var tabela = document.getElementById("tbody");
        while (tabela.firstChild) {
            tabela.removeChild(tabela.firstChild);
        }

        console.log(maquinas);
        obterCaixas();

    }
}

var update_id = '';

function deletar(id){
    for (let i = 0; i < maquinas.length; i++) {
        if (maquinas[i][0] == id) {
            var nome = maquinas[i][1];
            break;
        }
    }

    if (confirm(`Deseja realme DELETAR o caixa de codigo ${nome.toUpperCase()}. ISSO REMOVERÁ TODOS OS REGISTROS DESTE CAIXA `)) {
        fetch(`/caixas/deletar/${id}`).then(function (response) {
            console.log('entrou na rota')

            if (response.ok) {
                response.json().then(function (resposta) {
                    console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);

                }
                )
            } else { console.log("não recebeu os dados") }
        }
        )


        alert(` Maquina codigo : ${nome.toUpperCase()} deletado com sucesso !`);


        var total = maquinas.length
        for (let i = 0; i < total; i++) {
            maquinas.pop();
        }


        var tabela = document.getElementById("tbody");
        while (tabela.firstChild) {
            tabela.removeChild(tabela.firstChild);
        }

        console.log(maquinas);
        obterCaixas();

    }
}
function editar(dados){
if (confirm(`Deseja EDITAR os dados do caixa de codigo: ${dados[1]} `)) {

    // modal.style.display = 'block';

    // document.getElementById('id').value = dados[0];
    document.getElementById('up_codcaixa').value = dados[1];
    document.getElementById('up_so').value = dados[2];
    document.getElementById('up_ram').value = dados[4];
    document.getElementById('up_proc').value = dados[3];
    document.getElementById('up_disco').value = dados[5];

    update_id = parseInt(dados[0]);
    console.log(`pegando id = ${update_id}`)

    }
    
    abrirModal();
    
}

function abrirModal(){
    $('.close').click(function (event) {
    $('#myModal2').fadeOut();
    event.preventDefault();
});
$(document).ready(function () {
    $('#myModal2').modal('show');
})

$('#myModal2').on('shown.bs.modal', function () {
    localStorage.setItem("modal", false);
});
}

// var update_id = '';

function atualizarCaixa() {

    // const idAgencia = sessionStorage.getItem('idAgencia');
    var formulario = new URLSearchParams(new FormData(form_atualizar));
    fetch(`/caixas/atualizar/${update_id}`, {
        method: "POST",
        body: formulario
    }).then(function (response) {

        if (response.ok) {
            alert("Atualização realizada com sucesso!");
            // window.location.href = 'cadastroCaixa.html';

        } else {

            console.log('Erro de atualização!');
            response.text().then(function (resposta) {
                // div_erro.innerHTML = resposta;
            });
        }
        var total = maquinas.length
        for (let i = 0; i < total; i++) {
            maquinas.pop();
        }


        var tabela = document.getElementById("tbody");
        while (tabela.firstChild) {
            tabela.removeChild(tabela.firstChild);
        }

        console.log(maquinas);
        obterCaixas();

        window.location.href = 'cadastroCaixa.html';

    });

    return false;
}
