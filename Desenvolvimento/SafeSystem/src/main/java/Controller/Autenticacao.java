/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Maquina;
import Model.Usuario;
import java.util.List;
import java.util.Objects;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

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
    public List<Usuario> AutenticaUsuario() {

        List<Usuario> usuarioAdvancedUse = con.query("SELECT * FROM  usuario WHERE email = ? AND senha = ?", new BeanPropertyRowMapper(Usuario.class), loginRecebido, senhaRecebida);

        // verifica se a query retorna algo. Se não ser vazio, o if é executado
        if (!usuarioAdvancedUse.isEmpty()) {
            Integer agencia = usuarioAdvancedUse.get(0).getFkAgencia();
            // Chama um método para verificar se o caixa consiste com a agencia do usuario
             if(VerificaCaixa(agencia)){
                 return usuarioAdvancedUse;
             } else{
                 usuarioAdvancedUse.clear();
             }
        }

        return usuarioAdvancedUse;

    }

    private Boolean VerificaCaixa(Integer idAgencia) {

        List<Maquina> caixaConsultaAgencia = con.query("SELECT * FROM maquina m WHERE m.idMaquina = ? AND m.status = 'ativo'", new BeanPropertyRowMapper(Maquina.class), this.codigoRecebido);

        // se a query retornar vazia, o acesso é negado (EX: se o caixa não existe no banco)
        if (caixaConsultaAgencia.isEmpty()) {
            System.out.println("caixa inativo ou inesistente");
            return false;
        }

        Integer agenciaDoCaixa = caixaConsultaAgencia.get(0).getFkAgencia();

        if (Objects.equals(agenciaDoCaixa, idAgencia)) {
            System.out.println("Caixa verificado com sucesso!");
            return true;
        }

        System.out.println("Verificação do caixa falhou...");
        return false;

    }

}
