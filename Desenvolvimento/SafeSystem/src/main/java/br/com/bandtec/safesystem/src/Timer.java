/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.safesystem.src;

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
}
