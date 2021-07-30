package Controle;

import Visao.TelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class ControlePrincipal implements ActionListener {

    private final TelaPrincipal TP;
    private final RegraPrincipal RP;

    public ControlePrincipal() {

        this.TP = new TelaPrincipal(null, true);
        this.RP = new RegraPrincipal();

        addListerners();

        TP.setVisible(true);

    }

    public void addListerners() {

        this.TP.getBotonSair().addActionListener(this);
        this.TP.getBotonCadastro().addActionListener(this);
        this.TP.getBotonContratos().addActionListener(this);
        this.TP.getBotonEquipamento().addActionListener(this);
        this.TP.getBotonFuncionaios().addActionListener(this);
        this.TP.getBotonRelatorios().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent var) {

        if (var.getSource().equals(this.TP.getBotonSair())) {
            try {

                ControleLogin CL = new ControleLogin();
                this.TP.dispose();

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "ERRO", "ALERTA", ERROR_MESSAGE);

            }

        }

        if (var.getSource().equals(this.TP.getBotonCadastro())) {
            try {

                ControleMostraChamado CMC = new ControleMostraChamado();
                TP.dispose();

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "ERRO", "ALERTA", ERROR_MESSAGE);
            }

        }
        if (var.getSource().equals(this.TP.getBotonContratos())) {

            try {

                ControleMostraContrato CMC = new ControleMostraContrato();

                TP.dispose();

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "ERRO", "ALERTA", ERROR_MESSAGE);

            }

        }
        if (var.getSource().equals(this.TP.getBotonEquipamento())) {

            try {

                ControleMostraEquipamento CME = new ControleMostraEquipamento();

                TP.dispose();

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "ERRO", "ALERTA", ERROR_MESSAGE);

            }

        }
        if (var.getSource().equals(this.TP.getBotonFuncionaios())) {

            try {

                ControleMostraFuncionario CMF = new ControleMostraFuncionario();

                TP.dispose();

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "ERRO", "ALERTA", ERROR_MESSAGE);

            }

        }
        if (var.getSource().equals(this.TP.getBotonRelatorios())) {

            try {

                ControleMostraRelatorio CMR = new ControleMostraRelatorio();

                TP.dispose();

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "ERRO", "ALERTA", ERROR_MESSAGE);

            }

        }

    }

}
