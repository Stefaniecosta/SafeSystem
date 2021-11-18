/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.safesystem.src;

import java.io.IOException;
import org.json.JSONObject;


/**
 *
 * @author Bruno
 */
public class testeSlack {

    public static void main(String[] args) throws IOException, InterruptedException {

        Slack.enviarRelatorio(101);
    }
}
