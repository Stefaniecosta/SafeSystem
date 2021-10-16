package br.com.bandtec.safesystem.src;

/**
 *
 * @author Bruno
 */
public class Caixa {
    private Integer id;
    private Integer agencia;

    public Integer getId() {
        return id;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    @Override
    public String toString() {
        return "\n ID: " + id + "\n agencia: " + agencia ;
    }
    

}
