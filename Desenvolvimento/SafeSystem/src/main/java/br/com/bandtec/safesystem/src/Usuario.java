/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.safesystem.src;

public class Usuario {
    
    private Integer id;
    private String login;
    private String senha;
    private Integer agencia;

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }
    

    @Override
    public String toString() {
        return String.format("\nID: %d\nLOGIN: %s\nSENHA: %s\n",
                this.id, this.login, this.senha);
    }
}
