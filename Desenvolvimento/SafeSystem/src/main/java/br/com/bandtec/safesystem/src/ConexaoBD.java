/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.safesystem.src;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConexaoBD {

    private final BasicDataSource bancoDeDados;

    public ConexaoBD() {
        this.bancoDeDados = new BasicDataSource();
        this.bancoDeDados.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        this.bancoDeDados.setUrl("jdbc:sqlserver://safesystem.database.windows.net:1433;database=safesystem;"
                + "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;"); // Link e porta do Azure
        this.bancoDeDados.setUsername("safe");
        this.bancoDeDados.setPassword("Senh@forte06");
        
//        this.bancoDeDados = new BasicDataSource();
//        this.bancoDeDados.setDriverClassName("org.h2.Driver");
//        this.bancoDeDados.setUrl("jdbc:h2:file:./sfsy");
//        this.bancoDeDados.setUsername("sa");
//        this.bancoDeDados.setPassword("");
           

    }

    public BasicDataSource getBancoDeDados() {
        return bancoDeDados;
    }

}
