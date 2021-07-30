
package Visao;

import Controle.ControleLogin;
import javax.swing.JButton;


public class TelaPrincipal extends javax.swing.JFrame {

    

    public TelaPrincipal(Object object, boolean b) {
       
         initComponents();
        
        this.setLocationRelativeTo(null);
        
        this.setResizable(false);
        
      
        
        
    }

    public JButton getBotonSair() {
        return BotonSair;
    }

    public JButton getBotonCadastro() {
        return BotonCadastro;
    }

    public JButton getBotonContratos() {
        return BotonContratos;
    }

    public JButton getBotonEquipamento() {
        return BotonEquipamento;
    }

    public JButton getBotonFuncionaios() {
        return BotonFuncionaios;
    }

    public JButton getBotonRelatorios() {
        return BotonRelatorios;
    }

    
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        BotonSair = new javax.swing.JButton();
        BotonFuncionaios = new javax.swing.JButton();
        BotonCadastro = new javax.swing.JButton();
        BotonEquipamento = new javax.swing.JButton();
        BotonContratos = new javax.swing.JButton();
        BotonRelatorios = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));

        BotonSair.setBackground(new java.awt.Color(255, 255, 255));
        BotonSair.setForeground(new java.awt.Color(0, 0, 0));
        BotonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Engrenagem20.png"))); // NOI18N
        BotonSair.setText("Fazer Logout");
        BotonSair.setBorder(null);

        BotonFuncionaios.setBackground(new java.awt.Color(255, 255, 255));
        BotonFuncionaios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Funcionários100.png"))); // NOI18N
        BotonFuncionaios.setBorder(null);

        BotonCadastro.setBackground(new java.awt.Color(255, 255, 255));
        BotonCadastro.setForeground(new java.awt.Color(0, 0, 0));
        BotonCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Chamado100.png"))); // NOI18N
        BotonCadastro.setToolTipText("");
        BotonCadastro.setAutoscrolls(true);
        BotonCadastro.setBorder(null);

        BotonEquipamento.setBackground(new java.awt.Color(255, 255, 255));
        BotonEquipamento.setForeground(new java.awt.Color(0, 0, 0));
        BotonEquipamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Equipamento100.png"))); // NOI18N
        BotonEquipamento.setBorder(null);

        BotonContratos.setBackground(new java.awt.Color(255, 255, 255));
        BotonContratos.setForeground(new java.awt.Color(0, 0, 0));
        BotonContratos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Contrato.png"))); // NOI18N
        BotonContratos.setBorder(null);

        BotonRelatorios.setBackground(new java.awt.Color(255, 255, 255));
        BotonRelatorios.setForeground(new java.awt.Color(0, 0, 0));
        BotonRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Relatorio.png"))); // NOI18N
        BotonRelatorios.setBorder(null);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/administrador50.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Administrador");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Logo-1300.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(BotonSair)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(BotonFuncionaios)
                        .addGap(18, 18, 18)
                        .addComponent(BotonRelatorios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(23, 23, 23))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addContainerGap())))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BotonCadastro)
                                    .addComponent(BotonEquipamento))
                                .addGap(262, 262, 262)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BotonContratos))
                        .addContainerGap(380, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(BotonSair)
                                .addGap(18, 18, 18)
                                .addComponent(BotonFuncionaios))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(BotonRelatorios)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotonCadastro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BotonEquipamento))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addGap(12, 12, 12)
                .addComponent(BotonContratos)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCadastro;
    private javax.swing.JButton BotonContratos;
    private javax.swing.JButton BotonEquipamento;
    private javax.swing.JButton BotonFuncionaios;
    private javax.swing.JButton BotonRelatorios;
    private javax.swing.JButton BotonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
