package Controle;

import Modelo.LoginDao;
import Modelo.Relatorio;
import Modelo.RelatorioDao;
import Visao.TelaAddFuncionario;
import Visao.TelaAddRelatorio;
import Visao.TelaAtendente;
import Visao.TelaCadastraContrato;
import Visao.TelaRelatorio;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;

public class RegraMostraRelatorio {

    private final TelaRelatorio TR;
    private TelaAddRelatorio TAR;
    private RegraRelatorio RR;
    private RelatorioDao RD;
    private int manutencao;

    RegraMostraRelatorio(TelaRelatorio TR, TelaAddRelatorio TAR) {
        this.TR = TR;
        this.TAR = TAR;
        this.RD = new RelatorioDao();
    }

    public String procuraLogin() throws SQLException {

        String passa = null;

        LoginDao LD = new LoginDao();

        passa = LD.procuraLogin();

        return passa;

    }

    public void detalhes() {
        
        int item = TR.getTabelaRelatorio().getSelectedRow();
        
        if(item>=0){
            
            this.manutencao = (int) TR.getModelo().getValueAt(item, 0);
            
            Relatorio r = RD.pesquisa(this.manutencao);
            
            ControleRelatorio CR = new ControleRelatorio();
            
            CR.setDados(r);
            
        }else{
            
             JOptionPane.showMessageDialog(null, "SELECIONE ALGUM ITEM!", "ALERTA:", WARNING_MESSAGE);
             
             ControleMostraFuncionario CMF = new ControleMostraFuncionario();
        }
    }

    void pesquisar() {
        listaDados(RD.pesquisar(Integer.parseInt(TR.getPesquisar().getText())));
    }

    void listar() {
        listaDados(RD.mostraRela());
    }

    private void listaDados(ArrayList<Relatorio> lista) {
        TR.limpaTabela();
        for (int i = 0; i < lista.size(); i++) {
            TR.adicionaItem(lista.get(i).getnDoRelatorio(),
                    lista.get(i).getNomeTecnico());
        }
    }
}
