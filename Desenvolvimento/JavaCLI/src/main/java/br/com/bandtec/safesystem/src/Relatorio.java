/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.safesystem.src;

import br.com.bandtec.safesystem.src.models.RegistroMaquina;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Bruno
 */
public final class Relatorio {

    private final Integer agenciaDoCaixa;

    private JdbcTemplate con;
    private ConexaoBD config;

    /**
     *
     * @param fkAgencia
     *
     */
    public Relatorio(Integer fkAgencia) {
        this.agenciaDoCaixa = fkAgencia;
        novoRegistro();

    }

    public String novoRegistro() {
        //Recebe a consulta com os registros
        List<RegistroMaquina> listaDeRegistros = consultaBanco(agenciaDoCaixa);

        //Valida se a consulta retornou algum registro
        if (listaDeRegistros.isEmpty()) {
            return "Nenhum registro desse caixa foi encontrado nas ultimas 24 horas";
        }

        //Forma de juntar strings
        StringBuilder relatorio = new StringBuilder("");

        //Adiciona cada registro encotrado ao relatorio
        for (RegistroMaquina registro : listaDeRegistros) {
            relatorio.append("\n");
            relatorio.append(listaDeRegistros.toString());
            relatorio.append("\n\n");
        }

        String relatorioFinal = relatorio.toString();

        return relatorioFinal;
    }

    private List<RegistroMaquina> consultaBanco(Integer fkAgencia) {

        try {
            //Tentativa de conexão com o BD
            this.config = new ConexaoBD();
            this.con = new JdbcTemplate(config.getBancoDeDados());

        } catch (Exception e) {
            System.out.println("Falha ao conectar com o banco de dados");
            System.out.println(e.getMessage());
            
        }

        List<RegistroMaquina> listaDeRegistros = con.query(""
                + "SELECT * FROM registroMaquina trm "
                + "JOIN maquina tm ON trm.fkMaquina = tm.idMaquina "
                + "WHERE tm.fkAgencia = ? "
                + "AND trm.dataHora >= DATEADD(day, -1, GETDATE()) ",
                new BeanPropertyRowMapper(RegistroMaquina.class), fkAgencia);

        return listaDeRegistros;
    }
}
