/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.safesystem.src;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import org.springframework.jdbc.core.JdbcTemplate;
import com.github.britooo.looca.api.util.Conversor;

public class EnviaDados {

    Looca looca = new Looca();
    Memoria ram = new Memoria();
    Processador cpu = new Processador();
    DiscosGroup disco = new DiscosGroup();

    private Integer idCaixa;

    public void insereDados(Integer idCaixa) {

        ConexaoBD config = new ConexaoBD();
        JdbcTemplate con = new JdbcTemplate(config.getBancoDeDados());
                
        System.out.println(ram);
        System.out.println(looca.getGrupoDeDiscos().getDiscos());
        
        Double ramUso = LongParaDouble(ram.getEmUso());
        Double ramTotal = LongParaDouble(ram.getTotal());
        
        String cpuNome = cpu.getNome();
        Double cpuUso = cpu.getUso();
        
        
    }
    
    public double LongParaDouble(Long valorLong){
        String valorConvertido = Conversor.formatarBytes(ram.getEmUso());
        String valorString = valorConvertido.replace(",", ".");
        valorString = valorString.replace("GiB", "");
        double valorDouble = Double.parseDouble(valorString);
        
        return valorDouble;
    }
}
