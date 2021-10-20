/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.safesystem.src;

import java.util.TimerTask;

/**
 *
 * @author Bruno
 */
public class Timer {

    EnviaDados env = new EnviaDados();

    public void repeticao() {

        new java.util.Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                env.insereDados(1);
            }
        }, 0, 10000);
    }
}
