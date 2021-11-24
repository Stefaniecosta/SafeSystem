/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class Usuario {
    
    private Integer idUsuario;
    private String nome;
    private String email;
    private String senha;
    private Integer fkAgencia;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        return "Usuario{" + "idUsuario=" + idUsuario + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", fkAgencia=" + fkAgencia + '}';
    }
    
}
