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
      private String infoCPU;
      private Boolean dispositivoEstranho;
      private String data;
      private String hora;
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

    public String getInfoCPU() {
        return infoCPU;
    }

    public void setInfoCPU(String infoCPU) {
        this.infoCPU = infoCPU;
    }

    public Boolean getDispositivoEstranho() {
        return dispositivoEstranho;
    }

    public void setDispositivoEstranho(Boolean dispositivoEstranho) {
        this.dispositivoEstranho = dispositivoEstranho;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Integer getFkMaquina() {
        return fkMaquina;
    }

    public void setFkMaquina(Integer fkMaquina) {
        this.fkMaquina = fkMaquina;
    }

    @Override
    public String toString() {
        return "RegistroCaixa{\n" + "idRegistro: " + idRegistro + ",\ntotalRam: " + totalRam + ", \nutilizandoRam:" + utilizandoRam + ", \ntotalDisco:" + totalDisco + ", \nutilizandoDisco:" + utilizandoDisco + ", \ninfoCPU:" + infoCPU + ", \ndispositivoEstranho:" + dispositivoEstranho + ", \ndata:" + data + ", \nhora:" + hora + ", \nfkMaquina:" + fkMaquina + '}';
    }
      
    
      
}
