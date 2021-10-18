/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.safesystem.src;

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
//

        con.execute("DROP TABLE IF EXISTS usuario");
        con.execute("DROP TABLE IF EXISTS registroMaquina");
        con.execute("DROP TABLE IF EXISTS maquina");
        con.execute("DROP TABLE IF EXISTS agencia");

        String tabelaAgencia = "CREATE TABLE agencia ("
                + "idAgencia INT PRIMARY KEY AUTO_INCREMENT,"
                + "nome VARCHAR(255))";

        String tabelaUsuario = "CREATE TABLE usuario ("
                + "id INT PRIMARY KEY AUTO_INCREMENT,"
                + "login VARCHAR(255),"
                + "senha VARCHAR(255),"
                + "fkAgencia INT,"
                + "FOREIGN KEY (fkAgencia) REFERENCES agencia(idAgencia))";

        String tabelaCaixa = "CREATE TABLE maquina ("
                + "idMaquina INT PRIMARY KEY AUTO_INCREMENT,"
                + "patrimonio VARCHAR(20),"
                + "fkAgencia int NOT NULL,"
                + "quantDispositivo int,"
                + "sistemaOperacional VARCHAR(40),"
                + "FOREIGN KEY (fkAgencia) REFERENCES agencia(idAgencia))";

        String tabelaRegistros = "CREATE TABLE registroMaquina ("
                + "idRegistro INT PRIMARY KEY AUTO_INCREMENT,"
                + "totalRam float,"
                + "utilizandoRam float,"
                + "totalDisco float,"
                + "utilizandoDisco float,"
                + "infoCPU varchar(45),"
                + "dispositivoEstranho bit,"
                + "data Date,"
                + "hora time,"
                + "fkMaquina int,"
                + "FOREIGN KEY (fkMaquina) REFERENCES maquina(idMaquina))";

        // Executando o comando de criação de fato.
        con.execute(tabelaAgencia);
        con.execute(tabelaCaixa);
        con.execute(tabelaUsuario);
        con.execute(tabelaRegistros);
//
        con.update("INSERT INTO agencia VALUES (?, ?)", null, "caixa economica 1");
        con.update("INSERT INTO agencia VALUES (?, ?)", null, "caixa economica 2");

        con.update("INSERT INTO maquina(idMaquina,fkAgencia)  VALUES (?, ?)", 1, 1);
        con.update("INSERT INTO maquina(idMaquina,fkAgencia) VALUES (?, ?)", 2, 2);

        con.update("INSERT INTO usuario VALUES (?, ?, ?, ?)", null, "login", "1234", "1");
        con.update("INSERT INTO usuario VALUES (?, ?, ?, ?)", null, "login", "123", "2");
        con.update("INSERT INTO usuario VALUES (?, ?, ?, ?)", null, "login", "12", "1");
        con.update("INSERT INTO usuario VALUES (?, ?, ?, ?)", null, "login", "1", "2");

        List<Usuario> usuarioAdvancedUse = con.query("SELECT * FROM  usuario WHERE login = ? AND senha = ?", new BeanPropertyRowMapper(Usuario.class), "login", "1234");
        System.out.println("select usuario teste " + usuarioAdvancedUse.get(0));

        List<Caixa> caixaConsultaAgencia = con.query("SELECT * FROM maquina c WHERE c.fkAgencia = ?", new BeanPropertyRowMapper(Caixa.class), 1);
        System.out.println("select caixa teste" + caixaConsultaAgencia.get(0));
        
        List<RegistroCaixa> registro = con.query("select * from registroMaquina", new BeanPropertyRowMapper(RegistroCaixa.class));
        System.out.println(registro);

    }
}
