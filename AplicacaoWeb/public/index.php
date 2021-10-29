<?php
require "ConexaoBD.php";


// Função que diz para o PHP trabalhar com sessões.
session_start();


// Função de login
if ($_SERVER['PATH_INFO'] == '/autenticarUsuario'){
    ConexaoBD::autenticar();
}

// Destruir sessão do usuário
if ($_SERVER['PATH_INFO'] == '/logout'){
    session_destroy();
    header('Location:http://localhost:8000/pages/homepage.php');
    die();
}

// Caso o usuário esteja entrando pela primeira vez.
if (is_null($_SESSION['logado']) == true) {
    header('Location:http://localhost:8000/pages/homepage.php');
    die();
}

// Caso o usuário esteja logado.
if ($_SESSION['logado'] === true) {
    header('Location:http://localhost:8000/pages/visaogeral.php');
    die();
}

?>
