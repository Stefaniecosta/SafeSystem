<?php



class ConexaoBD
    {


        public static function criarConexao() : PDO
        {
            return $pdo = new PDO(
                "sqlsrv:Server=safesystem.database.windows.net;Database=safesystem",
                "safe",
                "Senh@forte06"
            );
        }

        public static function obterDadosTabelaRegistrosMaquina() : array
        {
            $statement = self::criarConexao()->query(
                "SELECT TOP 1
                            totalRam, usoRam, totalDisco, dispositivoEstranho, nomeCpu, usoCpu
                            FROM
                            registroMaquina
                            order by
                            idRegistro
                            desc
            ");

            $result = $statement->fetch(SQLSRV_FETCH_ASSOC);

            return $result;
        }

        public static function autenticar() : void
        {
            $email = $_POST['email'];
            $senha = $_POST['senha'];

            if (!is_null($email) || !is_null($senha)){
                $conexao = ConexaoBD::criarConexao();

                $statement = $conexao->query(
                    "SELECT email, senha
            FROM usuario
            WHERE email = '$email'
            AND senha = '$senha'"
                );

                $result = $statement->fetchAll(SQLSRV_FETCH_ASSOC);
                var_dump($result);

                if (!$result == false) {
                    header('Location: http://localhost:8000/pages/visaogeral.php');
                    $_SESSION['logado'] = true;
                    die();
                }

            }

            header('Location: http://localhost:8000/pages/login.php');
            echo "<script>Alert('Email ou senha inválidos!')</script>";
            die();

        }
    }
?>