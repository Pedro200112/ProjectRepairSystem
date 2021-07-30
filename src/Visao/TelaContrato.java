
package Visao;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class TelaContrato extends javax.swing.JFrame {

    private final DefaultTableModel modelo; 
    
    public TelaContrato(Object object, boolean b) {
        
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        this.setResizable(false);
        
         this.modelo = (DefaultTableModel)TabelaContrato.getModel();
        
    }
    public DefaultTableModel getModelo() {
        return modelo;
    }

    
     public void limpaTabela(){
        int linhas = this.modelo.getRowCount();
        for(int i=0;i<linhas;i++){
            this.modelo.removeRow(0);
        }
    }
     
      public void adicionaItem(Object... objects){
        this.modelo.addRow(objects);
    }


    public JButton getBotaoDetalhes() {
        return BotaoDetalhes;
    }

    public JButton getBotaonovocontrato() {
        return Botaonovocontrato;
    }

    public JButton getBotaopesquisa() {
        return Botaopesquisa;
    }
    public JTable getTabelaContrato() {
        return TabelaContrato;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JButton getBotonSair() {
        return BotonSair;
    }

    public JTextField getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(JTextField pesquisa) {
        this.pesquisa = pesquisa;
    }
    
    
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pesquisa = new javax.swing.JTextField();
        Botaopesquisa = new javax.swing.JButton();
        BotonSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaContrato = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        Botaonovocontrato = new javax.swing.JButton();
        BotaoDetalhes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Número Sequencial:");

        pesquisa.setBackground(new java.awt.Color(255, 255, 255));
        pesquisa.setForeground(new java.awt.Color(0, 0, 0));

        Botaopesquisa.setBackground(new java.awt.Color(255, 255, 255));
        Botaopesquisa.setForeground(new java.awt.Color(0, 0, 0));
        Botaopesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search15.png"))); // NOI18N

        BotonSair.setBackground(new java.awt.Color(255, 255, 255));
        BotonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/voltar.png"))); // NOI18N
        BotonSair.setBorder(null);

        TabelaContrato.setBackground(new java.awt.Color(255, 255, 255));
        TabelaContrato.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TabelaContrato.setForeground(new java.awt.Color(0, 0, 0));
        TabelaContrato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº Sequencial", "Cliente", "Valor Contrato"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TabelaContrato);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Logo-1P.png"))); // NOI18N

        Botaonovocontrato.setBackground(new java.awt.Color(255, 255, 255));
        Botaonovocontrato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addUser30.png"))); // NOI18N
        Botaonovocontrato.setBorder(null);

        BotaoDetalhes.setBackground(new java.awt.Color(255, 255, 255));
        BotaoDetalhes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/detalhes30.png"))); // NOI18N
        BotaoDetalhes.setBorder(null);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BotonSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 60, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Botaopesquisa)
                            .addGap(511, 511, 511))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addGap(40, 40, 40)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(Botaonovocontrato)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BotaoDetalhes))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(BotonSair)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Botaopesquisa))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotaoDetalhes, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Botaonovocontrato, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

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
            java.util.logging.Logger.getLogger(TelaContrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaContrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaContrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaContrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton BotaoDetalhes;
    private javax.swing.JButton Botaonovocontrato;
    private javax.swing.JButton Botaopesquisa;
    private javax.swing.JButton BotonSair;
    private javax.swing.JTable TabelaContrato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField pesquisa;
    // End of variables declaration//GEN-END:variables
}
