

package Controle;

import Visao.TelaAtendente;
import Visao.TelaCadastroChamado;
import Visao.TelaChamado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;


public class ControleMostraChamado  implements ActionListener{

    
    private final TelaChamado TC;
    private final TelaCadastroChamado TCC;
    private final RegraMostraChamado RMC;
  
   
    public ControleMostraChamado() {
        
         this.TC = new TelaChamado(null, true);
         this.TCC = new TelaCadastroChamado(null,true);
         this.RMC = new RegraMostraChamado(TC,TCC);
        
      
        addListerners();
        RMC.listar();
        this.TC.setVisible(true);

    }
    
    public void addListerners(){
    
        this.TC.getBotonAbrir().addActionListener(this);
        this.TC.getBotonDetalhes().addActionListener(this);
        this.TC.getBotonPesquisar().addActionListener(this);
        this.TC.getBotonSair().addActionListener(this);
       
    }
    
     @Override
    public void actionPerformed(ActionEvent var) {
        
        
        if(var.getSource().equals(this.TC.getBotonAbrir())){
        
          ControleChamado CC = new ControleChamado();
          
          this.TC.dispose();
        
        } else if(var.getSource().equals(this.TC.getBotonDetalhes())){
        
          this.RMC.detalhes();
                     
          this.TC.dispose();
        
        }  else if(var.getSource().equals(this.TC.getBotonPesquisar())){
        
            this.RMC.pesquisar();
           //JOptionPane.showMessageDialog(null,"AINDA NÃO HÁ AÇÕES AQUI!", "INFORMAÇÃO: ",WARNING_MESSAGE);
        
        
        } else if(var.getSource().equals(this.TC.getBotonSair())){
        
            String rece = null;
          
             try {
                 
                 rece = this.RMC.procuraLogin();
                 
                 if(rece.equals("Admnistrador")){
       
          ControlePrincipal CP = new ControlePrincipal();
       
           this.TC.dispose();
           
       }else if(rece.equals("Atendente")){
       
          ControleAtendente CA = new ControleAtendente();
       
           this.TC.dispose();
           
       }else if(rece.equals("Supervisor")){
       
          ControleSupervisor CS = new ControleSupervisor();
       
           this.TC.dispose();
           
       }else if(rece.equals("Tecnico")){
       
           ControleTecnico CT = new ControleTecnico();
       
            this.TC.dispose();
            
       }else if(rece.equals("Vendedor")){
       
          ControleVendedor CV = new ControleVendedor();
       
           this.TC.dispose();
           
       }
                
                TC.dispose();
                 
             } catch (Exception ex) {
                 
                 JOptionPane.showMessageDialog(null,"ERRO","XXXX",ERROR_MESSAGE);
             }
        
        }
        }
         
        
          }

    
    
    

