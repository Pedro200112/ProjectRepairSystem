package Controle;

import Visao.TelaAddFuncionario;
import Visao.TelaAtendente;
import Visao.TelaFuncionario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;

public class ControleMostraFuncionario implements ActionListener {

    private final TelaFuncionario TF;
    private final TelaAddFuncionario TAF;
    private final RegraMostraFuncionario RMF;
    private final RegraFuncionario RF;

    public ControleMostraFuncionario() {

        this.TF = new TelaFuncionario(null, true);
        this.TAF = new TelaAddFuncionario(null,true);
        this.RMF = new RegraMostraFuncionario(TF,TAF);
        this.RF = new RegraFuncionario(TAF,TF);
        addListerners();
        RMF.listar();
        this.TF.setVisible(true);

    }

    public void addListerners() {

        this.TF.getBotonAdicionaFuncionario().addActionListener(this);
        this.TF.getBotonDetalhes().addActionListener(this);   
        this.TF.getBotonPesquisar().addActionListener(this);
        this.TF.getBotonSair().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent var) {

        if (var.getSource().equals(this.TF.getBotonAdicionaFuncionario())) {

            ControleFuncionario CF = new ControleFuncionario();

            this.TF.dispose();

        } else if (var.getSource().equals(this.TF.getBotonDetalhes())) {

           this.RMF.detalhes();
           
           this.TF.dispose();
            
        } else if (var.getSource().equals(this.TF.getBotonPesquisar())) {
            
            this.RMF.pesquisar();

        } 
        //ESSE BOTÃO SAIR E DA TELA FUNCIONARIO
        else if (var.getSource().equals(this.TF.getBotonSair())) {

            String rece = null;

            try {

                rece = this.RMF.procuraLogin();

                if (rece.equals("Admnistrador")) {

                    ControlePrincipal CP = new ControlePrincipal();

                    this.TF.dispose();

                } else if (rece.equals("Atendente")) {

                    ControleAtendente CA = new ControleAtendente();

                    this.TF.dispose();

                } else if (rece.equals("Supervisor")) {

                    ControleSupervisor CS = new ControleSupervisor();

                    this.TF.dispose();

                } else if (rece.equals("Tecnico")) {

                    ControleTecnico CT = new ControleTecnico();

                    this.TF.dispose();

                } else if (rece.equals("Vendedor")) {

                    ControleVendedor CV = new ControleVendedor();

                    this.TF.dispose();

                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "ERRO", "ERRO CMF", ERROR_MESSAGE);
            }

            TF.dispose();

        }

    }

}
