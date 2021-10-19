/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.safesystem.src.models;

/**
 *
 * @author Bruno
 */
public class RegistroCaixa {
      private Integer idRegistro;
      private Float totalRam;
      private Float utilizandoRam;
      private Float totalDisco;
      private Float utilizandoDisco;
      private String nomeCPU;
      private Integer utilizandoCPU;
      private Boolean dispositivoEstranho;
      private Integer fkMaquina;

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Float getTotalRam() {
        return totalRam;
    }

    public void setTotalRam(Float totalRam) {
        this.totalRam = totalRam;
    }

    public Float getUtilizandoRam() {
        return utilizandoRam;
    }

    public void setUtilizandoRam(Float utilizandoRam) {
        this.utilizandoRam = utilizandoRam;
    }

    public Float getTotalDisco() {
        return totalDisco;
    }

    public void setTotalDisco(Float totalDisco) {
        this.totalDisco = totalDisco;
    }

    public Float getUtilizandoDisco() {
        return utilizandoDisco;
    }

    public void setUtilizandoDisco(Float utilizandoDisco) {
        this.utilizandoDisco = utilizandoDisco;
    }

    public String getNomeCPU() {
        return nomeCPU;
    }

    public void setNomeCPU(String nomeCPU) {
        this.nomeCPU = nomeCPU;
    }

    public Integer getUtilizandoCPU() {
        return utilizandoCPU;
    }

    public void setUtilizandoCPU(Integer utilizandoCPU) {
        this.utilizandoCPU = utilizandoCPU;
    }

    public Boolean getDispositivoEstranho() {
        return dispositivoEstranho;
    }

    public void setDispositivoEstranho(Boolean dispositivoEstranho) {
        this.dispositivoEstranho = dispositivoEstranho;
    }

    public Integer getFkMaquina() {
        return fkMaquina;
    }

    public void setFkMaquina(Integer fkMaquina) {
        this.fkMaquina = fkMaquina;
    }


    @Override
    public String toString() {
        return "RegistroCaixa{\n" + "idRegistro: " + idRegistro + ",\ntotalRam: " + totalRam + ", \nutilizandoRam:" + utilizandoRam + ", \ntotalDisco:" + totalDisco + ", \nutilizandoDisco:" + utilizandoDisco + ", \nnomeCPU:" + nomeCPU +", \nusoCPU:"+ utilizandoCPU + ", \ndispositivoEstranho:" + dispositivoEstranho + ", \nfkMaquina:" + fkMaquina + '}';
    }
      
    
      
}
