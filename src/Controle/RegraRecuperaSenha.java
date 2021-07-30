

 package Controle;

import Modelo.Usuario;
import Modelo.UsuarioDao;
import Visao.TelaRecuperaSenha;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.JPasswordField;




     public class RegraRecuperaSenha {
         
        private final TelaRecuperaSenha TRS;
        private UsuarioDao UD;

    RegraRecuperaSenha(TelaRecuperaSenha TU1) {
       
        this.TRS = TU1;
        this.UD = new UsuarioDao();
        
        
    }
    
    public void RecuperaSenha() throws SQLException{
    
       
        
        UsuarioDao UD = new UsuarioDao();
        Usuario U = new Usuario();
        
        String receConfirSenha;
       
         U.setSenha(TRS.getCamposenha().getText());
         
         receConfirSenha = TRS.getCamponovasenha().getText();  
         
         JPasswordField password = new JPasswordField();
         password.setEchoChar('*');
        JOptionPane.showMessageDialog(null,password,"DIGITE A SENHA ADMIN: ",WARNING_MESSAGE);
          
        
          String senhaAdmin = String.valueOf(password.getPassword());
          
         
          
         if(receConfirSenha.equals(U.getSenha())){
         
             if(senhaAdmin.equals(UD.senhaAdmin())){
             
                 
                 
              UD.RecuperaSenha(U);
              
              ControleLogin CL = new ControleLogin();
             
             }else{
                 
              
                 JOptionPane.showMessageDialog(null,"SENHA INEXISTENTE \n VERIFIQUE","ALERTA DE CONFIRMAÇÃO:",ERROR_MESSAGE);
                 
             }
             
             
         
         }else{
         
             JOptionPane.showMessageDialog(null,"DADOS INCORRETO! \n VERIFIQUE","ALERTA DE CONFIRMAÇÃO:",ERROR_MESSAGE);
         
         }
        
            
               
                    
               
             
    
    
    
    
}
    
  
    
     }
