/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.safesystem.src.models;

public class Usuario {
    
    private Integer id;
    private String login;
    private String senha;
    private Integer fkAgencia;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getFkAgencia() {
        return fkAgencia;
    }

    public void setFkAgencia(Integer fkAgencia) {
        this.fkAgencia = fkAgencia;
    }

    

    @Override
    public String toString() {
        return String.format("\nID: %d\nLOGIN: %s\nSENHA: %s\n",
                this.id, this.login, this.senha);
    }
}
