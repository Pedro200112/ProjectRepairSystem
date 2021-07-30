package Controle;

import Visao.TelaAtendente;
import Visao.TelaEquipamento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

public class ControleMostraEquipamento implements ActionListener {

    private final TelaEquipamento TE;
    private final RegraMostraEquipamento RME;

    public ControleMostraEquipamento() {

        this.TE = new TelaEquipamento(null, true);
        this.RME = new RegraMostraEquipamento(TE);
        addListerners();
        this.TE.setVisible(true);
        this.RME.listar();

    }

    public void addListerners() {

        this.TE.getBotaonovoequipamento().addActionListener(this);
        this.TE.getBotonDetalhes().addActionListener(this);
        this.TE.getBotonEditar().addActionListener(this);
        this.TE.getBotonPesquisar().addActionListener(this);
        this.TE.getBotonSair().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent var) {

        if (var.getSource().equals(this.TE.getBotaonovoequipamento())) {

            ControleEquipamento CE = new ControleEquipamento();

            this.TE.dispose();

        } else if (var.getSource().equals(this.TE.getBotonDetalhes())) {

            this.RME.detalhes();

            this.TE.dispose();
            
        } else if (var.getSource().equals(this.TE.getBotonEditar())) {

            this.RME.edicao();

        } else if (var.getSource().equals(this.TE.getBotonPesquisar())) {

            this.RME.pesquisar();

        } else if (var.getSource().equals(this.TE.getBotonSair())) {

            String rece = null;

            try {

                rece = this.RME.procuraLogin();

                if (rece.equals("Admnistrador")) {

                    ControlePrincipal CP = new ControlePrincipal();

                    this.TE.dispose();

                } else if (rece.equals("Atendente")) {

                    ControleAtendente CA = new ControleAtendente();

                    this.TE.dispose();

                } else if (rece.equals("Supervisor")) {

                    ControleSupervisor CS = new ControleSupervisor();

                    this.TE.dispose();

                } else if (rece.equals("Tecnico")) {

                    ControleTecnico CT = new ControleTecnico();

                    this.TE.dispose();

                } else if (rece.equals("Vendedor")) {

                    ControleVendedor CV = new ControleVendedor();

                    this.TE.dispose();

                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "ERRO", "XXXX", ERROR_MESSAGE);
            }

            TE.dispose();

        }

    }

}
