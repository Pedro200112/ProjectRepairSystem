
package Controle;

import Visao.TelaRecuperaSenha;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;



   public class ControleRecuperaSenha implements ActionListener{

       private final TelaRecuperaSenha TRS;
       private final RegraRecuperaSenha RRS;
   

    public ControleRecuperaSenha() {
       
        this.TRS = new TelaRecuperaSenha(null, true);
        this.RRS = new RegraRecuperaSenha(TRS);
        
        addListerners();
        
        this.TRS.setVisible(true);
        
        
    }
   
    private void addListerners() {
        
        this.TRS.getConfirmar().addActionListener(this);
        this.TRS.getBotonSair().addActionListener(this);
    
       
        
        
       
    }
    
        
    @Override
    public void actionPerformed(ActionEvent var) {
        
       
            if(var.getSource().equals(this.TRS.getConfirmar())){
            
                try {
                    
                        
                       this.RRS.RecuperaSenha();
                    
                    
                    
                } catch (Exception e) {
                    
                     JOptionPane.showMessageDialog(null,"DADOS INCORRETOS \n VERIFIQUE","ALERTA DE CADASTRO",ERROR_MESSAGE);
                    
                }
            
            }
            
            if(var.getSource().equals(this.TRS.getBotonSair())){
            
                try {
                    
                    
                   ControleLogin CL = new ControleLogin();
                   
                   TRS.dispose();
                    
                } catch (Exception e) {
                    
                     JOptionPane.showMessageDialog(null,"ERROR","XXXX",ERROR_MESSAGE);
                    
                }
            
            }
            
          
        
    }
       
       
       
}
