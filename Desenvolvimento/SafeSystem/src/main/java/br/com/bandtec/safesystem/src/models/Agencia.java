/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.safesystem.src.models;


public class Agencia {
    private Integer idAgencia;
    private String nomeAgencia;
    private String localizacaoAgencia;
    private String codigoAgencia;
    private Integer fkBanco;
    private String senha;

    public Integer getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(Integer idAgencia) {
        this.idAgencia = idAgencia;
    }

    public String getNomeAgencia() {
        return nomeAgencia;
    }

    public void setNomeAgencia(String nomeAgencia) {
        this.nomeAgencia = nomeAgencia;
    }

    public String getLocalizacaoAgencia() {
        return localizacaoAgencia;
    }

    public void setLocalizacaoAgencia(String localizacaoAgencia) {
        this.localizacaoAgencia = localizacaoAgencia;
    }

    public String getCodigoAgencia() {
        return codigoAgencia;
    }

    public void setCodigoAgencia(String codigoAgencia) {
        this.codigoAgencia = codigoAgencia;
    }

    public Integer getFkBanco() {
        return fkBanco;
    }

    public void setFkBanco(Integer fkBanco) {
        this.fkBanco = fkBanco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }



    @Override
    public String toString() {
        return "AGENCIA {" + "\n ID: "+idAgencia+"\n Nome: "+nomeAgencia+"\n Localização: "+localizacaoAgencia+"\n CodAgencia: "+codigoAgencia+"\n fkBanco: "+fkBanco+"\n senha"+senha; 
    }
    
    
    
}
