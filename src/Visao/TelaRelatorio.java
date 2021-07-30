
package Visao;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class TelaRelatorio extends javax.swing.JFrame {
    
    private final DefaultTableModel modelo;

    public TelaRelatorio(Object object, boolean b) {  
        initComponents(); 
        this.setLocationRelativeTo(null);      
        this.setResizable(false);  
        this.modelo = (DefaultTableModel)TabelaRelatorio.getModel();
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


    public JButton getBotonAbrir() {
        return BotonAbrir;
    }

    public JButton getBotonDetalhes() {
        return BotonDetalhes;
    }

     public JButton getBotonPesquisar() {
        return BotonPesquisar;
    }

    public JTable getTabelarelatorio() {
        return TabelaRelatorio;
    }


    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JTextField getPesquisar() {
        return pesquisar;
    }

    public JButton getBotonSair() {
        return BotonSair;
    }

    public JTable getTabelaRelatorio() {
        return TabelaRelatorio;
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pesquisar = new javax.swing.JTextField();
        BotonPesquisar = new javax.swing.JButton();
        BotonSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaRelatorio = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        BotonAbrir = new javax.swing.JButton();
        BotonDetalhes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Número do Relatório:");

        pesquisar.setBackground(new java.awt.Color(255, 255, 255));
        pesquisar.setForeground(new java.awt.Color(0, 0, 0));

        BotonPesquisar.setBackground(new java.awt.Color(255, 255, 255));
        BotonPesquisar.setForeground(new java.awt.Color(0, 0, 0));
        BotonPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search15.png"))); // NOI18N

        BotonSair.setBackground(new java.awt.Color(255, 255, 255));
        BotonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/voltar.png"))); // NOI18N
        BotonSair.setBorder(null);

        TabelaRelatorio.setBackground(new java.awt.Color(255, 255, 255));
        TabelaRelatorio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TabelaRelatorio.setForeground(new java.awt.Color(0, 0, 0));
        TabelaRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº do Relatório", "Técnico"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TabelaRelatorio);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Logo-1P.png"))); // NOI18N

        BotonAbrir.setBackground(new java.awt.Color(255, 255, 255));
        BotonAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addUser30.png"))); // NOI18N
        BotonAbrir.setBorder(null);

        BotonDetalhes.setBackground(new java.awt.Color(255, 255, 255));
        BotonDetalhes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/detalhes30.png"))); // NOI18N
        BotonDetalhes.setBorder(null);
        BotonDetalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonDetalhesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BotonSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 65, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BotonPesquisar)
                            .addGap(511, 511, 511))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addGap(40, 40, 40)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(BotonAbrir)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(BotonDetalhes)
                            .addGap(9, 9, 9))
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
                    .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonPesquisar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotonDetalhes, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BotonAbrir, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonDetalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonDetalhesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonDetalhesActionPerformed

   
    
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
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton BotonAbrir;
    private javax.swing.JButton BotonDetalhes;
    private javax.swing.JButton BotonPesquisar;
    private javax.swing.JButton BotonSair;
    private javax.swing.JTable TabelaRelatorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField pesquisar;
    // End of variables declaration//GEN-END:variables
}
