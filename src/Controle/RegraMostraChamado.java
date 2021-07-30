package Controle;

import Modelo.Chamado;
import Modelo.ChamadoDao;
import Modelo.Contrato;
import Modelo.ContratoDao;
import Modelo.LoginDao;
import Visao.TelaAtendente;
import Visao.TelaCadastraContrato;
import Visao.TelaCadastroChamado;
import Visao.TelaChamado;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;

public class RegraMostraChamado {

    private final TelaChamado TC;
    private final TelaCadastroChamado TCC;
    private ChamadoDao CD;
    private int id; //DETALHES

    RegraMostraChamado(TelaChamado TCC1, TelaCadastroChamado TCC2) {

        this.TC = TCC1;
        this.TCC = TCC2;
        this.CD = new ChamadoDao();

    }

    public String procuraLogin() throws SQLException {

        String passa = null;

        LoginDao LD = new LoginDao();

        passa = LD.procuraLogin();

        return passa;

    }

    public void listar() {
        listaDados(CD.mostraChama());
    }

    private void listaDados(ArrayList<Chamado> listaChama) {
        TC.limpaTabela();
        for (int i = 0; i < listaChama.size(); i++) {
            TC.adicionaItem(listaChama.get(i).getnChamado(),
                    listaChama.get(i).getNomeEmpresa());

        }
    }

    public void pesquisar() {
        if (this.TC.getPesquisar().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "POR FAVOR INSIRA UM NÚMERO VÁLIDO");
        } else {
            int numero = 0;

            numero = Integer.parseInt(TC.getPesquisar().getText());

            this.listaDados(CD.pesquisar(numero));
        }
    }

   
    public void detalhes() {
           
        int item = TC.getTabelaChamado().getSelectedRow();
        if (item >= 0) {
            this.id = (int) TC.getModelo().getValueAt(item, 0);
            Chamado c = CD.pesquisa(this.id);
            
            ControleChamado CC = new ControleChamado();
            
            CC.setDados(c);

             

        } else {
            
           JOptionPane.showMessageDialog(null, "SELECIONE ALGUM ITEM!", "ALERTA:", WARNING_MESSAGE);
           
           ControleMostraChamado CMC = new ControleMostraChamado();
           
        }
    }
    
    public void edicao() {
           
        int item = TC.getTabelaChamado().getSelectedRow();
        if (item >= 0) {
            this.id = (int) TC.getModelo().getValueAt(item, 0);
            Chamado c = CD.pesquisa(this.id);
            
            ControleChamado CC = new ControleChamado();
            
            CC.setDados(c);

             

        } else {
            
           JOptionPane.showMessageDialog(null, "SELECIONE ALGUM ITEM!", "ALERTA:", WARNING_MESSAGE);
           
           ControleMostraChamado CMC = new ControleMostraChamado();
           
        }
    }
    
    

}
