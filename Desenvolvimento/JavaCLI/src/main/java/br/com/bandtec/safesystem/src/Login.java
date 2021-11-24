/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.safesystem.src;

import br.com.bandtec.safesystem.src.Autenticacao;
import br.com.bandtec.safesystem.src.models.Usuario;
import br.com.bandtec.safesystem.usb.DispositivoUsb;
import br.com.bandtec.safesystem.view.TelaDeRelatorio;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class Login {

    public static void main(String[] args) {
        Scanner leituraNome = new Scanner(System.in);
        Scanner leituraSenha = new Scanner(System.in);
        Scanner leituraCaixa = new Scanner(System.in);

        System.out.println("Digite o código do caixa:");
        String caixa = leituraCaixa.nextLine();

        System.out.println("Digite seu email:");
        String email = leituraNome.nextLine();

        System.out.println("Digite sua senha:");
        String senha = leituraSenha.nextLine();

        Autenticacao autenticacao = new Autenticacao(email, senha, caixa);
        List<Usuario> resultadoAutenticacao = autenticacao.AutenticaUsuario();

        if (!resultadoAutenticacao.isEmpty()) {
            System.out.println("CONECTADO");
            Integer idCaixa = Integer.parseInt(caixa);

            Scanner leitor = new Scanner(System.in);
            System.out.println("Deseja remapear os dispositivos padrão do caixa?");
            if (leitor.nextLine().equals("sim")) {
                DispositivoUsb usb = new DispositivoUsb();
                Integer inserir = usb.InsereUsbTabelaPadrao();
                if (null == inserir) {
                    System.out.println("NENHUM USB CONECTADO");
                } else {
                    switch (inserir) {
                        case 1:
                            System.out.println("JÁ EXISTEM USB MAPEADOS");
                            break;
                        case 2:
                            System.out.println("OS USB FORAM MAPEADOS");
                            break;
                        default:
                            System.out.println("SEM NENHUM USB CONECTADO");
                            break;
                    }
                }
            }

            System.out.println("Deseja atualizar os componentes do caixa?");
            if (leitor.nextLine().equals("sim")) {
                String env = new EnviaDados().atualizarComponentesNoBanco(idCaixa);
                System.out.println(env);

            }
            
            System.out.println("Iniciando captura dos dados");
            
            Timer timer = new Timer();

            // Inicia o looping de enviar dados    
            timer.repeticao(resultadoAutenticacao.get(0).getIdUsuario());

            // Inicia o looping de captura de dispositivos    
            timer.repeticaoUsb(resultadoAutenticacao.get(0).getIdUsuario());
            
        } else {
            System.out.println("ACESSO NEGADO!");
        }

    }

}
