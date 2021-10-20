/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.safesystem.src;

import br.com.bandtec.safesystem.src.models.RegistroCaixa;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import org.springframework.jdbc.core.JdbcTemplate;
import com.github.britooo.looca.api.util.Conversor;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

public class EnviaDados {

    Looca looca = new Looca();
    Memoria ram = new Memoria();
    Processador cpu = new Processador();
    DiscosGroup disco = new DiscosGroup();
    

    public void insereDados(Integer idCaixa) {

        ConexaoBD config = new ConexaoBD();
        JdbcTemplate con = new JdbcTemplate(config.getBancoDeDados());

        System.out.println(ram);
        System.out.println(looca.getGrupoDeDiscos().getDiscos().get(0));

        Float ramTotal = LongParaFloat(ram.getTotal());
        Float ramUso = LongParaFloat(ram.getEmUso());

        String cpuNome = cpu.getNome();
        Integer cpuUso = cpu.getUso().intValue();

        Float discoTotal = LongParaFloat(looca.getGrupoDeDiscos().getDiscos().get(0).getTamanho());

        System.out.println(ramUso + " RAM uso");
        System.out.println(ramTotal + " RAM TOTAL");
        System.out.println(discoTotal + " DISCO TOTAL");
        System.out.println(cpuNome);
        System.out.println(cpuNome.length());
        System.out.println(cpuUso + "cpu uso");

        Float floatTeste = Float.parseFloat("1.0");

        con.update("INSERT INTO registroMaquina(totalRam, usoRam, totalDisco, dispositivoEstranho, dataHora, nomeCPU, usoCPU,fkMaquina) "
                + "VALUES (?, ?, ?, ?, GETDATE(), ?, ?, ?);", ramTotal, ramUso, discoTotal, 0,cpuNome, cpuUso, idCaixa);
        
        List<RegistroCaixa> registro = con.query("select top 1 * from registroMaquina order by idRegistro desc", new BeanPropertyRowMapper(RegistroCaixa.class));
        System.out.println(registro);
        
        

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
