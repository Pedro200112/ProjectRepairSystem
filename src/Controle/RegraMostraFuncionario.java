package Controle;

import Modelo.Funcionario;
import Modelo.FuncionarioDao;
import Modelo.LoginDao;
import Modelo.UsuarioDao;
import Visao.TelaAddFuncionario;
import Visao.TelaFuncionario;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.text.html.HTML;

public class RegraMostraFuncionario {

    private final TelaFuncionario TF;
    private final TelaAddFuncionario TAF;
    private FuncionarioDao FD;
    public boolean novo;
    public String cpfId;

    RegraMostraFuncionario(TelaFuncionario TF1, TelaAddFuncionario TAF1) {
        this.TF = TF1;
        this.TAF = TAF1;
        this.FD = new FuncionarioDao();
    }

    public String procuraLogin() throws SQLException {

        String passa = null;

        LoginDao LD = new LoginDao();

        passa = LD.procuraLogin();

        return passa;

    }

    public void listar() {
        listaDados(FD.mostraFunc());
    }

    public void listarTecn() {
        listaDados(FD.mostraTecn());
    }

    public void pesquisar() {

        listaDados(FD.pesquisar(TF.getPesquisar().getText()));

    }

    private void listaDados(ArrayList<Funcionario> listaFunc) {
        TF.limpaTabela();
        for (int i = 0; i < listaFunc.size(); i++) {
            TF.adicionaItem(listaFunc.get(i).getCpf(),
                    listaFunc.get(i).getClassificador(),
                    listaFunc.get(i).getNome());

        }

    }
    
    public void edicao(){
    
     int item = TF.getTabelaFuncionario().getSelectedRow();
        if (item >= 0) {
            this.cpfId = (String) TF.getModelo().getValueAt(item, 0);
            Funcionario f = FD.pesquisa(this.cpfId);
            
            ControleFuncionario CF = new ControleFuncionario();
            
            CF.setDados(f);
    
    }else {
            
            JOptionPane.showMessageDialog(null, "EERO!", "ALERTA:", WARNING_MESSAGE);
            
             ControleMostraFuncionario CMF = new ControleMostraFuncionario();
            
        }
    }
        
    public void detalhes() {
        int item = TF.getTabelaFuncionario().getSelectedRow();
        if (item >= 0) {
            this.cpfId = (String) TF.getModelo().getValueAt(item, 0);
            
            Funcionario f = FD.pesquisa(this.cpfId);
            
            ControleFuncionario CF = new ControleFuncionario();
            
            CF.setDados(f);

        } else {
            
            JOptionPane.showMessageDialog(null, "SELECIONE ALGUM ITEM!", "ALERTA:", WARNING_MESSAGE);
            
             ControleMostraFuncionario CMF = new ControleMostraFuncionario();
            
        }
    }

}
