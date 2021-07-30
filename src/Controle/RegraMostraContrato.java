package Controle;

import Modelo.Contrato;
import Modelo.ContratoDao;
import Modelo.Funcionario;
import Modelo.LoginDao;
import Visao.TelaContrato;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;

public class RegraMostraContrato {

    private final TelaContrato TC;
    private ContratoDao CD;
     int nSequencial;

    public RegraMostraContrato(TelaContrato TC1) {

        this.TC = TC1;
        this.CD = new ContratoDao();

    }

    public String procuraLogin() throws SQLException {
        String passa = null;
        LoginDao LD = new LoginDao();
        passa = LD.procuraLogin();
        return passa;

    }

    public void listar() {
        listaDados(CD.mostraContrato());
    }

    public void pesquisar() {

        this.listaDados(CD.pesquisar(Integer.parseInt(TC.getPesquisa().getText())));

    }

    private void listaDados(ArrayList<Contrato> listaPessoas) {
        TC.limpaTabela();
        for (int i = 0; i < listaPessoas.size(); i++) {
            TC.adicionaItem(listaPessoas.get(i).getnSequencia(),
                    listaPessoas.get(i).getNomeEmpresa(),
                    listaPessoas.get(i).getValorassociado());

        }

    }
    
     public void edicao(){
    
     int item = TC.getTabelaContrato().getSelectedRow();
        if (item >= 0) {
            this.nSequencial = (int) TC.getModelo().getValueAt(item, 0);
            Contrato c = CD.pesquisa(this.nSequencial);
            
            ControleContrato CC = new ControleContrato();
            
            CC.setDados(c);
    
    }else {
            
            JOptionPane.showMessageDialog(null, "ERRO!", "ALERTA:", WARNING_MESSAGE);
            
             ControleMostraContrato CMC = new ControleMostraContrato();
            
        }
    }
     
      public void detalhes() {
        int item = TC.getTabelaContrato().getSelectedRow();
        if (item >= 0) {
            this.nSequencial = (int) TC.getModelo().getValueAt(item, 0);
            Contrato c = CD.pesquisa(this.nSequencial);
            
            ControleContrato CC = new ControleContrato();
            
            CC.setDados(c);

        } else {
            
            JOptionPane.showMessageDialog(null, "SELECIONE ALGUM ITEM!", "ALERTA:", WARNING_MESSAGE);
            
             ControleMostraFuncionario CMF = new ControleMostraFuncionario();
            
        }
    }

}
