/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


public class RegistroMaquina {
      private Integer idRegistro;
      private Float totalRam;
      private Float usoRam;
      private Float totalDisco;
      private String nomeCPU;
      private Integer usoCPU;
      private Boolean dispositivoEstranho;
      private String dataHora;
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

    public Float getUsoRam() {
        return usoRam;
    }

    public void setUsoRam(Float usoRam) {
        this.usoRam = usoRam;
    }

    public Float getTotalDisco() {
        return totalDisco;
    }

    public void setTotalDisco(Float totalDisco) {
        this.totalDisco = totalDisco;
    }

    public String getNomeCPU() {
        return nomeCPU;
    }

    public void setNomeCPU(String nomeCPU) {
        this.nomeCPU = nomeCPU;
    }

    public Integer getUsoCPU() {
        return usoCPU;
    }

    public void setUsoCPU(Integer usoCPU) {
        this.usoCPU = usoCPU;
    }

    public Boolean getDispositivoEstranho() {
        return dispositivoEstranho;
    }

    public void setDispositivoEstranho(Boolean dispositivoEstranho) {
        this.dispositivoEstranho = dispositivoEstranho;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public Integer getFkMaquina() {
        return fkMaquina;
    }

    public void setFkMaquina(Integer fkMaquina) {
        this.fkMaquina = fkMaquina;
    }

    @Override
    public String toString() {
        return "RegistroCaixa{" + "\nidRegistro: " + idRegistro + ", \ntotalRam: " + totalRam + ", \nusoRam: " + usoRam + ", \ntotalDisco: " + totalDisco + ", \nnomeCPU: " + nomeCPU + ", \nusoCPU: " + usoCPU + ", \ndispositivoEstranho: " + dispositivoEstranho + ", \ndataHora: " + dataHora + ", \nfkMaquina: " + fkMaquina + '}';
    }
      
    
    
      
}
