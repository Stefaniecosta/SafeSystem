<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Alterar Senha</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" />
    <link rel="stylesheet" href="../styles/esqueciSenha.css">
</head>

<body>
    <section>
        <section class="cover_side">
        </section>

        <section class="form_side">
            <div class="container">
                <div class="brand">
                    <img style="cursor: pointer;" onclick="window.location= 'homepage.php'" src="../assets/img/logoss.svg" alt="Logo da Safe System">
                    <h1 class="titulos"> Safe System </h1>
                </div>
                <div id="message">Atualize sua senha</div>

                <div class="inputs_group">
                    <input type="password" id="password" placeholder="Nova senha">
                    <input type="password" id="confirm_password" placeholder="Confirmar nova senha">
                </div>

                <button class="btSave" id="btSave" onclick="save()">Salvar</button>
                <div class="loading_screen">
                    <p id="loading_message"><span>A</span>guarde um momento</p>
                    <img id="loading_gif"
                        src="https://1.bp.blogspot.com/-uZmhTwOaRc4/XnlNu9_rvYI/AAAAAAAAXNk/8LtRh85SMNA3awhyJaOu6IiTFhCLbQ9WgCLcBGAsYHQ/s640/Dinheiro-1.gif">
                </div>
            </div>
        </section>
    </section>

</body>

</html>
<script src="../scripts/esqueciSenha.js"></script>