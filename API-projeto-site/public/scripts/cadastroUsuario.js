function cadastrar() {
    var formulario = new URLSearchParams(new FormData(form_cadastro));
    fetch("/agencias/cadastrarUsuario", {
        method: "POST",
        body: formulario
    }).then(function (response) {

        if (response.ok) {
            alert('cadastro realizado com sucesso!');
            window.location.href = 'login.html';

        } else {

            console.log('Erro de cadastro!');
            response.text().then(function (resposta) {
                div_erro.innerHTML = resposta;
                window.location.href = 'usuarioCadastro.html';
                alert("deu barba");
            });
        }
    });

    return false;
}