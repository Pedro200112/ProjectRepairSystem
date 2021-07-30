package Controle;

import Modelo.Equipamento;
import Modelo.EquipamentoDao;
import Modelo.LoginDao;
import Visao.TelaNovoEquipamento;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class RegraEquipamento {

    private final TelaNovoEquipamento TNE;
    private EquipamentoDao ED;

    RegraEquipamento(TelaNovoEquipamento TE1) {
        this.TNE = TE1;
        this.ED = new EquipamentoDao();
    }

    public void AdicionaEquipamento() {
        if (validarCampos()) {
            EquipamentoDao ED = new EquipamentoDao();
            Equipamento E = new Equipamento();

            try{
            
            E.setnManutencao(Integer.parseInt(TNE.getNdemanutencao().getText()));
            E.setnSerie(Integer.parseInt(TNE.getNdeserie().getText()));
            E.setTipoEquipamento(TNE.getTipodeequipamento().getText());
            E.setValorAssociado(Integer.parseInt(TNE.getValorassociado().getText()));
            E.setNomeEquipamento(TNE.getNomeequipamento().getText());
            E.setnContrato(Integer.parseInt(TNE.getNcontrato().getText()));
            E.setAtaFabrica(TNE.getDatafabricacao().getText());
            E.setParcelaPagamento(Integer.parseInt(TNE.getParcelasdepagamento().getText()));

            ED.criaEquipamento(E);
            
            }catch(Exception var){
       
           JOptionPane.showMessageDialog(null, "Nº DE MANUTENÇÃO: NÚMEROS \n "
                   + "Nº DE SÉRIE: NÚMEROS \n "
                   +"TIPO EQUIPAMENTO: CARACTERES \n"
                   + "VALOR ASSOCIADO: NÚMEROS \n "
                   + "NOME EQUIPAMENTO: CARACTERES \n"
                   + "Nº DE CONTRATO: NÚMEROS \n"
                   +"DATA FABRICAÇÃO: NUMEROS E CARACTERES \n"
                   +"PARCELAS DE PAGAMENTO: NÚMEROS","ALERTA: ", ERROR_MESSAGE);
       
       }

        } else {
            JOptionPane.showMessageDialog(null, "TODOS OS CAMPOS DEVEM SER PREENCHIDOS!", "ALERTA: ", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String procuraLogin() throws SQLException {

        String passa = null;

        LoginDao LD = new LoginDao();

        passa = LD.procuraLogin();

        return passa;

    }

    public void editar() {
        EquipamentoDao ED = new EquipamentoDao();
        Equipamento E = new Equipamento();

        try{
        
        E.setnManutencao(Integer.parseInt(TNE.getNdemanutencao().getText()));
        E.setnSerie(Integer.parseInt(TNE.getNdeserie().getText()));
        E.setTipoEquipamento(TNE.getTipodeequipamento().getText());
        E.setValorAssociado(Integer.parseInt(TNE.getValorassociado().getText()));
        E.setNomeEquipamento(TNE.getNomeequipamento().getText());
        E.setnContrato(Integer.parseInt(TNE.getNcontrato().getText()));
        E.setAtaFabrica(TNE.getDatafabricacao().getText());
        E.setParcelaPagamento(Integer.parseInt(TNE.getParcelasdepagamento().getText()));
        ED.editar(E);
        
        }catch(Exception var){
       
           JOptionPane.showMessageDialog(null, "Nº DE MANUTENÇÃO: NÚMEROS \n "
                   + "Nº DE SÉRIE: NÚMEROS \n "
                   +"TIPO EQUIPAMENTO: CARACTERES \n"
                   + "VALOR ASSOCIADO: NÚMEROS \n "
                   + "NOME EQUIPAMENTO: CARACTERES \n"
                   + "Nº DE CONTRATO: NÚMEROS \n"
                   +"DATA FABRICAÇÃO: NUMEROS E CARACTERES \n"
                   +"PARCELAS DE PAGAMENTO: NÚMEROS","ALERTA: ", ERROR_MESSAGE);
       
       }

    }

    public void ExcluirEquip() {
        int nManutencao = 0;

        EquipamentoDao ED = new EquipamentoDao();
        Equipamento e = new Equipamento();

        e.setnManutencao(Integer.parseInt(TNE.getNdemanutencao().getText()));

        nManutencao = e.getnManutencao();

        ED.excluir(nManutencao);
    }

    public void limpa() {
        TNE.getDatafabricacao().setText("");
        TNE.getNcontrato().setText("");
        TNE.getNdemanutencao().setText("");
        TNE.getNdeserie().setText("");
        TNE.getNomeequipamento().setText("");
        TNE.getParcelasdepagamento().setText("");
        TNE.getTipodeequipamento().setText("");
        TNE.getValorassociado().setText("");
    }

    public boolean validarCampos() {
        if (this.TNE.getNdemanutencao().getText().equals("")) {
            return false;
        } else if (this.TNE.getNdeserie().getText().equals("")) {
            return false;
        } else if (this.TNE.getTipodeequipamento().getText().equals("")) {
            return false;
        } else if (this.TNE.getValorassociado().getText().equals("")) {
            return false;
        } else if (this.TNE.getNomeequipamento().getText().equals("")) {
            return false;
        } else if (this.TNE.getNcontrato().getText().equals("")) {
            return false;
        } else if (this.TNE.getDatafabricacao().getText().equals("  /  /    ")) {
            return false;
        } else if (this.TNE.getParcelasdepagamento().getText().equals("")) {
            return false;
        }
        return true;

    }

}
