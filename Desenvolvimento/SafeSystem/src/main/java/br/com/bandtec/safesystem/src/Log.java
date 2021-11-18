/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.safesystem.src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 *
 * @author gustavo
 */
public final class Log {

    private final String errorMessage;
    private final String errorException;

    public Log(String errorMessage, String errorException) {
        this.errorMessage = errorMessage;
        this.errorException = errorException;
        this.GerarLog();
    }

    public void GerarLog() {

        try {
            Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
            String datetime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(dataDeHoje.getTime());

            System.out.println("Gerando log de erro...");

            File diretorio = new File("/home/gustavo/logs/");

            try {
                
                if (!diretorio.exists()) {
                    
                    if (diretorio.mkdir()) {
                        
                        System.out.println("Diretório criado");
                        
                    } else {
                        
                        System.out.println("Erro ao criar diretório");
                    }
                }
            } catch (Exception e) {
                e.getMessage();
            }
            
            File arquivo = new File("/home/gustavo/logs/" + datetime + ".txt");
            FileWriter fileWriter = new FileWriter(arquivo, true);
            PrintWriter gravarArq = new PrintWriter(fileWriter);
            gravarArq.println(dataDeHoje + " " + errorMessage + ": " + errorException + "\n");
            fileWriter.close();

            System.out.println("Log gerado com sucesso.");
        } catch (IOException e) {

            System.out.println(e);
        }
    }
}
