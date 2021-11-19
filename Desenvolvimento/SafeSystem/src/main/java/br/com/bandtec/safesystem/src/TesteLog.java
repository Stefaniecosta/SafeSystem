/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.safesystem.src;

/**
 *
 * @author gustavo
 */
public class TesteLog {

    public static void main(String[] args) {

        try {
            //Tentativa de conexão com o BD
            System.out.println(";

        

    }
    catch (Exception e) {
            System.out.println("Falha ao conectar com o banco de dados");
        System.out.println(e.getMessage());
        Log log = new Log(e.getMessage(), "Falha ao conectar com o banco de dados");

    }
}
}
