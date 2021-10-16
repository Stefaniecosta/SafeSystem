/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.safesystem.src;

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
            Integer agencia = usuarioAdvancedUse.get(0).getAgencia();            
            // Chama um método para verificar se o caixa consiste com a agencia do usuario
            return VerificaCaixa(agencia);
        }

        return false;

    }

    private Boolean VerificaCaixa(Integer agenciaUsuario) {

        List<Caixa> caixaConsultaAgencia = con.query("SELECT * FROM caixa c WHERE c.id = ?", new BeanPropertyRowMapper(Caixa.class), codigoRecebido);

        // se a query retornar vazia, o acesso é negado (EX: se o caixa não existe no banco)
        if(caixaConsultaAgencia.isEmpty()){
            return false;
        }
        
        Integer agenciaCaixa = caixaConsultaAgencia.get(0).getAgencia();     
        
        if(Objects.equals(agenciaCaixa, agenciaUsuario)){
           System.out.println("Caixa verificado com sucesso!");
           return true; 
        }

        System.out.println("Verificação do caixa falhou...");
        return false;

    }

}
