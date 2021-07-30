package Controle;

import Modelo.Chamado;
import Modelo.LoginDao;
import Modelo.UsuarioDao;
import Visao.TelaAtendente;
import Visao.TelaCadastraContrato;
import Visao.TelaCadastroChamado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class ControleChamado implements ActionListener {

    private final TelaCadastroChamado TCC;
    private final RegraChamado RC;

    public ControleChamado() {

        this.TCC = new TelaCadastroChamado(null, true);
        this.RC = new RegraChamado(TCC);

        addListerners();

        this.TCC.setVisible(true);
        
        
            TCC.getnDoChamado1().setEditable(true);
            TCC.getNomeDaEmpresa().setEditable(true);
            TCC.getIdDoEquipamento().setEditable(true);
            TCC.getMotivoDaChamada().setEditable(true);
            TCC.getDataDoAtendimento().setEditable(true); 

    }

    public void addListerners() {

        this.TCC.getBotonEncaminhar().addActionListener(this);
        this.TCC.getBotonVerificar().addActionListener(this);
        this.TCC.getBotonSair().addActionListener(this);
        this.TCC.getBotonEditar().addActionListener(this);
        this.TCC.getBotaoExcluir().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent var) {

        if (var.getSource().equals(this.TCC.getBotonSair())) {

            String rece = null;

            try {

                rece = this.RC.procuraLogin();

                if (rece.equals("Admnistrador")) {

                    ControleMostraChamado CMC = new ControleMostraChamado();

                    this.TCC.dispose();

                } else if (rece.equals("Atendente")) {

                    ControleMostraChamado CMC = new ControleMostraChamado();
                    
                    this.TCC.dispose();

                } else if (rece.equals("Supervisor")) {

                    ControleMostraChamado CMC = new ControleMostraChamado();

                    this.TCC.dispose();

                } else if (rece.equals("Tecnico")) {

                    ControleMostraChamado CMC = new ControleMostraChamado();

                    this.TCC.dispose();

                } else if (rece.equals("Vendedor")) {

                    ControleMostraChamado CMC = new ControleMostraChamado();

                    this.TCC.dispose();
                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "ERRO", "XXXX", ERROR_MESSAGE);
            }

            TCC.dispose();

        }else if (var.getSource().equals(this.TCC.getBotonEditar())) {

            try {
                
                this.RC.editar();
                
            } catch (SQLException ex) {
               
                 JOptionPane.showMessageDialog(null, "ERRO", "XXXX", ERROR_MESSAGE);
                
            }

        } else if (var.getSource().equals(this.TCC.getBotonEncaminhar())) {

            try {

                this.RC.AdicionaChamado();
                
                this.RC.limpar();

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, "ERRO", "XXXX", ERROR_MESSAGE);
            }

        } else if (var.getSource().equals(this.TCC.getBotonVerificar())) {

            try {

                ControleMostraChamado CMC = new ControleMostraChamado();

                this.TCC.dispose();

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "ERRO", "XXXX", ERROR_MESSAGE);

            }

        }
         else if (var.getSource().equals(this.TCC.getBotaoExcluir())) {

            try {

                if (RC.validaCampos()) {
                if (JOptionPane.showConfirmDialog(TCC, "Deseja realmente excluir?", "Confirmação de exclusão",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
                    this.RC.ExcluiChama();
                    ControleMostraContrato CMF = new ControleMostraContrato();
                    this.TCC.dispose();
                }

            } else {
                JOptionPane.showMessageDialog(null, "REALIZE O CADASTRO DE ALGUM CHAMADO PRIMEIRO", "ALERTA: ", JOptionPane.ERROR_MESSAGE);
            }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "ERRO", "XXXX", ERROR_MESSAGE);

            }

        }
         
    }
    
     public void setDados(Chamado  c){
         
         
          this.TCC.limpa();

            TCC.getnDoChamado1().setText(String.valueOf(c.getnChamado()));
            TCC.getNomeDaEmpresa().setText(c.getNomeEmpresa());
            TCC.getIdDoEquipamento().setText(String.valueOf(c.getIdEquipamento()));
            TCC.getMotivoDaChamada().setText(c.getMotivoChamada());
            TCC.getDataDoAtendimento().setText(c.getDataentendimento());

          //FALTA O RADIO BUTTON
    
    }

}
