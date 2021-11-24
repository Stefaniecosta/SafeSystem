function cadastrar() {
    var formulario = new URLSearchParams(new FormData(form_cadastro));
    fetch("/agencias/cadastrar", {
        method: "POST",
        body: formulario
    }).then(function (response) {

        if (response.ok) {
            alert('cadastro realizado com sucesso!');
            window.location.href = '#login';


        } else {

            console.log('Erro de cadastro!');
            response.text().then(function (resposta) {
                div_erro.innerHTML = resposta;
                window.location.href = '../pages/usuarioCadastro.html';
                alert("deu barba");
            });
        }
    });

    return false;
}