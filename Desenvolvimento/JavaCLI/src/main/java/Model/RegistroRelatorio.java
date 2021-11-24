/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Bruno
 */
public class RegistroRelatorio extends RegistroMaquina{
    protected String sistemaOperacional;
    protected Float totalRam;
    protected String processador;
    protected String pontoDeMontagem; 
    protected Float espacoTotal;    

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public Float getTotalRam() {
        return totalRam;
    }

    public void setTotalRam(Float totalRam) {
        this.totalRam = totalRam;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getPontoDeMontagem() {
        return pontoDeMontagem;
    }

    public void setPontoDeMontagem(String pontoDeMontagem) {
        this.pontoDeMontagem = pontoDeMontagem;
    }

    public Float getEspacoTotal() {
        return espacoTotal;
    }

    public void setEspacoTotal(Float espacoTotal) {
        this.espacoTotal = espacoTotal;
    }

    @Override
    public String toString() {
        return super.toString() + "sistemaOperacional=" + sistemaOperacional + ", totalRam=" + totalRam + ", processador=" + processador + ", pontoDeMontagem=" + pontoDeMontagem + ", espacoTotal=" + espacoTotal + '}';
    }


    

    
    
    
    
}
