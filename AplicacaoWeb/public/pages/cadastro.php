<?php



?>
<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../styles/cadastro.css">
  <script src="../scripts/validacaoCadastro.js"></script>
  <title>Cadastro</title>
</head>

<body>

  <div class="container-maior-cadastro">

    
    <!----------Container direito--------->
    <div class="container-esquerdo-cadastro">
      
      <div class="formulario-cadastro">
        
        <form action="">
          <h1 class="titulos">Cadastro</h1>
          <div class="social-container">
          </div>
          <input type="text" placeholder="Nome completo*" name="nome" id="idNome" onkeyup="ValidarNome()" />
          <div id="validacao_nome" class="msgErro-cadastro">Insira seu nome completo</div>


          <input type="text" placeholder="CNPJ*" onblur="validarCNPJ(this)" onkeypress="mascaraCnpj()" id="idCnpj"
            maxlength="18" />
          <div id="validacao_CNPJ" class="msgErro-cadastro">CNPJ inválido!</div>


          <input type="email" placeholder="Email*" id="email" onblur="validarEmail()" />
          <div id="div_msg1" class="msgErro-cadastro">Email inválido!</div>

          <input type="text" placeholder="Confirmação do email*" onkeyup="compara()" id="comparaEmail" />
          <div id="validacao_comparaEmail" class="msgErro-cadastro">Os email não confere!</div>


          <input type="text" placeholder="Telefone*" />
          <div id="validacao_telefone" class="msgErro-cadastro">Telefone invãlido!</div>

          <!--Campo check mostrar senhas-->

          <div for="" class="label-cadastro">
            <span class="check-cadastro">Concordo com os termos de uso</span>

            <div class="custom-checkbox">
              <input id="checkbox-1" type="checkbox">
              <label for="checkbox-1"></label>
            </div>

          </div>

          <button class="buttonForm-cadastro" type="submit">Confirme</button>
        </form>
      </div>
    </div>

    <!----------Container esquerdo--------->

    <div class="container-direito-cadastro">
      <div class="img-cadastro">
        <img src="../assets/img/ATMcadastro.png" alt="">
      </div>
        
      </div>
    </div>
  </div>

</body>

</html>
