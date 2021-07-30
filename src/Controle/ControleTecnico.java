
package Controle;

import Visao.TelaTecnico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class ControleTecnico  implements ActionListener{
    
    private final TelaTecnico TT;
    private final RegraTecnico RT;

    

    public ControleTecnico() {
        
         this.TT = new TelaTecnico(null, true);
         this.RT = new RegraTecnico(TT);
        
      
        addListerners();
        
        this.TT.setVisible(true);
        
    }
    
    public void addListerners(){
    
       this.TT.getBotaoSair().addActionListener(this);
       this.TT.getBotonChamado().addActionListener(this);
       this.TT.getBotaoEquipamento().addActionListener(this);
       this.TT.getBotonRelatorios().addActionListener(this);
    
    }
    
    @Override
    public void actionPerformed(ActionEvent var) {
     
        
        if(var.getSource().equals(this.TT.getBotaoSair())){
       
           
            try {
                
                
                ControleLogin CL = new ControleLogin();
                
                this.TT.dispose();
                
            } catch (Exception e) {
                
                 JOptionPane.showMessageDialog(null,"ERRO","ALERTA",ERROR_MESSAGE);
                
            }
            
            }
        if(var.getSource().equals(this.TT.getBotonChamado())){
       
           
            try {
                
                
                ControleMostraChamado CC = new ControleMostraChamado();
                
                this.TT.dispose();
                
            } catch (Exception e) {
                
                 JOptionPane.showMessageDialog(null,"ERRO","ALERTA",ERROR_MESSAGE);
                
            }
            
            }
        if(var.getSource().equals(this.TT.getBotaoEquipamento())){
       
           
            try {
                
                
                ControleMostraEquipamento CEE = new ControleMostraEquipamento();
                
                this.TT.dispose();
                
            } catch (Exception e) {
                
                 JOptionPane.showMessageDialog(null,"ERRO","ALERTA",ERROR_MESSAGE);
                
            }
            
            }
        
        if(var.getSource().equals(this.TT.getBotonRelatorios())){
       
           
            try {
                
                
                ControleMostraRelatorio CMR = new ControleMostraRelatorio();
                
                this.TT.dispose();
                
            } catch (Exception e) {
                
                 JOptionPane.showMessageDialog(null,"ERRO","ALERTA",ERROR_MESSAGE);
                
            }
            
            }
        
    }
    
    
    
}
