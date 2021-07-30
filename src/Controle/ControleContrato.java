package Controle;

import Modelo.Contrato;
import Visao.TelaAtendente;
import Visao.TelaCadastraContrato;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class ControleContrato implements ActionListener {

    private final TelaCadastraContrato TCC;
    private final RegraContrato RC;

    public ControleContrato() {

        this.TCC = new TelaCadastraContrato(null, true);
        this.RC = new RegraContrato(TCC);

        addListerners();

        this.TCC.setVisible(true);

        TCC.getCnpj().setEditable(true);
        TCC.getTiposequipa().setEditable(true);
        TCC.getValorassocia().setEditable(true);
        TCC.getNomeem().setEditable(true);
        TCC.getEndereco().setEditable(true);
        TCC.getNequipa().setEditable(true);
        TCC.getParcelapaga().setEditable(true);

    }

    public void addListerners() {

        this.TCC.getExcluir().addActionListener(this);
        this.TCC.getSalvar().addActionListener(this);
        this.TCC.getBotonEditar().addActionListener(this);
        this.TCC.getBotonSair().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent var) {

        if (var.getSource().equals(this.TCC.getExcluir())) {

            if (RC.validarCampos()) {
                if (JOptionPane.showConfirmDialog(TCC, "Deseja realmente excluir?", "Confirmação de exclusão",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
                    this.RC.ExcluiContrato();
                    ControleMostraContrato CMF = new ControleMostraContrato();
                    this.TCC.dispose();
                }

            } else {
                JOptionPane.showMessageDialog(null, "REALIZE O CADASTRO DE ALGUM CONTRATO PRIMEIRO", "ALERTA: ", JOptionPane.ERROR_MESSAGE);
            }

        } else if (var.getSource().equals(this.TCC.getSalvar())) {
            try {
                this.RC.AdicionaContrato();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERRO", "XXXX", ERROR_MESSAGE);
            }

        } else if (var.getSource().equals(this.TCC.getBotonEditar())) {

            this.RC.editar();

        } else if (var.getSource().equals(this.TCC.getBotonSair())) {
            String rece = null;
            try {
                rece = this.RC.procuraLogin();
                if (rece.equals("Admnistrador")) {
                    ControleMostraContrato CMC = new ControleMostraContrato();
                    this.TCC.dispose();

                } else if (rece.equals("Atendente")) {

                    ControleMostraContrato CMC = new ControleMostraContrato();

                    this.TCC.dispose();

                } else if (rece.equals("Supervisor")) {

                    ControleMostraContrato CMC = new ControleMostraContrato();
                    this.TCC.dispose();

                } else if (rece.equals("Tecnico")) {

                    ControleMostraContrato CMC = new ControleMostraContrato();

                    this.TCC.dispose();

                } else if (rece.equals("Vendedor")) {

                    ControleMostraContrato CMC = new ControleMostraContrato();

                    this.TCC.dispose();

                }
                TCC.dispose();

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "ERRO", "XXXX", ERROR_MESSAGE);
            }

        }

    }

    public void setDados(Contrato c) {
        
        this.TCC.limpar();

        //TCC.getEndereco().setText(c.getEndereco());
        TCC.getnSequencial().setText(String.valueOf(c.getnSequencia()));
        TCC.getCnpj().setText(c.getCnpj());
        TCC.getTiposequipa().setText(c.getTipoequipameno());
        TCC.getValorassocia().setText(String.valueOf(c.getValorassociado()));
        TCC.getNomeem().setText(c.getNomeEmpresa());
        TCC.getNequipa().setText(String.valueOf(c.getNdequipamento()));
        TCC.getParcelapaga().setText(String.valueOf(c.getParcelaspagamento()));
    }

}
