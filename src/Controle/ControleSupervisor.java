package Controle;

import Visao.TelaFuncionario;
import Visao.TelaSupervisor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.text.html.HTML.Tag.TT;

public class ControleSupervisor implements ActionListener {

    private final TelaSupervisor TS;
    private final RegraSupervisor RS;

    public ControleSupervisor() {

        this.TS = new TelaSupervisor(null, true);

        this.RS = new RegraSupervisor(TS);

        addListerners();

        this.TS.setVisible(true);

    }

    public void addListerners() {

        this.TS.getBotonChamado().addActionListener(this);
        this.TS.getBotonSair().addActionListener(this);
        this.TS.getBotonTecnicos().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent var) {

        if (var.getSource().equals(this.TS.getBotonChamado())) {

            try {

                ControleMostraChamado CMC = new ControleMostraChamado();

                this.TS.dispose();

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "ERRO", "ALERTA", ERROR_MESSAGE);

            }

        }

        if (var.getSource().equals(this.TS.getBotonTecnicos())) {

            try {
               ControleMostraTecnicos CMF = new ControleMostraTecnicos();
               this.TS.dispose();
            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "ERRO", "ALERTA", ERROR_MESSAGE);

            }

        }
        if (var.getSource().equals(this.TS.getBotonSair())) {

            try {

                ControleLogin CL = new ControleLogin();

                this.TS.dispose();

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "ERRO", "ALERTA", ERROR_MESSAGE);

            }

        }

    }

}
