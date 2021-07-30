package Controle;

import Modelo.Relatorio;
import Visao.TelaAddRelatorio;
import Visao.TelaAtendente;
import Visao.TelaRelatorio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;

public class ControleRelatorio implements ActionListener {

    private final TelaAddRelatorio TAR;
    private final TelaRelatorio TR;
    private final RegraRelatorio RR;

    public ControleRelatorio() {

        this.TAR = new TelaAddRelatorio(null, true);
        this.TR = new TelaRelatorio(null, true);
        this.RR = new RegraRelatorio(TAR, TR);
        
        addListerners();
        
        this.TAR.setVisible(true);
        
        TAR.getCpfvalido().setEditable(true);
        TAR.getData().setEditable(true);
        TAR.getEmpresasolicitante().setEditable(true);
        TAR.getEquipamentosreparados().setEditable(true);
        TAR.getNderelatorio().setEditable(true);
        TAR.getNderelatorio().setEditable(true);
        TAR.getNometecnico().setEditable(true);
        TAR.getProblema().setEditable(true);
        TAR.getSolucao().setEditable(true);
        
       
    }

    public void addListerners() {

        this.TAR.getBotaoAnexar().addActionListener(this);
        this.TAR.getBotaoExcluir().addActionListener(this);
        this.TAR.getBotonSair().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent var) {
        if (var.getSource().equals(this.TAR.getBotaoAnexar())) {
            this.RR.adicionaRelatorio();
        } else if (var.getSource().equals(this.TAR.getBotonSair())) {
            String rece = null;
            try {
                rece = this.RR.procuraLogin();
                if (rece.equals("Admnistrador")) {
                    ControleMostraRelatorio CMR = new ControleMostraRelatorio();
                    this.TAR.dispose();

                } else if (rece.equals("Atendente")) {

                    ControleAtendente CA = new ControleAtendente();

                    this.TAR.dispose();

                } else if (rece.equals("Supervisor")) {

                    ControleSupervisor CS = new ControleSupervisor();

                    this.TAR.dispose();

                } else if (rece.equals("Tecnico")) {

                    ControleTecnico CT = new ControleTecnico();

                    this.TAR.dispose();

                } else if (rece.equals("Vendedor")) {

                    ControleVendedor CV = new ControleVendedor();

                    this.TAR.dispose();

                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "ERRO", "XXXX", ERROR_MESSAGE);
            }

            this.TAR.dispose();

        } else if (var.getSource().equals(this.TAR.getBotaoExcluir())) {

            this.RR.excluir();

        } 

    }
    
    public void setDados(Relatorio r){
        
        this.TAR.limpar();
        
        TAR.getNderelatorio().setText(String.valueOf(r.getnDoRelatorio()));
        TAR.getCpfvalido().setText(r.getCpfTecnico());
        TAR.getData().setText(r.getDataRelatorio());
        TAR.getEquipamentosreparados().setText(r.getEquipamentosReparados());
        TAR.getProblema().setText(r.getProblemaIdent());
        TAR.getEmpresasolicitante().setText(r.getEmpresaSolicitante());
        TAR.getCompoentestroca().setText(r.getComponentesTrocados());
        TAR.getSolucao().setText(r.getSolucao());
        TAR.getNometecnico().setText(r.getNomeTecnico());
    }

}
