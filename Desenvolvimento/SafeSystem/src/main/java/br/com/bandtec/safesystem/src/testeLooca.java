/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.safesystem.src;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Volume;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class testeLooca {
    public static void main(String[] args) {
        Looca looca = new Looca();
        
        System.out.println(looca.getGrupoDeDiscos().getVolumes());
        

        
    }
}
