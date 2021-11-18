<?php
require '../ConexaoBD.php';




?>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
    <link rel="stylesheet" href="../styles/login.css">
    <script src="../scripts/validacaoCadastro.js"></script>

</head>

<body>
    <!-- <header class="cabecalho">

    </header> -->
    <div id="containerGeral_login">
        <div id="subcontainer01_login">
            
            <!-- <img src="../assets/img/image 15.svg" alt="" class="imagemPrincipal_login"> -->
            <a href="homepage.php">
                <img src="../assets/img/logo-contato.png" id="logo" alt="">
            </a>

        </div>
        <div id="subcontainer02_login">

            <img style="display: none;" src="assets/img/logo.png" id="logo2" alt="">

            <div id="div_formulario">

                
                <form id="form_login" method="post" action="/autenticarUsuario" ">

                    <h1 class="titulos">Login</h1>

                    <input type="email" placeholder="Email" maxlength="30" name="email"/>

                    <input type="password" placeholder="Senha*" name="senha"/>

                    <p id="Click_esqueceu"><a href="esqueciSenha.php">Esqueceu a senha?</a></p>

                    <button class="buttonForm-login" >Confirmar</button>

                </form>
                <div class="extra">
                    <div id="div_erro" class="msg_erro">
                    </div>

                    <img src="https://1.bp.blogspot.com/-uZmhTwOaRc4/XnlNu9_rvYI/AAAAAAAAXNk/8LtRh85SMNA3awhyJaOu6IiTFhCLbQ9WgCLcBGAsYHQ/s640/Dinheiro-1.gif" id="img_aguarde"  > <!--style="display: none;"-->
                    
                </div>
        </div>


    </div>
</body>

</html>



<script>

    function entrar() {
        aguardar();
        var formulario = new URLSearchParams(new FormData(form_login));
        fetch("/usuarios/autenticar", {
            method: "POST",
            body: formulario
        }).then(resposta => {

            if (resposta.ok) {

                resposta.json().then(json => {

                    sessionStorage.login_usuario_meuapp = json.login;
                    sessionStorage.nome_usuario_meuapp = json.nome;

                    window.location.href = 'visaogeral.php';
                });

            } else {

                console.log('Erro de login!');

                resposta.text().then(texto => {
                    console.error(texto);
                    finalizar_aguardar(texto);
                });
            }
        });

        return false;
    }

    function aguardar() {
        btn_entrar.disabled = true;
        img_aguarde.style.visibility = 'visible';
        div_erro.style.visibility = 'hidden';
    }

    function finalizar_aguardar(resposta) {
        btn_entrar.disabled = false;
        img_aguarde.style.visibility = 'hidden';
        div_erro.style.visibility = 'visible';
        div_erro.innerHTML = resposta;
    }

</script>
