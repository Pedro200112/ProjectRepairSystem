
package Visao;

import javax.swing.JButton;
import javax.swing.JLabel;


public class TelaVendedor extends javax.swing.JFrame {

    
    public TelaVendedor(java.awt.Frame parent, boolean modal) {
        
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        this.setResizable(false);
    }

    public TelaVendedor(Object object, boolean b) {
       
        
    }

    public JButton getBotonContratos() {
        return BotonContratos;
    }

    public void setBotonContratos(JButton BotonContratos) {
        this.BotonContratos = BotonContratos;
    }

    public JButton getBotonEquipamento() {
        return BotonEquipamento;
    }

    public void setBotonEquipamento(JButton BotonEquipamento) {
        this.BotonEquipamento = BotonEquipamento;
    }

    public JButton getBotonSair() {
        return BotonSair;
    }

    public void setBotonSair(JButton BotonSair) {
        this.BotonSair = BotonSair;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

  
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        BotonSair = new javax.swing.JButton();
        BotonEquipamento = new javax.swing.JButton();
        BotonContratos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));

        BotonSair.setBackground(new java.awt.Color(255, 255, 255));
        BotonSair.setForeground(new java.awt.Color(0, 0, 0));
        BotonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Engrenagem20.png"))); // NOI18N
        BotonSair.setText("Fazer Logout");
        BotonSair.setBorder(null);

        BotonEquipamento.setBackground(new java.awt.Color(255, 255, 255));
        BotonEquipamento.setForeground(new java.awt.Color(0, 0, 0));
        BotonEquipamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Equipamento100.png"))); // NOI18N
        BotonEquipamento.setBorder(null);

        BotonContratos.setBackground(new java.awt.Color(255, 255, 255));
        BotonContratos.setForeground(new java.awt.Color(0, 0, 0));
        BotonContratos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Contrato.png"))); // NOI18N
        BotonContratos.setBorder(null);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/administrador50.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Vendedor");

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
                        .addComponent(BotonEquipamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(BotonContratos)
                        .addGap(262, 262, 262)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(381, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(BotonSair)
                        .addGap(18, 18, 18)
                        .addComponent(BotonEquipamento)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BotonContratos))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addContainerGap(210, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    public static void main(String args[]) {
     
    

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              
                System.exit(0);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonContratos;
    private javax.swing.JButton BotonEquipamento;
    private javax.swing.JButton BotonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
