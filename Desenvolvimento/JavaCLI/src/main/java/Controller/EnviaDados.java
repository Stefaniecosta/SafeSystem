/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import org.springframework.jdbc.core.JdbcTemplate;
import com.github.britooo.looca.api.util.Conversor;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.h2.message.DbException;
import org.springframework.dao.DataAccessException;

public class EnviaDados {

    Looca looca = new Looca();
    Memoria ram = new Memoria();
    Processador cpu = new Processador();
    DiscosGroup disco = new DiscosGroup();

    public void insereDados(Integer idCaixa) {

        ConexaoBD config = new ConexaoBD();
        JdbcTemplate con = new JdbcTemplate(config.getBancoDeDados());

        Float ramUso = LongParaFloat(ram.getEmUso());

        Float frequenciaCpu = LongParaFloat(cpu.getFrequencia());
        Integer cpuUso = cpu.getUso().intValue();

        Float discoTotal = LongParaFloat(looca.getGrupoDeDiscos().getVolumes().get(0).getTotal());
        Float discoLivre = LongParaFloat(looca.getGrupoDeDiscos().getVolumes().get(0).getDisponivel());

        Float discoUso = discoTotal - discoLivre;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String horaAtual = dtf.format(LocalDateTime.now());

        try {
            con.update("INSERT INTO registroMaquina(dataHora, usoRam, usoCpu, frequenciaCPU, usoDisco, fkMaquina) "
                    + "VALUES (?, ?, ?, ?, ?, ?);", horaAtual, ramUso, cpuUso, frequenciaCpu, discoUso, idCaixa);

        } catch (DataAccessException e) {
            String erroMsg = "Falha ao inserir componentes no caixa";
            System.out.println(erroMsg);
            Log log = new Log(e.getMessage(), erroMsg);
        }

        String dadosCapturados = String.format("Dados capturados:{\n"
                + " Uso RAM: %.2f\n"
                + " Uso CPU: %d%%\n"
                + " Frequencia CPU: %.2f\n"
                + " Uso Disco: %.2f\n"
                + "}", ramUso, cpuUso, frequenciaCpu, discoUso);

        System.out.println(dadosCapturados);

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

        String mensagem = String.format("Componentes Atualizados!\n"
                + "Processador: %s\n Sistema Operacional: %s\nMemoria: %.2f\nDisco: %.2f\n",
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
