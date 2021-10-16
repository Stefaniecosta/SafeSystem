/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.safesystem.src;

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
        con.execute("DROP TABLE IF EXISTS caixa");
        con.execute("DROP TABLE IF EXISTS agencia");

        String tabelaAgencia = "CREATE TABLE agencia ("
                + "id INT PRIMARY KEY AUTO_INCREMENT,"
                + "nome VARCHAR(255))";

        String tabelaCaixa = "CREATE TABLE caixa ("
                + "id INT PRIMARY KEY AUTO_INCREMENT,"
                + "agencia INT,"
                + "FOREIGN KEY (agencia) REFERENCES agencia(id))";

        String tabelaUsuario = "CREATE TABLE usuario ("
                + "id INT PRIMARY KEY AUTO_INCREMENT,"
                + "login VARCHAR(255),"
                + "senha VARCHAR(255),"
                + "agencia INT,"
                + "FOREIGN KEY (agencia) REFERENCES agencia(id))";

        // Executando o comando de criação de fato.
        con.execute(tabelaAgencia);
        con.execute(tabelaCaixa);
        con.execute(tabelaUsuario);

        con.update("INSERT INTO agencia VALUES (?, ?)", null, "caixa economica 1");
        con.update("INSERT INTO agencia VALUES (?, ?)", null, "caixa economica 2");

        con.update("INSERT INTO caixa VALUES (?, ?)", null, 1);
        con.update("INSERT INTO caixa VALUES (?, ?)", null, 2);

        con.update("INSERT INTO usuario VALUES (?, ?, ?, ?)", null, "login", "1234", "1");
        con.update("INSERT INTO usuario VALUES (?, ?, ?, ?)", null, "login", "123", "1");
        con.update("INSERT INTO usuario VALUES (?, ?, ?, ?)", null, "login", "12", "1");
        con.update("INSERT INTO usuario VALUES (?, ?, ?, ?)", null, "login", "1", "2");
        
        List<Usuario> usuarioAdvancedUse = con.query("SELECT * FROM  usuario WHERE login = ? AND senha = ?",new BeanPropertyRowMapper(Usuario.class), "login", "1234");
        
        System.out.println("select caixa teste " + usuarioAdvancedUse.get(0));
        
        List<Caixa> caixaConsultaAgencia = con.query("SELECT * FROM caixa c WHERE c.agencia = ?",new BeanPropertyRowMapper(Caixa.class), 2);
        
        System.out.println("select caixa teste" + caixaConsultaAgencia.get(0));
       
    }
}
