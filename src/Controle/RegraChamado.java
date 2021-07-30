package Controle;

import Modelo.Chamado;
import Modelo.ChamadoDao;
import Modelo.Contrato;
import Modelo.ContratoDao;
import Modelo.LoginDao;
import Visao.TelaAtendente;
import Visao.TelaCadastraContrato;
import Visao.TelaCadastroChamado;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class RegraChamado {

    private final TelaCadastroChamado TCC;
    private ChamadoDao CD;
    private LoginDao LD;

    RegraChamado(TelaCadastroChamado TCC1) {

        this.TCC = TCC1;
        this.CD = new ChamadoDao();
        this.LD = new LoginDao();

    }

    public void AdicionaChamado() throws SQLException {

        if(validaCampos()){
        ChamadoDao CD = new ChamadoDao();
        Chamado C = new Chamado();

        
        try{
        
        C.setnChamado(Integer.parseInt(TCC.getnDoChamado1().getText()));
        C.setNomeEmpresa(TCC.getNomeDaEmpresa().getText());
        C.setIdEquipamento(Integer.parseInt(TCC.getIdDoEquipamento().getText()));
        C.setMotivoChamada(TCC.getMotivoDaChamada().getText());
        C.setDataentendimento((TCC.getDataDoAtendimento().getText()));
        

        CD.CriaChamado(C);
        
        }catch(Exception var){
       
                  JOptionPane.showMessageDialog(null, "Nº DE CHAMADO: NÚMEROS \n "
                   + "NOME EMPRESA: CARACTERES \n "
                   + "ID EQUIPAMENTO: NÚMEROS \n"
                   + "MOTIVO CHAMADA: CARACTERES \n "
                   + "DATA ATENDIMENTO: NÚMEROS \n"
                   ,"ALERTA: ", ERROR_MESSAGE);
       
       }
        
        
        }else{
            JOptionPane.showMessageDialog(null, "TODOS OS CAMPOS DEVEM SER PREENCHIDOS!", "ALERTA: ", JOptionPane.ERROR_MESSAGE);

        }

    }
    
    public void editar() throws SQLException{
              
           
            //FALTA O RADIO BUTTON
            
            
        ChamadoDao CD = new ChamadoDao();
        Chamado C = new Chamado();

        try{
        
        C.setnChamado(Integer.parseInt(TCC.getnDoChamado1().getText()));
        C.setNomeEmpresa(TCC.getNomeDaEmpresa().getText());
        C.setIdEquipamento(Integer.parseInt(TCC.getIdDoEquipamento().getText()));
        C.setMotivoChamada(TCC.getMotivoDaChamada().getText());
        C.setDataentendimento((TCC.getDataDoAtendimento().getText()));
        

        CD.editar(C);

           }catch(Exception var){
       
                  JOptionPane.showMessageDialog(null, "Nº DE CHAMADO: NÚMEROS \n "
                   + "NOME EMPRESA: CARACTERES \n "
                   + "ID EQUIPAMENTO: NÚMEROS \n"
                   + "MOTIVO CHAMADA: CARACTERES \n "
                   + "DATA ATENDIMENTO: NÚMEROS \n"
                   ,"ALERTA: ", ERROR_MESSAGE);
       
       }   
        
          
         
          
      }
    
     public void ExcluiChama() {
         
                int recenChamado = 0; 

                ChamadoDao CD = new ChamadoDao();
                Chamado C = new Chamado();       

                C.setnChamado((Integer.parseInt(TCC.getnDoChamado1().getText())));
               
                recenChamado = C.getnChamado();

                CD.excluir(recenChamado);   
               
       
    } 
 
    public String procuraLogin() throws SQLException {

        String passa = null;

        LoginDao LD = new LoginDao();

        passa = LD.procuraLogin();

        return passa;

    }
    
   
    
     public void limpar() {

        this.TCC.getDataDoAtendimento().setText("");
        this.TCC.getIdDoEquipamento().setText("");
        this.TCC.getMotivoDaChamada().setText("");
        this.TCC.getNomeDaEmpresa().setText("");
        this.TCC.getnDoChamado1().setText("");
        
        

    }
    
    public boolean validaCampos(){
        if(this.TCC.getnDoChamado1().getText().equals("")){
            return false;
        } 
        else if(this.TCC.getNomeDaEmpresa().getText().equals("")){
            return false;
        }
        else if(this.TCC.getMotivoDaChamada().getText().equals("")){
            return false;
        }
        else if(this.TCC.getIdDoEquipamento().getText().equals("")){
            return false;
        }
        else if(this.TCC.getDataDoAtendimento().getText().equals("")){
            return false;
        }
     return true;
    }
    
    
    
}
