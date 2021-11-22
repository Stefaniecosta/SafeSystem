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
import org.h2.message.DbException;

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
                + "VALUES (GETDATE(), ?, ?, ?, ?, ?);", ramUso, cpuUso, frequenciaCpu, discoUso, idCaixa);

    }

    public String atualizarComponentesNoBanco(Integer idCaixa) {
        ConexaoBD config = new ConexaoBD();
        JdbcTemplate con = new JdbcTemplate(config.getBancoDeDados());

        String cpuNome = this.cpu.getNome();
        String so = looca.getSistema().getSistemaOperacional();
        Float ramTotal = LongParaFloat(this.ram.getTotal());
        Float discoTotal = LongParaFloat(this.disco.getVolumes().get(0).getTotal());

        try {
            con.update("UPDATE maquina SET sistemaOperacional = ?, totalRam = ?, processador = ?, totalDisco = ? "
                    + "WHERE idMaquina = ?;", so, ramTotal, cpuNome, discoTotal, idCaixa);
        } catch (DbException e) {
            String erroMsg = "Falha ao atualizar componentes do caixa";
            System.out.println(erroMsg);
            System.out.println(e.getMessage());
            Log log = new Log(e.getMessage(), erroMsg);
            return erroMsg;
        }

        String mensagem = String.format("<html> Componentes Atualizados! <br>"
                + "Processador: %s<br> Sistema Operacional: %s<br>Memoria: %.2f<br>Disco: %.2f</html>",
                cpuNome, so, ramTotal, discoTotal
        );
        return mensagem;

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
