/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.safesystem.src;

import br.com.bandtec.safesystem.src.models.Agencia;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Bruno
 */
public class TesteAzure {

    public static void main(String[] args) {
        ConexaoBD config = new ConexaoBD();
        JdbcTemplate con = new JdbcTemplate(config.getBancoDeDados());

        List<Agencia> agencia = con.query("select * from agencia", new BeanPropertyRowMapper(Agencia.class));
        System.out.println(agencia);
    }

}
