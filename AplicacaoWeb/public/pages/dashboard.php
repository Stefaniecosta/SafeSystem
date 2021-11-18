<?php
require '../Components.php';
require '../ConexaoBD.php';






?>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../styles/dashboard.css">
    <script src="https://cdn.zingchart.com/zingchart.min.js"></script>
    <title>Área do Cliente</title>
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
            <div class="item"  onclick="chamarGraf1()">
                <img src="../assets/img/caixaIcon.png" alt="">
                <button >
                    <span style="cursor: pointer;">CAIXA <strong>01</strong></span>
                </button>
            </div>

            <hr>

            <!-- CAIXA 2 -->
            <div class="item" onclick="chamarGraf2()">
                <img src="../assets/img/caixaIcon.png" alt="">
                <button >
                    <span style="cursor: pointer;">CAIXA <strong>02</strong></span>
                </button>
            </div>

            <hr>

            <!-- CAIXA 3 -->
            <div class="item" onclick="chamarGraf3()" id="divCaixa2">
                <img src="../assets/img/caixaIcon.png" alt="">
                <button >
                    <span style="cursor: pointer;">CAIXA <strong>03</strong></span>
                </button>
            </div>

            <hr>

            <!-- CAIXA 4 -->
            <div class="item" onclick="chamarGraf4()">
                <img src="../assets/img/caixaIcon.png" alt="">
                <button >
                    <span style="cursor: pointer;">CAIXA <strong>04</strong></span>
                </button>
            </div>

            <hr>

            <!-- CAIXA 5 -->
            <div class="item" onclick="chamarGraf5()">
                <img src="../assets/img/caixaIcon.png" alt="">
                <button >
                    <span style="cursor: pointer;">CAIXA <strong>05</strong></span>
                </button>
            </div>

            <hr>

            <!-- CAIXA 6 -->
            <div class="item" onclick="chamarGraf6()">
                <img src="../assets/img/caixaIcon.png" alt="">
                <button>
                    <span style="cursor: pointer;">CAIXA <strong>06</strong></span>
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

    <!-- Header com o título e a foto de perfil com dropdown de opções-->

    <div id="informations">
        <header class="header">
            <strong class="item_color">Dashboard</strong>

            <div class="dropdown">
                <button class="dropbtn">
                    <img id="user" src="../assets/img/user.png" alt="">
                    <div class="dropdown-content">
                        <a href="../pages/dashPerfil.php">Perfil</a>
                        <a href="/Site/index.php">Homepage</a>
                        <a href="../pages/visaogeral.php">Visão Geral</a>
                    </div>
                </button>
            </div>
            <button id="repError">REPORTAR ERRO</button>
        </header>


        <div id="infoBoxes">
            <div id="identCaixas">
                <div id="textCaixas">
                    <b>Caixa: <span>01</span></b>
                </div>
            </div>
            <div id="box1ram" class="box">
                <div class="boxContent">
                    <strong>
                        <img id="iconesBox" src="../assets/img/dashboard-img/ram-icone.png" alt=""> RAM
                    </strong>
                    <div id="chartRAM1" class="chartRAM" style="display: block;"></div>
                    <div id="chartRAM2" class="chartRAM" style="display: none;"></div>
                    <div id="chartRAM3" class="chartRAM" style="display: none;"></div>
                    <div id="chartRAM4" class="chartRAM" style="display: none;"></div>
                    <div id="chartRAM5" class="chartRAM" style="display: none;"></div>
                    <div id="chartRAM6" class="chartRAM" style="display: none;"></div>
                    <div class="esconderRam"></div>
                </div>
            </div>

            <div id="box2disco" class="box">
                <div class="boxContent">
                    <strong>
                        <img id="iconesBox" src="../assets/img/dashboard-img/disco-icone.png" alt="">
                        Disco
                    </strong>
                    <div class="BoxTextdisco">
                        <div id="textoDisco">
                            
                            <a href="">500 GB</a>
                            <a href="" style="font-size: 17px; color: white;">Armazenamento total</a>

                        </div>
                    </div>
                    <div id="chartdivDisco1" class="chartDisco" style="display: block;"></div>
                    <div id="chartdivDisco2" class="chartDisco" style="display: none;"></div>
                    <div id="chartdivDisco3" class="chartDisco" style="display: none;"></div>
                    <div id="chartdivDisco4" class="chartDisco" style="display: none;"></div>
                    <div id="chartdivDisco5" class="chartDisco" style="display: none;"></div>
                    <div id="chartdivDisco6" class="chartDisco" style="display: none;"></div>
                    <div class="esconderDisco"></div>

                </div>
            </div>

            <div id="box3Conexao" class="box">
                <div class="boxContent">
                    <strong>
                        <img id="iconesBox" src="../assets/img/dashboard-img/conexao-icone.png" alt="">

                        Dispositivos conectados
                    </strong>
                    <div id="TextdispConect" class="text-box3Conexao">
                        <a>5 Conectados</a>
                        <img class="iconeBox3Conex" src="../assets/img/dashboard-img/IconedispoEstranhoDash.svg" alt="">
                    </div>
                    <div id="TextdispEstranhos" class="text-box3Conexao text-redBox3">
                        <a>3 Estranhos</a>
                        <img class="iconeBox3Conex" src="../assets/img/dashboard-img/IconeConectDash.svg" alt="">

                    </div>
                </div>
            </div>

            <div id="box5Visaogeral" class="box2">
                <div class="boxContent">
                    <div> </div>
                    <img id="atmVisaogeral" src="../assets/img/dashboard-img/seta-caixa.png" alt="">
                </div>
            </div>

            <div id="box6CPU" class="box">
                <div class="boxContent">
                    <strong>
                        <img id="iconesBox" src="../assets/img/dashboard-img/cpu-icone.png" alt="">
                        CPU
                    </strong>
                    <div class="labelCPU">
                        <a href="">Media do uso da cpu por data: </a>
                    </div>
                    <div class="boxDivsgraf">
                        <div class="divGraficCPU">
                            <div id="chartCPU1" class="chart-cpu" style="display: block;"> </div>
                            <div id="chartCPU2" class="chart-cpu" style="display: none;"></div>
                            <div id="chartCPU3" class="chart-cpu" style="display: none;"></div>
                            <div id="chartCPU4" class="chart-cpu" style="display: none;"> </div>
                            <div id="chartCPU5" class="chart-cpu" style="display: none;"> </div>
                            <div id="chartCPU6" class="chart-cpu" style="display: none;"></div>
                            <div class="esconderCPU"></div>
                        </div>
                        <div class="textInfosCPU">
                            <div class="textCPU">
                                <div class="tittleinfosCPU">
                                    <a>Utilização atual da cpu:</a>
                                </div>
                                <div id="mudarInfo1">
                                    <a>37%</a>
                                </div>
                            </div>
                            <div class="textCPU">
                                <div class="tittleinfosCPU">
                                    <a>Velocidade:</a>
                                </div>
                                <a>2.66 GHz</a>
                            </div>
                            <div class="textCPU">
                                <div class="tittleinfosCPU">
                                    <a>Threads:</a>
                                </div>
                                <div id="mudarInfo3">
                                    <a>1200</a>
                                </div>
                            </div>
                            <div class="textCPU">
                                <div class="tittleinfosCPU">
                                    <a>Processador:</a>
                                </div>
                                <div id="mudarInfo4">
                                    <a>Ryzen i5 2500</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <footer></footer>
</body>

<!-- Resources -->
<script src="https://cdn.amcharts.com/lib/4/core.js"></script>
<script src="https://cdn.amcharts.com/lib/4/charts.js"></script>
<script src="https://cdn.amcharts.com/lib/4/themes/dark.js"></script>
<script src="https://cdn.amcharts.com/lib/4/themes/animated.js">
</script>
<script src="../scripts/graficosDashboard/chamarGraficos.php"></script>
<script src="../scripts/graficosDashboard/graficosCpu.php"></script>
<script src="../scripts/graficosDashboard/graficosDisco.php"></script>
<script src="../scripts/graficosDashboard/graficosRam.php"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</html>
​