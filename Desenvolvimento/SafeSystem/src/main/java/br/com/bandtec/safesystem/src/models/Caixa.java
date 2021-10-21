package br.com.bandtec.safesystem.src.models;


public class Caixa {
    private Integer idMaquina;
    private String patrimonio;
    private Integer fkAgencia;
    private Integer quantDispositivo;
    private String sistemaOperacional;

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }

    public Integer getFkAgencia() {
        return fkAgencia;
    }

    public void setFkAgencia(Integer fkAgencia) {
        this.fkAgencia = fkAgencia;
    }

    public Integer getQuantDispositivo() {
        return quantDispositivo;
    }

    public void setQuantDispositivo(Integer quantDispositivo) {
        this.quantDispositivo = quantDispositivo;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }


    @Override
    public String toString() {
        return "\n ID: " + idMaquina + "\n agencia: " + fkAgencia ;
    }
    

}
