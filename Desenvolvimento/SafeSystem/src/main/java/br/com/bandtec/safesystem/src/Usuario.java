/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.safesystem.src;


public class Usuario {
    private final String login;
    private final String senha;

    public Usuario() {
        this.login = "1234";
        this.senha = "1234";
    }

    private String getLogin() {
        return login;
    }

    private String getSenha() {
        return senha;
    }
    
    public Boolean getUsuario(String loginForm, String senhaForm){
        
        return login.equals(loginForm) && senha.equals(senhaForm);
    }

}
