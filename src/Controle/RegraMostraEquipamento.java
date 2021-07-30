package Controle;

import Modelo.Equipamento;
import Modelo.EquipamentoDao;
import Modelo.Funcionario;
import Modelo.LoginDao;
import Visao.TelaAddFuncionario;
import Visao.TelaAtendente;
import Visao.TelaCadastraContrato;
import Visao.TelaEquipamento;
import Visao.TelaNovoEquipamento;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;

public class RegraMostraEquipamento {

    private final TelaEquipamento TE;
    private TelaNovoEquipamento TNE;
    private RegraEquipamento RE;
    private EquipamentoDao ED;
    private int id;
    private int nSerie;

    RegraMostraEquipamento(TelaEquipamento TE1) {

        this.TE = TE1;
        this.ED = new EquipamentoDao();

    }

    public String procuraLogin() throws SQLException {

        String passa = null;

        LoginDao LD = new LoginDao();

        passa = LD.procuraLogin();

        return passa;

    }

    public void listar() {
        listaDados(ED.mostraEquipa());
    }

    public void pesquisar() {
        String nome = TE.getPesquisar().getText();
        listaDados(ED.pesquisar(nome));
    }

    private void listaDados(ArrayList<Equipamento> listaEquip) {
        TE.limpaTabela();
        for (int i = 0; i < listaEquip.size(); i++) {
            TE.adicionaItem(listaEquip.get(i).getnSerie(),
                    listaEquip.get(i).getNomeEquipamento(),
                    listaEquip.get(i).getnContrato(),
                    listaEquip.get(i).getValorAssociado()
            );
        }

    }

     public void edicao(){
    
     int item = TE.getTabelaEquipa().getSelectedRow();
        if (item >= 0) {
            this.nSerie = (int) TE.getModelo().getValueAt(item, 0);
            Equipamento e = ED.pesquisa(this.nSerie);
            
            ControleEquipamento CE = new ControleEquipamento();
            
            CE.setDados(e);
    
    }else {
            
            JOptionPane.showMessageDialog(null, "ERRO!", "ALERTA:", WARNING_MESSAGE);
            
             ControleMostraEquipamento CMF = new ControleMostraEquipamento();
            
        }
    }
        
    
    void detalhes() {
        int item = TE.getTabelaEquipa().getSelectedRow();
        if (item >= 0) {
            this.id = (int) TE.getModelo().getValueAt(item, 0);
            Equipamento E = ED.pesquisa(id);
            ControleEquipamento CE = new ControleEquipamento();
            CE.setDados(E);
            
        } else {
            JOptionPane.showMessageDialog(TNE, "ERRO AO EXIBIR INFORMAÇÕES", "ERRO RME", ERROR_MESSAGE);
        }
    }

}
