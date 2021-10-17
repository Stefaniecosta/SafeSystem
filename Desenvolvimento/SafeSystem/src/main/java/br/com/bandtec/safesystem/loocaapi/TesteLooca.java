/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.bandtec.safesystem.loocaapi;

import com.github.britooo.looca.api.core.Looca;

/**
 *
 * @author breno
 */
public class TesteLooca 
{
    public static void main(String[] args) 
    {
        Looca getInfo = new Looca();
        
        // Listando informações de Memória RAM.
        System.out.println
        (
                getInfo.getMemoria().toString()
        );
       
        System.out.println("\n");
        
        System.out.println
        (
                getInfo.getProcessador().toString()
        );
        
        System.out.println("\n");
        
        System.out.println
        (
                getInfo.getTemperatura().toString()
        );
        
        System.out.println("\n");
        
        System.out.println
        (
                "\n\nRodando método getDiscos:" +
                getInfo.getGrupoDeDiscos().getDiscos() +
                "\n\nQuantidade de Discos: " +
                getInfo.getGrupoDeDiscos().getQuantidadeDeDiscos() +
                "\n\nQuantidade de Volumes: " +
                getInfo.getGrupoDeDiscos().getQuantidadeDeVolumes() +
                "\n\nRodando método getVolumes: " +
                getInfo.getGrupoDeDiscos().getVolumes() +
                "\n\nRodando método getTamanhoTotal: " +
                getInfo.getGrupoDeDiscos().getTamanhoTotal() +
                 "\n\nRodando método total de threads: " +
                        getInfo.getGrupoDeProcessos().getTotalThreads() 
               
        );
    }
}
