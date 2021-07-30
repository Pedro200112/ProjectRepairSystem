

package Visao;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class TelaAddRelatorio extends javax.swing.JFrame {

    
    public TelaAddRelatorio(Object object, boolean b) {
       
        
        initComponents();
        
          this.setLocationRelativeTo(null);
          
          this.setResizable(false);
        
    }

    public JButton getBotaoAnexar() {
        return BotaoAnexar;
    }

    public JButton getBotaoExcluir() {
        return BotaoExcluir;
    }
    

    public JTextField getCompoentestroca() {
        return Compoentestroca;
    }

    public JTextField getEquipamentosreparados() {
        return Equipamentosreparados;
    }

    public JTextField getNderelatorio() {
        return Nderelatorio;
    }

    public JTextField getProblema() {
        return Problema;
    }

    public JTextField getSolucao() {
        return Solucao;
    }

    public JTextField getCpfvalido() {
        return cpfvalido;
    }

    public JTextField getEmpresasolicitante() {
        return empresasolicitante;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JTextField getNometecnico() {
        return nometecnico;
    }

    public JFormattedTextField getData() {
        return data;
    }
    

    public JButton getBotonSair() {
        return BotonSair;
    }
    
    

   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BotonSair = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Problema = new javax.swing.JTextField();
        empresasolicitante = new javax.swing.JTextField();
        Solucao = new javax.swing.JTextField();
        cpfvalido = new javax.swing.JFormattedTextField();
        nometecnico = new javax.swing.JTextField();
        Nderelatorio = new javax.swing.JTextField();
        Equipamentosreparados = new javax.swing.JTextField();
        Compoentestroca = new javax.swing.JTextField();
        BotaoAnexar = new javax.swing.JButton();
        BotaoExcluir = new javax.swing.JButton();
        data = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nº do Relatório:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        BotonSair.setBackground(new java.awt.Color(255, 255, 255));
        BotonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/voltar.png"))); // NOI18N
        BotonSair.setBorder(null);
        jPanel3.add(BotonSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Data:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Equipamentos reparados:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));

        jLabel4.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Problema identificado:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, -1));

        jLabel5.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Nome do técnico:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Empresa solicitante:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, -1, -1));

        jLabel7.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Componentes trocados:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 184, -1, -1));

        jLabel8.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Solução adotada:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, -1, -1));

        Problema.setBackground(new java.awt.Color(255, 255, 255));
        Problema.setForeground(new java.awt.Color(0, 0, 0));
        Problema.setToolTipText("");
        jPanel3.add(Problema, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 290, 36));

        empresasolicitante.setBackground(new java.awt.Color(255, 255, 255));
        empresasolicitante.setForeground(new java.awt.Color(0, 0, 0));
        empresasolicitante.setToolTipText("");
        jPanel3.add(empresasolicitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 290, 30));

        Solucao.setBackground(new java.awt.Color(255, 255, 255));
        Solucao.setForeground(new java.awt.Color(0, 0, 0));
        Solucao.setToolTipText("");
        Solucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SolucaoActionPerformed(evt);
            }
        });
        jPanel3.add(Solucao, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, 290, 80));

        cpfvalido.setBackground(new java.awt.Color(255, 255, 255));
        cpfvalido.setForeground(new java.awt.Color(0, 0, 0));
        try {
            cpfvalido.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel3.add(cpfvalido, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 290, 30));

        nometecnico.setBackground(new java.awt.Color(255, 255, 255));
        nometecnico.setForeground(new java.awt.Color(0, 0, 0));
        nometecnico.setToolTipText("");
        jPanel3.add(nometecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 290, 30));

        Nderelatorio.setBackground(new java.awt.Color(255, 255, 255));
        Nderelatorio.setForeground(new java.awt.Color(0, 0, 0));
        Nderelatorio.setToolTipText("");
        jPanel3.add(Nderelatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 290, 30));

        Equipamentosreparados.setBackground(new java.awt.Color(255, 255, 255));
        Equipamentosreparados.setForeground(new java.awt.Color(0, 0, 0));
        Equipamentosreparados.setToolTipText("");
        Equipamentosreparados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EquipamentosreparadosActionPerformed(evt);
            }
        });
        jPanel3.add(Equipamentosreparados, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 290, 80));

        Compoentestroca.setBackground(new java.awt.Color(255, 255, 255));
        Compoentestroca.setForeground(new java.awt.Color(0, 0, 0));
        Compoentestroca.setToolTipText("");
        jPanel3.add(Compoentestroca, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, 290, 80));

        BotaoAnexar.setBackground(new java.awt.Color(255, 255, 255));
        BotaoAnexar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/anexar30.png"))); // NOI18N
        BotaoAnexar.setBorder(null);
        jPanel3.add(BotaoAnexar, new org.netbeans.lib.awtextra.AbsoluteConstraints(714, 447, -1, -1));

        BotaoExcluir.setBackground(new java.awt.Color(255, 255, 255));
        BotaoExcluir.setForeground(new java.awt.Color(0, 0, 0));
        BotaoExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/removerUser30.png"))); // NOI18N
        BotaoExcluir.setBorder(null);
        jPanel3.add(BotaoExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(672, 447, -1, -1));

        data.setBackground(new java.awt.Color(255, 255, 255));
        data.setForeground(new java.awt.Color(0, 0, 0));
        try {
            data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel3.add(data, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 290, 30));

        jLabel9.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("CPF do Técnico:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EquipamentosreparadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EquipamentosreparadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EquipamentosreparadosActionPerformed

    private void SolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SolucaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SolucaoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaAddRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAddRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAddRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAddRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              
                System.exit(0);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoAnexar;
    private javax.swing.JButton BotaoExcluir;
    private javax.swing.JButton BotonSair;
    private javax.swing.JTextField Compoentestroca;
    private javax.swing.JTextField Equipamentosreparados;
    private javax.swing.JTextField Nderelatorio;
    private javax.swing.JTextField Problema;
    private javax.swing.JTextField Solucao;
    private javax.swing.JFormattedTextField cpfvalido;
    private javax.swing.JFormattedTextField data;
    private javax.swing.JTextField empresasolicitante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField nometecnico;
    // End of variables declaration//GEN-END:variables

    public void limpar() {
        Nderelatorio.setText("");
        cpfvalido.setText("");
        data.setText("");
        Equipamentosreparados.setText("");
        Problema.setText("");
        empresasolicitante.setText("");
        Compoentestroca.setText("");
        Solucao.setText("");
    }
}
