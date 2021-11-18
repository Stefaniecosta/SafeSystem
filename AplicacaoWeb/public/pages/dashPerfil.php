<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- ===== BOX ICONS ===== -->
        <link href='https://cdn.jsdelivr.net/npm/boxicons@2.0.5/css/boxicons.min.css' rel='stylesheet'>

        <!-- ===== CSS ===== -->
        <link rel="stylesheet" href="../styles/dashperfil.css">

        <title>Página de Perfil</title>
    </head>

    <body id="body-pd">
        <header class="header" id="header">
            <div class="header__toggle">
                <i class='bx bx-menu' id="header-toggle"></i>
            </div>

        <div id="header-profile-button">
            <div class="dropdown">
                <button class="dropbtn">
                    <img id="user" src="../assets/img/user.png" alt="">
                    <div class="dropdown-content">
                        <a href="../pages/dashPerfil.php">Perfil</a>
                        <a href="../pages/homepage.php">Homepage</a>
                        <a href="../pages/visaogeral.php">Visão Geral</a>
                    </div>
                </button>
            </div>
            
        </div>
        <button id="repError">REPORTAR ERRO</button>

        </header>

        <!-- Código do menu hamburguer -->
        <div class="l-navbar" id="nav-bar">
            <nav class="nav">
                <div>
                    <a href="homepage.php" class="nav__logo">
                        <i class='bx bx-layer nav__logo-icon'></i>
                        <span class="nav__logo-name">Safe System</span>
                    </a>

                    <div class="nav__list">
                        <a href="/pages/dashboard.php" class="nav__link active">
                            <i class='bx bx-bar-chart-alt-2 nav__icon' ></i>
                            <span class="nav__name">Dashboard</span>
                        </a>

                        <a href="/pages/dashPerfil.php" class="nav__link">
                            <i class='bx bx-user nav__icon' ></i>
                            <span class="nav__name">Meu perfil</span>
                        </a>

                        <a href="/pages/visaogeral.php" class="nav__link">
                            <i class='bx bxs-error-alt'></i>
                            <span class="nav__name">Visão geral</span>
                        </a>

                        <a href="/pages/esqueciSenha.php" class="nav__link">
                            <i class='bx bxs-lock-alt'></i>
                            <span class="nav__name">Mudar senha</span>
                        </a>

                    </div>
                </div>

                <a href="homepage.php" class="nav__link">
                    <i class='bx bx-log-out nav__icon' ></i>
                    <span class="nav__name">Voltar para home</span>
                </a>
            </nav>
        </div>
    <!-- Fim do hamburguer -->


        <!-- Começa aqui o código do conteúdo-->
       
    <!-------------------------- Container do perfil ---------------------------------->

    <div class="container-perfil">
       
        <div class="caixa-card">
            <h1>Perfil</h1>
            <article>Se preciso, altere suas informações a hora que quiser.</article>

            <h2>Foto do perfil</h2>
            <img class="section-img profile" src="../assets/img/Ellipse 55.svg" />
            <p>O administrador escolhido é o único responsável pelo perfil da empresa.</p>
            <a href="#" class="info-link">Leia mais sobre nossa politica...</a>
        </div>


        <!-- Container informacoes do cliente -->
        <div class="caixa-input">
            <h2 id="edit-profile">Editar perfil 
                <i class='bx bxs-pencil'> </i>
            </h2>
            

            <form id="user-informations">
                <p>Nome do usuario responsável:</p>
                <input id="ipt_nome" class="inp" type="text" class="input" name="nome" placeholder="John dee">
                <p>Email de acesso:</p>
                <input id="ipt_email" class="inp" type="text" class="input" name="email"
                    placeholder="johndee@safesystem.com">
                <p>Agencia cadastrada:</p>
                <input id="ipt_foto" name="fotoPerfil" class="inp" type="text" class="input" placeholder="0222">
                <input style="display: none;" id="ipt_idUsuario" name="idUsuario" class="inp" type="text"
                    class="input">
            </form>

            <button id="btn_entrar" class="buttonForm-login" type="submit">Confirmar</button>
        </div>

    </div>
   

        <!-- Script que faz o hamburguer abrir e fechar -->
        <script src="../scripts/hambPerfil.js"></script>

         <!-- Script que deixa o card do perfil animado -->
        <script type="text/javascript" src="/scripts/vanilla-tilt.js"></script>

        <script>
            VanillaTilt.init(document.querySelectorAll(".caixa-card"), {
            max: 25,
            speed: 400
        }); 
        </script>
    </body>
</html>