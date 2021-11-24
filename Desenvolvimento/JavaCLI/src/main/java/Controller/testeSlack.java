/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import org.json.JSONObject;


/**
 *
 * @author Bruno
 */
public class testeSlack {

    public static void main(String[] args) throws IOException, InterruptedException, Exception {

        Slack s = new Slack(100);
        
        Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
        String datetime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(dataDeHoje.getTime());
        
        //s.alertaDispositivo(1, datetime);
        s.alertaMapeamento(1, 1, datetime);
    }
}
