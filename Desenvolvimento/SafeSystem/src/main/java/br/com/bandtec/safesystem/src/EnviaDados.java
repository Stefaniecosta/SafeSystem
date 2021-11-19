/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.safesystem.src;

import com.github.britooo.looca.api.core.Looca;
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
    

    public void insereDados(Integer idCaixa) {

        ConexaoBD config = new ConexaoBD();
        JdbcTemplate con = new JdbcTemplate(config.getBancoDeDados());

        Float ramTotal = LongParaFloat(ram.getTotal());
        Float ramUso = LongParaFloat(ram.getEmUso());

        Float frequenciaCpu = LongParaFloat(cpu.getFrequencia());
        Integer cpuUso = cpu.getUso().intValue();

        Float discoTotal = LongParaFloat(looca.getGrupoDeDiscos().getVolumes().get(0).getTotal());
        Float discoLivre = LongParaFloat(looca.getGrupoDeDiscos().getVolumes().get(0).getDisponivel());
        
        Float discoUso = discoTotal - discoLivre;

        con.update("INSERT INTO registroMaquina(dataHora, usoRam, usoCpu, frequenciaCPU, usoDisco, fkMaquina) "
                + "VALUES (GETDATE(), ?, ?, ?, ?, ?);", ramUso, cpuUso ,frequenciaCpu, discoUso, idCaixa);
             
    }

    public double LongParaDouble(Long valorLong) {
        String valorConvertido = Conversor.formatarBytes(valorLong);
        String valorString = valorConvertido.replace(",", ".");
        valorString = valorString.replace("GiB", "");
        double valorDouble = Double.parseDouble(valorString);

        return valorDouble;
    }

    public Integer LongParaInteger(Long valorLong) {
        String valorConvertido = Conversor.formatarBytes(valorLong);
        String valorString = valorConvertido.replace(",", ".");
        valorString = valorString.replace("GiB", "");
        Integer valorInteger = Integer.parseInt(valorString);

        return valorInteger;
    }

    public Float LongParaFloat(Long valorLong) {
        String valorConvertido = Conversor.formatarBytes(valorLong);
        String valorString = valorConvertido.replace(",", ".");
        valorString = valorString.replace("GiB", "");
        Float valorFloat = Float.parseFloat(valorString);

        return valorFloat;
    }

}
