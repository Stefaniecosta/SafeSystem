/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.safesystem.src;

/**
 *
 * @author Bruno
 */
public class TesteLogin {
    public static void main(String[] args) {
        Autenticacao aut = new Autenticacao("a", "1234", "9");        
        aut.AutenticaUsuario();
    }
}
