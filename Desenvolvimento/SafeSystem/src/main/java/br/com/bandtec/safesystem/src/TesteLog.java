/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.safesystem.src;

/**
 *
 * @author Bruno
 */
public class TesteLog {

    public static void main(String[] args) {
            try{
                System.out.println("teste log");
                //if(a) 
            }
            catch(Exception e){
            Log log = new Log(e.getMessage(), "Falha ao enviar alerta de mapeamento de dispositivos ao Slack");
    }

}
}
