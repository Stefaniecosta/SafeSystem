<!DOCTYPE html>
<html lang="pt">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../styles/visaogeral.css">
    <script src="https://kit.fontawesome.com/6f2d70ffaf.js" crossorigin="anonymous"></script>
    <title>Visão Geral</title>
</head>

<body>

    <div id="content">
        <img id="logoName" src="../assets/img/logoss.svg" alt="">

        <div id="options">
            <div class="item">
                <strong class="font_tamanho">
                    Caixas
                </strong>
            </div>

            <hr>

            <div class="item">
                <div>
                    <img src="../assets/img/visaoGeralImg.png" alt="">
                </div>
                <a href="visaogeral.php"> VISÃO GERAL </a>
            </div>

            <hr>

            <!-- CAIXA 1 -->
            <div class="item">
                <img src="../assets/img/caixaIcon.png" alt="">
                <a href="../pages/dashboard.php">
                    <button onclick="chamarGraf1()">
                       <a href="dashboard.php"> <span>CAIXA <strong>01</strong></span> </a> 
                    </button>
                </a>
            </div>

            <hr>

            <!-- CAIXA 2 -->
            <div class="item">
                <img src="../assets/img/caixaIcon.png" alt="">
                <button onclick="chamarGraf2()">
                    <span>CAIXA <strong>02</strong></span>
                </button>
            </div>

            <hr>

            <!-- CAIXA 3 -->
            <div class="item" id="divCaixa2">
                <img src="../assets/img/caixaIcon.png" alt="">
                <button onclick="chamarGraf3()">
                    <span>CAIXA <strong>03</strong></span>
                </button>
            </div>

            <hr>

            <!-- CAIXA 4 -->
            <div class="item">
                <img src="../assets/img/caixaIcon.png" alt="">
                <button onclick="chamarGraf4()">
                    <span>CAIXA <strong>04</strong></span>
                </button>
            </div>

            <hr>

            <!-- CAIXA 5 -->
            <div class="item">
                <img src="../assets/img/caixaIcon.png" alt="">
                <button onclick="chamarGraf5()">
                    <span>CAIXA <strong>05</strong></span>
                </button>
            </div>

            <hr>

            <!-- CAIXA 6 -->
            <div class="item">
                <img src="../assets/img/caixaIcon.png" alt="">
                <button onclick="chamarGraf6()">
                    <span>CAIXA <strong>06</strong></span>
                </button>
            </div>

            <hr>

            <div class="item item_color">
                <span>
                    Agência
                </span>
                <br>
                <strong>
                    0222
                </strong>
            </div>
            <hr>
        </div>

        <!-- Ícone de SAIR da dashboard -->
        <div id="logout">
            <a href="http://localhost:8000/logout">
                <img id="logoutIcon" src="../assets/img/logoutIcon.png" alt="Ícone para sair da Dashboard">
            </a>
        </div>
    </div>

    <div id="informations">
        <header class="header">
            <strong class="item_color">Dashboard</strong>

            <div class="dropdown">
                <button class="dropbtn">
                    <img id="user" src="../assets/img/user.png" alt="">
                    <div class="dropdown-content">
                        <a href="../pages/dashPerfil.php">Perfil</a>
                        <a href="../pages/dashboard.php">Homepage</a>
                        <a href="../pages/visaogeral.php">Visão Geral</a>
                    </div>
                </button>
            </div>
            <button id="repError">REPORTAR ERRO</button>
        </header>
        
        <div class="container-boxes">
            <div class="aux-container-boxes">
                <div id="caixa" class="box">
                    <div class="boxContent">
                        <div class="info_caixas">
                            <div class="bottom">

                                <strong>
                                    <img class="item-img" src="../assets/img/caixaIcon.png" alt="">
                                    Caixa 1
                                </strong>
                            </div>
                            <br>
                            <div class="icone">
                                Status:
                                <i class="fas fa-skull"></i> <b class="critico"> CRÍTICO</b>
                            </div>
                            <p style="color: rgba(255, 126, 120, 0.8);">DISPOSITIVO <br> ESTRANHO</p>
                        </div>
                    </div>
                </div>
                <div id="caixa" class="box">
                    <div class="boxContent">
                        <div class="info_caixas">
                            <div class="bottom">
                                <img class="item-img" src="../assets/img/caixaIcon.png" alt="">
                                <strong>
                                    Caixa 2
                                </strong>
                            </div>
                            <br>
                            <div id="iconeTwo" class="icone">
                                Status:
                                <i class="fas fa-exclamation-triangle"></i> <b class="alerta"> ALERTA</b>
                            </div>
                            <p style="color: rgba(244, 219, 87, 0.8);"> MUITOS COMPONENTES <br> LENTOS</p>
                        </div>
                    </div>
                </div>
                <div id="caixa" class="box">
                    <div class="boxContent">
                        <div class="info_caixas">
                            <div class="bottom">
                                <img class="item-img" src="../assets/img/caixaIcon.png" alt="">
                                <strong>
                                    Caixa 3
                                </strong>
                            </div>
                            <br>
                            <div class="icone">
                                Status: <b class="ok"> OK</b>
                            </div>
                            <p style="color: rgba(107, 226, 190, 0.8);">ESTÁ TUDO CERTO</p>
                        </div>
                    </div>
                </div>
                <div id="caixa" class="box">
                    <div class="boxContent">
                        <div class="info_caixas">
                            <div class="bottom">
                                <img class="item-img" src="../assets/img/caixaIcon.png" alt="">
                                <strong>
                                    Caixa 4
                                </strong>
                            </div>
                            <br>
                            <div class="icone">
                                Status:
                                <i class="fas fa-skull"></i> <b class="critico"> CRÍTICO</b>
                                <p style="color: rgba(255, 126, 120, 0.8);">DISPOSITIVO <br> ESTRANHO</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="caixa" class="box">
                    <div class="boxContent">
                        <div class="info_caixas">
                            <div class="bottom">
                                <img class="item-img" src="../assets/img/caixaIcon.png" alt="">
                                <strong>
                                    Caixa 5
                                </strong>
                            </div>
                            <br>
                            <div id="iconeTwo" class="icone">
                                Status:
                                <i class="fas fa-exclamation-triangle"></i> <b class="alerta"> ALERTA</b>
                            </div>
                            <p style="color: rgba(244, 219, 87, 0.8);"> MUITOS COMPONENTES <br> LENTOS</p>
                        </div>
                    </div>
                </div>
                <div id="caixa" class="box">
                    <div class="boxContent">
                        <div class="info_caixas">
                            <div class="bottom">
                                <img class="item-img" src="../assets/img/caixaIcon.png" alt="">
                                <strong>
                                    Caixa 6
                                </strong>
                            </div>
                            <br>
                            <div class="icone">
                                Status: <b class="ok"> OK</b>
                            </div>
                            <p style="color: rgba(107, 226, 190, 0.8);">ESTÁ TUDO CERTO</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <footer></footer>

</body>

</html>