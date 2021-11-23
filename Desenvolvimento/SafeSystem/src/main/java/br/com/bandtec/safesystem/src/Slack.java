/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.safesystem.src;

import br.com.bandtec.safesystem.src.models.Agencia;
import br.com.bandtec.safesystem.src.models.RegistroMaquina;
import br.com.bandtec.safesystem.src.models.Usuario;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author Bruno
 */
public class Slack {

    private static final HttpClient client = HttpClient.newHttpClient();
    public static String URL;

    private ConexaoBD config;
    private JdbcTemplate con;

    private final Integer idAgencia;

    public Slack(Integer fkAgencia) {
        this.idAgencia = fkAgencia;
        this.URL = recuperarWebHook(idAgencia);

        this.verificarURL(URL);
        System.out.println(URL);
    }

    public static void sendMessage(JSONObject content) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder(
                URI.create(URL))
                .header("accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(content.toString()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(String.format("Status: %s", response.statusCode()));
        System.out.println(String.format("Response: %s", response.body()));
    }

    public static void enviarRelatorio(Integer fkAgencia) throws IOException, InterruptedException {

        // Necessita da fkAgencia para fazer o select no banco
        // O objeto Relatorio retorna uma string com o relarorio montado
        Relatorio relatorio = new Relatorio(fkAgencia);

        //Tranforma o relatorio em JSON para a API SLACK
        JSONObject json = new JSONObject();
        json.put("text", relatorio.novoRegistro());

        Slack.sendMessage(json);
    }

    public Slack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void alertaDispositivo(Integer idCaixa, String hora) {

        try {

            JSONObject json = new JSONObject();

            // Monta a mensagem que será enviada pelo Slack
            String alerta = String.format(":skull::rotating_light: ALERTA! DISPOSITIVO ESTRANHO DETECTADO! :rotating_light::skull: \n\n"
                    + "Foi detectado um dispositivo estranho em um de seus caixas! \n"
                    + "Caixa: %d \n"
                    + "Horario: %s \n", idCaixa, hora);

            //Tranforma o alerta em JSON para a API SLACK
            json.put("text", alerta);

            Slack.sendMessage(json);

        } catch (IOException e) {
            System.out.println("Falha ao enviar alerta de dispositivo estranho ao Slack");
            System.out.println(e.getMessage());
            Log log = new Log(e.getMessage(), "Falha ao enviar alerta de dispositivo estranho ao Slack");

        } catch (InterruptedException ex) {
            Logger.getLogger(Slack.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alertaMapeamento(Integer idUsuario, Integer idCaixa, String hora) {

        try {

            //chama metodo que faz select do nome do usuario
            String nomeUsuario = recuperaNomeDeUsuario(idUsuario);

            JSONObject json = new JSONObject();

            // Monta a mensagem que será enviada pelo Slack
            String alerta = String.format(":warning: Atenção: Mapeamento de dispositivos! :warning: \n"
                    + "Foram mapeados(atualizados) os dispositivos padrão de um dos caixas. \n"
                    + "Resposável: %s \n"
                    + "Caixa: %d \n"
                    + "Horario: %s \n", nomeUsuario, idCaixa, hora);

            //Tranforma o alerta em JSON para a API SLACK
            json.put("text", alerta);

            Slack.sendMessage(json);

        } catch (IOException e) {
            System.out.println("Falha ao enviar alerta de mapeamento de dispositivos ao Slack");
            System.out.println(e.getMessage());
            Log log = new Log(e.getMessage(), "Falha ao enviar alerta de mapeamento de dispositivos ao Slack");

        } catch (InterruptedException ex) {
            Logger.getLogger(Slack.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String recuperaNomeDeUsuario(Integer idUsuario) {
        try {
            //Tentativa de conexão com o BD
            this.config = new ConexaoBD();
            this.con = new JdbcTemplate(config.getBancoDeDados());

        } catch (Exception e) {
            System.out.println("Falha ao conectar com o banco de dados");
            System.out.println(e.getMessage());
        }

        List<Usuario> listaUsuarios = con.query(""
                + "SELECT * FROM usuario "
                + "WHERE idUsuario = ? ",
                new BeanPropertyRowMapper(Usuario.class), idUsuario);

        String nome = "";
        for (Usuario usuario : listaUsuarios) {
            nome = usuario.getNome();
        }
        return nome;
    }

    private String recuperarWebHook(Integer idAgencia) {
        try {
            //Tentativa de conexão com o BD
            this.config = new ConexaoBD();
            this.con = new JdbcTemplate(config.getBancoDeDados());

        } catch (Exception e) {
            System.out.println("Falha ao conectar com o banco de dados");
            System.out.println(e.getMessage());
        }

        List<Agencia> listaAgencia = con.query(""
                + "SELECT * FROM agencia "
                + "WHERE idAgencia = ? ",
                new BeanPropertyRowMapper(Agencia.class), idAgencia);

        String url = "aa";
        for (Agencia agencia : listaAgencia) {
            url = agencia.getSlackWebHook();
        }
        return url;
    }

    private void verificarURL(String URL) {

        if (URL == null) {
            System.out.println("Falha: Agência sem URL Slack WebHook cadastrada.");
            Log log = new Log("Agência sem URL Slack WebHook cadastrada.");
        } else if (URL.isBlank()) {
            System.out.println("Falha: URL em branco");
            Log log = new Log("URL Slack WebHook da agencia em branco.");
        }

    }

}
