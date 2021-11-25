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