/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.login.src;

/**
 *
 * @author Bruno
 */
public class Autenticacao {

    private String loginRecebido;
    private String senhaRecebida;

    public Autenticacao(String loginRecebido, String senhaRecebida) {
        this.loginRecebido = loginRecebido;
        this.senhaRecebida = senhaRecebida;
    }

    /** 
     AutenticaUsuario -> Metodo que chama o metodo getUsuario na classe Usuario
     * @return 
     */
    public Boolean AutenticaUsuario() {
        
        Usuario user = new Usuario();

        return user.getUsuario(loginRecebido, senhaRecebida);

    }

}
