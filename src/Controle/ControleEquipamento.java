package Controle;

import Modelo.Equipamento;
import Modelo.Funcionario;
import Visao.TelaNovoEquipamento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;

public class ControleEquipamento implements ActionListener {

    private final TelaNovoEquipamento TNE;
    private final RegraEquipamento RE;
     private final RegraLogin RL = null;
    

    public ControleEquipamento() {

        this.TNE = new TelaNovoEquipamento(null, true);
        this.RE = new RegraEquipamento(TNE);

        addListerners();

        this.TNE.setVisible(true);
        
            TNE.getDatafabricacao().setEditable(true);
            TNE.getNcontrato().setEditable(true);
            TNE.getNdemanutencao().setEditable(true);
            TNE.getNdeserie().setEditable(true);
            TNE.getNomeequipamento().setEditable(true);
            TNE.getParcelasdepagamento().setEditable(true);
            TNE.getTipodeequipamento().setEditable(true);
            TNE.getValorassociado().setEditable(true);
           
    }

    public void addListerners() {
        
       
        this.TNE.getBotaoExcluir().addActionListener(this);
        this.TNE.getBotonSair().addActionListener(this);
        this.TNE.getBotaoAdicionar().addActionListener(this);
        this.TNE.getBotaoEdicao().addActionListener(this);
      

    }

    @Override
    public void actionPerformed(ActionEvent var) {
        
        if(var.getSource().equals(this.TNE.getBotaoAdicionar())){
        
            this.RE.AdicionaEquipamento();
            
        } else if (var.getSource().equals(this.TNE.getBotaoExcluir())) {
               if (RE.validarCampos()) {
                if (JOptionPane.showConfirmDialog(TNE, "Deseja realmente excluir?", "Confirmação de exclusão",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
                    this.RE.ExcluirEquip();
                    ControleMostraEquipamento CMF = new ControleMostraEquipamento();
                    this.TNE.dispose();
                }

            } else {
                JOptionPane.showMessageDialog(null, "REALIZE O CADASTRO DE ALGUM EQUIPAMENTO PRIMEIRO", "ALERTA: ", JOptionPane.ERROR_MESSAGE);
            }

        } else if(var.getSource().equals(this.TNE.getBotaoEdicao())){
        
            this.RE.editar();
        
        } else if(var.getSource().equals(this.TNE.getBotonSair())){
    
    
            //Ajuda ver quem fez o Login
            String rece = null;
            
            try {
                
                ControleMostraEquipamento CME = new ControleMostraEquipamento();
                
                this.TNE.dispose();
                
            } catch (Exception ex) {
                
                JOptionPane.showMessageDialog(null, "ERRO", "XXXX", ERROR_MESSAGE);
            }
    }

    }
    
    public void setDados(Equipamento e){
    
        this.TNE.limpar();
        
            TNE.getNdemanutencao().setText(String.valueOf(e.getnManutencao()));
            TNE.getNdeserie().setText(String.valueOf(e.getnSerie()));
            TNE.getDatafabricacao().setText(e.getAtaFabrica());
            TNE.getNcontrato().setText(String.valueOf(e.getnContrato()));
            TNE.getNomeequipamento().setText(e.getNomeEquipamento());
            TNE.getParcelasdepagamento().setText(String.valueOf(e.getParcelaPagamento()));
            TNE.getTipodeequipamento().setText(e.getTipoEquipamento());
            TNE.getValorassociado().setText(String.valueOf(e.getValorAssociado()));
    
    }

}
