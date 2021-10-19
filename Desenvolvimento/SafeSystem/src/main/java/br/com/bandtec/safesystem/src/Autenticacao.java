/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.safesystem.src;

import br.com.bandtec.safesystem.src.models.Agencia;
import br.com.bandtec.safesystem.src.models.Usuario;
import br.com.bandtec.safesystem.src.models.Caixa;
import java.util.List;
import java.util.Objects;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Bruno
 */
public class Autenticacao {

    private final String loginRecebido;
    private final String senhaRecebida;
    private final String codigoRecebido;

    public Autenticacao(String loginRecebido, String senhaRecebida, String codigoRecebido) {
        this.loginRecebido = loginRecebido;
        this.senhaRecebida = senhaRecebida;
        this.codigoRecebido = codigoRecebido;
    }

    ConexaoBD config = new ConexaoBD();
    JdbcTemplate con = new JdbcTemplate(config.getBancoDeDados());

    /**
     * AutenticaUsuario -> Metodo que chama o metodo getUsuario na classe
     * Usuario
     *
     * @return
     */
    public Boolean AutenticaUsuario() {

        List<Usuario> usuarioAdvancedUse = con.query("SELECT * FROM  usuario WHERE login = ? AND senha = ?", new BeanPropertyRowMapper(Usuario.class), loginRecebido, senhaRecebida);
        
        // verifica se a query retorna algo. Se não ser vazio, o if é executado
        if (!usuarioAdvancedUse.isEmpty()) {
            Integer agencia = usuarioAdvancedUse.get(0).getFkAgencia();
            // Chama um método para verificar se o caixa consiste com a agencia do usuario
            return VerificaCaixa(agencia);
        }

        return false;

    }
    
        public Boolean AutenticaAgencia() {

        List<Agencia> agenciaAdvancedUse = con.query("SELECT * FROM  agencia WHERE codigoAgencia = ? AND senha = ?", new BeanPropertyRowMapper(Agencia.class), loginRecebido, senhaRecebida);
        
        // verifica se a query retorna algo. Se não ser vazio, o if é executado
        if (!agenciaAdvancedUse.isEmpty()) {
            Integer agencia = agenciaAdvancedUse.get(0).getIdAgencia();
            System.out.println("verificaçõa de login funcionou...");
            return VerificaCaixa(agencia);
        }
        System.out.println("verificaçõa de login falhou...");
        return false;

    }

    private Boolean VerificaCaixa(Integer idAgencia) {

        List<Caixa> caixaConsultaAgencia = con.query("SELECT * FROM maquina m WHERE m.idMaquina = ?", new BeanPropertyRowMapper(Caixa.class), this.codigoRecebido);

        // se a query retornar vazia, o acesso é negado (EX: se o caixa não existe no banco)
        if(caixaConsultaAgencia.isEmpty()){
            System.out.println("caixa não existe");
            return false;
        }
        
        Integer agenciaDoCaixa = caixaConsultaAgencia.get(0).getFkAgencia();     
        
        if(Objects.equals(agenciaDoCaixa, idAgencia)){
           System.out.println("Caixa verificado com sucesso!");
           return true; 
        }

        System.out.println("Verificação do caixa falhou...");
        return false;

    }

}
