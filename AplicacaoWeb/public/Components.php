<?php

class Components
{
    private float $totalRam;
    private float $usoRam;
    private float $totalDisco;
    private int $dispositivoEstranho;
    private string $nomeCpu;
    private float $usoCpu;

    //GETTERS AND SETTERS
    public function getTotalRam(): string
    {
        return $this->totalRam;
    }


    public function setTotalRam(string $totalRam): void
    {
        $this->totalRam = $totalRam;
    }

    public function getUsoRam(): string
    {
        return $this->usoRam;
    }

    public function setUsoRam(string $usoRam): void
    {
        $this->usoRam = $usoRam;
    }


    public function getTotalDisco(): float
    {
        return $this->totalDisco;
    }

    public function setTotalDisco(float $totalDisco): void
    {
        $this->totalDisco = $totalDisco;
    }


    public function getDispositivoEstranho(): int
    {
        return $this->dispositivoEstranho;
    }


    public function setDispositivoEstranho(int $dispositivoEstranho): void
    {
        $this->dispositivoEstranho = $dispositivoEstranho;
    }

    public function getNomeCpu(): string
    {
        return $this->nomeCpu;
    }

    public function setNomeCpu(string $nomeCpu): void
    {
        $this->nomeCpu = $nomeCpu;
    }

    public function getUsoCpu(): float
    {
        return $this->usoCpu;
    }

    public function setUsoCpu(float $usoCpu): void
    {
        $this->usoCpu = $usoCpu;
    }
    // FIM GETTERS AND SETTERS


    // FUNCTION QUE BUSCA OS DADOS NO BANCO E INSERE OS VALORES NOS ATRIBUTOS USANDO OS SETTERS
    public function obterEAtualizarDadosNaClasse($milliseconds = 5000)
    {
        $seconds=(int)$milliseconds/1000;
        while(true)
        {
            $dados = ConexaoBD::obterDadosTabelaRegistrosMaquina();

            self::setDispositivoEstranho($dados['dispositivoEstranho']);
            self::setNomeCpu($dados['nomeCpu']);
            self::setTotalDisco($dados['totalDisco']);
            self::setTotalRam($dados['totalRam']);
            self::setUsoCpu($dados['usoCpu']);
            self::setUsoRam($dados['usoRam']);

            var_dump($dados);

            sleep($seconds);
        }
    }



}

