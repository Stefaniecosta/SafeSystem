/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.safesystem.view;

import br.com.bandtec.safesystem.src.Timer;
import br.com.bandtec.safesystem.src.models.Usuario;
import br.com.bandtec.safesystem.usb.DispositivoUsb;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.util.Conversor;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class TelaDeRelatorio extends javax.swing.JFrame {

    Looca looca = new Looca();
    Timer timer = new Timer();
    DispositivoUsb dis = new DispositivoUsb();
    List<Usuario> listaInfos = new ArrayList();

    /**
     * Creates new form TelaDeRelatorio
     * @param lista
     */
    public TelaDeRelatorio(List<Usuario> lista) {
        initComponents();
        
        listaInfos.add(lista.get(0));
        
        System.out.println(listaInfos.get(0).getEmail());
        
        // Inicia o looping de enviar dados
        
        timer.repeticao(listaInfos.get(0).getIdUsuario());
        plot();
        
        timer.repeticaoUsb(listaInfos.get(0).getIdUsuario());
        plot();


       
        
  

    }

    public final void plot() {
//        new java.util.Timer().scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//                String ramTaotal = Conversor.formatarBytes(looca.getMemoria().getTotal());
//                lblRamTotal.setText(ramTaotal);
//                String ramUso = Conversor.formatarBytes(looca.getMemoria().getEmUso());
//                lblRamUso.setText(ramUso);
//                lblProcessador.setText(looca.getProcessador().getNome());
//                String hdTrunc = Conversor.formatarBytes(looca.getGrupoDeDiscos().getTamanhoTotal());
//                lblHd.setText(String.format(hdTrunc));
//                lblCpuFisica.setText(looca.getProcessador().getNumeroCpusFisicas().toString());
//                lblCpuLogica.setText(looca.getProcessador().getNumeroCpusLogicas().toString());
//                String frequencia = Conversor.formatarBytes(looca.getProcessador().getFrequencia());
//                String auxFrequencia = frequencia.replace("GiB", "GHz");
//                String strFrequencia = String.format("%s", auxFrequencia);
//                lblFrequencia.setText(strFrequencia);
//                String so = looca.getSistema().getSistemaOperacional();
//                Integer arq = looca.getSistema().getArquitetura();
//                String fabricante = looca.getSistema().getFabricante();
//                lblSistemaOperacional.setText(String.format("%s %s %d bits", fabricante, so, arq));
//
//                //DADOS DE UTILIZAÇÃO
//                Double usoTrunc = (looca.getProcessador().getUso());
//                lblPorcentagemDeUso.setText(String.format("%.2f%%", usoTrunc));
//                lblNumeroProcessos.setText(looca.getGrupoDeProcessos().getTotalProcessos().toString());
//                lblThreads.setText(looca.getGrupoDeProcessos().getTotalProcessos().toString());
//            }
//        }, 0, 2000);
        //DADOS DA MÁQUINA

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSair = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SafeSystem");
        setAutoRequestFocus(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1500, 2000));
        setPreferredSize(new java.awt.Dimension(1200, 800));

        jPanel1.setBackground(new java.awt.Color(0, 13, 0));

        btnSair.setBackground(new java.awt.Color(214, 69, 80));
        btnSair.setFont(new java.awt.Font("Mukti Narrow", 1, 24)); // NOI18N
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setText("Sair");
        btnSair.setBorderPainted(false);
        btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSairMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSairMouseExited(evt);
            }
        });
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Yrsa Light", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(175, 255, 195));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Os dados estão sendo capturados");
        lblTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 317, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(203, 203, 203))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnSairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseExited
        // TODO add your handling code here:
        //btnSair.setBackground(new Color(214, 69, 80));
        //btnSair.setForeground(new Color(235, 235, 235));
    }//GEN-LAST:event_btnSairMouseExited

    private void btnSairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseEntered
        // TODO add your handling code here:
        //btnSair.setBackground(new Color(235, 235, 235));
        //btnSair.setForeground(new Color(214, 69, 80));
    }//GEN-LAST:event_btnSairMouseEntered

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
