/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.safesystem.src.models;

public class Usuario {
    
    private Integer idUsuario;
    private String email;
    private String senha;
    private Integer fkAgencia;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return String.format("\nID: %d\nEMAIL: %s\nSENHA: %s\n",
                this.idUsuario, this.email, this.senha);
    }
}
