
package Controller;

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
    
    DispositivoUsb dis = new DispositivoUsb();
    public void repeticaoUsb(Integer idCaixa) {
        new java.util.Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                dis.verificarUSB();
                if (dis.getDispUsb().isEmpty()) {
                    System.out.println("NENHUM DISPOSITIVO CONECTADO");
                } else {
                    dis.verificarDispositivoEstranho(idCaixa);
                }
            }
        }, 0, 1000);

    }

    public void scheduleAtFixedRate(TimerTask timerTask, int delay, int interval) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
