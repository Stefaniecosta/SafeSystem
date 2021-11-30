let nomeUsuario = sessionStorage.nome;
let emailUsuario = sessionStorage.email;
let idUsuario = sessionStorage.getItem("idUsuario");

function load() {
    ipt_nome.value = nomeUsuario;
    ipt_email.value = emailUsuario;
}

function editar() {
    var formulario = new URLSearchParams(new FormData(form_edt_usuario));
    fetch(`/agencias/editarUsuario/${idUsuario}`, {
        method: "POST",
        body: formulario
    }).then(function (response) {

        if (response.ok) {

            //adiciona os valores degitados em sessionStorage
            var nome = ipt_nome.value;
            var email = ipt_email.value;
            sessionStorage.setItem("nome", nome);
            sessionStorage.setItem("email", email);

            console.log(formulario);
            location.reload();
            alert('Dados alterados com sucesso!');

        } else {

            console.log('Erro na alteração dos dados!');
            response.text().then(function (resposta) {
                div_erro.innerHTML = resposta;
                alert("Erro na alteração dos dados!");
            });
        }
    });

    return false;
}