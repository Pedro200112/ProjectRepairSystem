
package Controle;

import Visao.TelaLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;


public class ControleLogin implements ActionListener{
    
    //Cria uma variável Tela Login e uma variável Regra de Login
    private final TelaLogin TL;
    private final RegraLogin RL;
    
   
    
    public ControleLogin(){
        
        //Chama a variável Login e seta com true
        this.TL = new TelaLogin(null, true);
        
        //Seta a Regra Login com o parâmetro da Rela Login
        this.RL = new RegraLogin(TL);
        
        //Adicionamento dos componentes da tela
        addListerners();
        
        //Chamamento da tela Login
        this.TL.setVisible(true);
        
        //Limpa a tabela Login
        this.RL.truncateLogin();

        
    }
    
    public void addListerners(){
    
      
        //Seta os componentes da tela
        this.TL.getBotonEnviar().addActionListener(this);
        this.TL.getBotonEsqueceuSenha().addActionListener(this);
   
    
    }
    
    

    @Override
    public void actionPerformed(ActionEvent var) {
       
        
        
        if(var.getSource().equals(this.TL.getBotonEnviar())){
        
            try {
               
                
                //Chama o método acesso da Regra Login
                this.RL.acesso();
                
                this.TL.dispose();
                
               
                            
                
                
            } catch (SQLException ex) {
                
                JOptionPane.showMessageDialog(null,"ERRO","ALERTA",ERROR_MESSAGE);
                
            }
        
        }
        
        
        if(var.getSource().equals(this.TL.getBotonEsqueceuSenha())){
        
               try {
                
              ControleRecuperaSenha CRS = new ControleRecuperaSenha();
              
              this.TL.dispose();
                
                
            } catch (Exception e) {
                
                 JOptionPane.showMessageDialog(null,"ERRO","XXXX",ERROR_MESSAGE);
                
            }
        
        
        }
        
    
        
    }
    
    
    
}
