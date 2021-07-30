
package Controle;

import Visao.TelaVendedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControleVendedor  implements ActionListener{

         private final TelaVendedor TV;
         private final RegraVendedor RV;

    public ControleVendedor() {
        
        this.TV = new TelaVendedor(null, true);
        this.RV = new RegraVendedor(TV);
        
      
        addListerners();
        
        this.TV.setVisible(true);
        
    }

  public void addListerners(){


        this.TV.getBotonContratos().addActionListener(this);
        this.TV.getBotonEquipamento().addActionListener(this);
        this.TV.getBotonSair().addActionListener(this);
       


}
  
   @Override
    public void actionPerformed(ActionEvent var) {
     
        if(var.getSource().equals(this.TV.getBotonSair())){
            
              ControleLogin CL = new ControleLogin();
              
              TV.dispose();
            
            }
            
            else if(var.getSource().equals(this.TV.getBotonContratos())){
            
               ControleMostraContrato CC = new ControleMostraContrato();
               
               TV.dispose();
                
            
            }
        
            else if((var.getSource().equals(this.TV.getBotonEquipamento()))){
            
                ControleMostraEquipamento CME = new ControleMostraEquipamento();
                
                TV.dispose();
            
            }
        
    }
    
    
    
}
