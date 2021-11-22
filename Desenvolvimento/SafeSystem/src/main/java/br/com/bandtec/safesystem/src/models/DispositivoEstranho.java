
package br.com.bandtec.safesystem.src.models;

public class DispositivoEstranho {
    private Integer idDispositivo;
    private String productId;
    private String uniqueDevice;
    private String nome;
    private Integer fkMaquina;
    private String dataHora;

    @Override
    public String toString() {
        return "dispositivoEstranho{" + "idDispositivo=" + idDispositivo + ", productId=" + productId + ", uniqueDevice=" + uniqueDevice + ", nome=" + nome + ", fkMaquina=" + fkMaquina + ", dataHora=" + dataHora + '}';
    }

    public Integer getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(Integer idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUniqueDevice() {
        return uniqueDevice;
    }

    public void setUniqueDevice(String uniqueDevice) {
        this.uniqueDevice = uniqueDevice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getFkMaquina() {
        return fkMaquina;
    }

    public void setFkMaquina(Integer fkMaquina) {
        this.fkMaquina = fkMaquina;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
    
    
    
}
