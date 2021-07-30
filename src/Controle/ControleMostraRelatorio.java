package Controle;

import Visao.TelaAddRelatorio;
import Visao.TelaAtendente;
import Visao.TelaRelatorio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

public class ControleMostraRelatorio implements ActionListener {

    private final TelaRelatorio TR;
    private final TelaAddRelatorio TAR;
    private final RegraMostraRelatorio RMR;
    private final RegraRelatorio RR;

    public ControleMostraRelatorio() {

        this.TR = new TelaRelatorio(null, true);
        this.TAR = new TelaAddRelatorio(null, true);
        this.RMR = new RegraMostraRelatorio(TR, TAR);
        this.RR = new RegraRelatorio(TAR, TR);

        addListerners();
        this.RMR.listar();
        this.TR.setVisible(true);

    }

    public void addListerners() {

        this.TR.getBotonAbrir().addActionListener(this);
        this.TR.getBotonDetalhes().addActionListener(this);
        this.TR.getBotonPesquisar().addActionListener(this);
        this.TR.getBotonSair().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent var) {

        if (var.getSource().equals(this.TR.getBotonAbrir())) {

            ControleRelatorio CR = new ControleRelatorio();
            this.TR.dispose();

        } else if (var.getSource().equals(this.TR.getBotonDetalhes())) {
            
            this.RMR.detalhes();
            
            this.TR.dispose();
            
        } else if (var.getSource().equals(this.TR.getBotonPesquisar())) {

            this.RMR.pesquisar();

        } else if (var.getSource().equals(this.TR.getBotonSair())) {

            String rece = null;

            try {

                rece = this.RMR.procuraLogin();

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

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "ERRO", "XXXX", ERROR_MESSAGE);
            }

            TR.dispose();

        }

    }

}
