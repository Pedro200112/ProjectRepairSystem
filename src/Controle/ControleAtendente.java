package Controle;

import Visao.TelaAtendente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class ControleAtendente implements ActionListener {

    private final TelaAtendente TA;
    private final RegraAtendente RA;

    public ControleAtendente() {

        this.TA = new TelaAtendente(null, true);
        this.RA = new RegraAtendente(TA);

        addListerners();

        this.TA.setVisible(true);

    }

    public void addListerners() {

        this.TA.getBotaoSair().addActionListener(this);
        this.TA.getBotonChamado().addActionListener(this);
        this.TA.getBotonContratos().addActionListener(this);
        this.TA.getBotonEquipamento().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent var) {

        if (var.getSource().equals(this.TA.getBotonChamado())) {

            ControleMostraChamado CC = new ControleMostraChamado();

            this.TA.dispose();

        } else if (var.getSource().equals(this.TA.getBotonContratos())) {

            ControleMostraContrato CC = new ControleMostraContrato();

            this.TA.dispose();

        } else if (var.getSource().equals(this.TA.getBotonEquipamento())) {

            ControleMostraEquipamento CE = new ControleMostraEquipamento();

            this.TA.dispose();

        } else if (var.getSource().equals(this.TA.getBotaoSair())) {

            ControleLogin LC = new ControleLogin();

            this.TA.dispose();

        }

    }

}
