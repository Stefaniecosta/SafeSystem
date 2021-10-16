/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.safesystem.src;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Bruno
 */
public class ConexaoBD {

    private final BasicDataSource bancoDeDados;

    public ConexaoBD() {
        this.bancoDeDados = new BasicDataSource();
        this.bancoDeDados.setDriverClassName("org.h2.Driver");
        this.bancoDeDados.setUrl("jdbc:h2:file:./sfsy");
        this.bancoDeDados.setUsername("sa");
        this.bancoDeDados.setPassword("");
//        this.bancoDeDados = new BasicDataSource();
//        this.bancoDeDados.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        this.bancoDeDados.setUrl("jdbc:mysql://localhost:3306/sfsy");
//        this.bancoDeDados.setUsername("root");
//        this.bancoDeDados.setPassword("senha");
    }

    public BasicDataSource getBancoDeDados() {
        return bancoDeDados;
    }
    
    

}
