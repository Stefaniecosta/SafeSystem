/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.safesystem.src;

import br.com.bandtec.safesystem.usb.DispositivoUsb;
import java.util.TimerTask;


public class Timer {

    EnviaDados env = new EnviaDados();

    public void repeticao(Integer idCaixa) {

        new java.util.Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                env.insereDados(idCaixa);
            }
        }, 0, 10000);
    }
    
    public void repeticaoUsb(Integer idCaixa){
       new java.util.Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                DispositivoUsb dis = new DispositivoUsb();
                dis.verificarUSB();
                if(dis.getDispUsb().size() == 0){
                    System.out.println("NENHUM DISPOSITIVO ENCONTRADO");
                }else{
                    dis.verificarDispositivoEstranho(idCaixa);
                    }
            }
        }, 0, 100);
        
    }

    public void scheduleAtFixedRate(TimerTask timerTask, int delay, int interval) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
