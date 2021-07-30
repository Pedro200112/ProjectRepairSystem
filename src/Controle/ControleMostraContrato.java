package Controle;

import Visao.TelaCadastraContrato;
import Visao.TelaContrato;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;

public class ControleMostraContrato implements ActionListener {

    private final TelaContrato TC;
    private final RegraMostraContrato RMC;

    public ControleMostraContrato() {

        this.TC = new TelaContrato(null, true);
        this.RMC = new RegraMostraContrato(TC);

        addListerners();
        RMC.listar();
        this.TC.setVisible(true);

    }

    public void addListerners() {

        this.TC.getBotaoDetalhes().addActionListener(this);
        this.TC.getBotaonovocontrato().addActionListener(this);
        this.TC.getBotaopesquisa().addActionListener(this);
        this.TC.getBotonSair().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent var) {

        if (var.getSource().equals(this.TC.getBotaoDetalhes())) {
            this.RMC.detalhes();
            this.TC.dispose();
        } else if (var.getSource().equals(this.TC.getBotaonovocontrato())) {

            ControleContrato CC = new ControleContrato();
            this.TC.dispose();

        } else if (var.getSource().equals(this.TC.getBotaopesquisa())) {

           this.RMC.pesquisar();

        }  else if (var.getSource().equals(this.TC.getBotonSair())) {

            String rece = null;

            try {

                rece = this.RMC.procuraLogin();

                if (rece.equals("Admnistrador")) {

                    ControlePrincipal CP = new ControlePrincipal();

                } else if (rece.equals("Atendente")) {

                    ControleAtendente CA = new ControleAtendente();

                } else if (rece.equals("Supervisor")) {

                    ControleSupervisor CS = new ControleSupervisor();

                } else if (rece.equals("Tecnico")) {

                    ControleTecnico CT = new ControleTecnico();

                } else if (rece.equals("Vendedor")) {

                    ControleVendedor CV = new ControleVendedor();

                }

                TC.dispose();

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "ERRO", "XXXX", ERROR_MESSAGE);
            }

        }

    }

}
