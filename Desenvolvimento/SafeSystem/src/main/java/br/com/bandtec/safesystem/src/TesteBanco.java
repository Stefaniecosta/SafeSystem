/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.safesystem.src;

import br.com.bandtec.safesystem.src.models.Banco;
import br.com.bandtec.safesystem.src.models.Agencia;
import br.com.bandtec.safesystem.src.models.Usuario;
import br.com.bandtec.safesystem.src.models.Caixa;
import br.com.bandtec.safesystem.src.models.RegistroCaixa;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Bruno
 */
public class TesteBanco {

    public static void main(String[] args) {

        ConexaoBD config = new ConexaoBD();
        JdbcTemplate con = new JdbcTemplate(config.getBancoDeDados());

        con.execute("DROP TABLE IF EXISTS usuario");
        con.execute("DROP TABLE IF EXISTS registroMaquina");
        con.execute("DROP TABLE IF EXISTS maquina");
        con.execute("DROP TABLE IF EXISTS agencia");
        con.execute("DROP TABLE IF EXISTS banco");

        String tableBanco = "CREATE TABLE banco("
                + "idBanco INT PRIMARY KEY AUTO_INCREMENT NOT NULL,"
                + "nomeBanco VARCHAR(40),"
                + "cnpj VARCHAR(20)"
                + ")";

        String tabelaAgencia = "CREATE TABLE agencia ("
                + "idAgencia INT PRIMARY KEY AUTO_INCREMENT NOT NULL,"
                + "nomeAgencia VARCHAR(100),"
                + "localizacaoAgencia VARCHAR(200),"
                + "codigoAgencia VARCHAR(50),"
                + "fkBanco INT,"
                + "senha VARCHAR (45),"
                + "FOREIGN KEY (fkBanco) REFERENCES banco(idBanco)"
                + ")";

        String tabelaUsuario = "CREATE TABLE usuario ("
                + "id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,"
                + "login VARCHAR(255),"
                + "senha VARCHAR(255),"
                + "fkAgencia INT,"
                + "FOREIGN KEY (fkAgencia) REFERENCES agencia(idAgencia))";

        String tabelaCaixa = "CREATE TABLE maquina ("
                + "idMaquina INT PRIMARY KEY AUTO_INCREMENT NOT NULL,"
                + "patrimonio VARCHAR(20),"
                + "fkAgencia int NOT NULL,"
                + "quantDispositivo int,"
                + "sistemaOperacional VARCHAR(40),"
                + "FOREIGN KEY (fkAgencia) REFERENCES agencia(idAgencia))";

        String tabelaRegistros = "CREATE TABLE registroMaquina ("
                + "idRegistro INT PRIMARY KEY AUTO_INCREMENT NOT NULL,"
                + "totalRam float,"
                + "usoRam float,"
                + "totalDisco float,"
                + "usoDisco float,"
                + "dispositivoEstranho bit,"
                + "nomeCPU varchar(100),"
                + "utilizandoCPU int,"
                + "fkMaquina int,"
                + "FOREIGN KEY (fkMaquina) REFERENCES maquina(idMaquina))";

        // Executando o comando de criação de fato.
        con.execute(tableBanco);
        con.execute(tabelaAgencia);
        con.execute(tabelaCaixa);
        con.execute(tabelaUsuario);
        con.execute(tabelaRegistros);

        con.update("INSERT INTO banco VALUES (?,?,?)", 1000, "BandtecBank", "71.572.287/0001-72");
//
        con.update("INSERT INTO agencia VALUES (?, ?, ?, ?, ?, ?)", 100, "Agencia BandtecBank 1", "Av Paulista, 1200", "admin", 1000, "12345678");
        con.update("INSERT INTO agencia VALUES (?, ?, ?, ?, ?, ?)", 101, "Agencia BandtecBank 2", "Rua Augusta, 1220", "admin", 1000, "12345678");

        con.update("INSERT INTO maquina(idMaquina,fkAgencia)  VALUES (?, ?)", 1, 100);
        con.update("INSERT INTO maquina(idMaquina,fkAgencia) VALUES (?, ?)", 2, 101);

        con.update("INSERT INTO usuario VALUES (?, ?, ?, ?)", null, "login", "1234", "100");
        con.update("INSERT INTO usuario VALUES (?, ?, ?, ?)", null, "login", "123", "101");
        con.update("INSERT INTO usuario VALUES (?, ?, ?, ?)", null, "login", "12", "100");
        con.update("INSERT INTO usuario VALUES (?, ?, ?, ?)", null, "login", "1", "101");

        con.update("insert into registroMaquina values (?, ?, ?, ?, ?, ?, ?, ?, ?)", null, 20.0, 20.0, 20.0, 20.0, "aaa", 1, false, 1);

        List<Banco> bancoAdvancedUse = con.query("SELECT * FROM banco WHERE idBanco = 1000", new BeanPropertyRowMapper(Banco.class));
        System.out.println("select banco teste " + bancoAdvancedUse.get(0));

        List<Agencia> agenciaAdvancedUse = con.query("SELECT * FROM  agencia WHERE idAgencia = 100", new BeanPropertyRowMapper(Agencia.class));
        System.out.println("select agencia teste " + agenciaAdvancedUse.get(0));

        List<Usuario> usuarioAdvancedUse = con.query("SELECT * FROM  usuario WHERE login = ? AND senha = ?", new BeanPropertyRowMapper(Usuario.class), "login", "1234");
        System.out.println("select usuario teste " + usuarioAdvancedUse.get(0));

        List<Caixa> caixaConsultaAgencia = con.query("SELECT * FROM maquina c WHERE c.fkAgencia = ?", new BeanPropertyRowMapper(Caixa.class), 100);
        System.out.println("select caixa teste" + caixaConsultaAgencia.get(0));

        List<RegistroCaixa> registro = con.query("select * from registroMaquina", new BeanPropertyRowMapper(RegistroCaixa.class));
        System.out.println(registro);

    }
}
