package Controle;

import Modelo.Contrato;
import Modelo.ContratoDao;
import Modelo.Funcionario;
import Modelo.FuncionarioDao;
import Modelo.LoginDao;
import Visao.TelaAtendente;
import Visao.TelaCadastraContrato;
import Visao.TelaCadastroChamado;
import java.sql.SQLException;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class RegraContrato {

    private final TelaCadastraContrato TCC;
    private ContratoDao CD;
    private RegraMostraChamado RMC;

    RegraContrato(TelaCadastraContrato TCC1) {

        this.TCC = TCC1;
        this.CD = new ContratoDao();

    }

   

    public void AdicionaContrato() throws SQLException {

        if (validarCampos()) {
            if (validarCNPJ(this.TCC.getCnpj().getText())) {
                ContratoDao CD = new ContratoDao();
                Contrato C = new Contrato();

                try{
                
                C.setCnpj(TCC.getCnpj().getText());
                C.setTipoequipameno(TCC.getTiposequipa().getText());
                C.setValorassociado(Integer.parseInt(TCC.getValorassocia().getText()));
                C.setNomeEmpresa(TCC.getNomeem().getText());
                C.setEndereco(TCC.getEndereco().getText());
                C.setNdequipamento(Integer.parseInt(TCC.getNequipa().getText()));
                C.setParcelaspagamento(Integer.parseInt(TCC.getParcelapaga().getText()));

                CD.CriaContrato(C);
                
                } catch(Exception var){
       
                  JOptionPane.showMessageDialog(null, "CNPJ: NÚMEROS \n "
                   + "TIPO DE EQUIPAMENTOS: CARACTERES \n "
                   + "VALOR ASSOCIADO: NÚMEROS \n"
                   + "NOME DA EMPRESA: CARACTERES \n "
                   + "NOME EQUIPAMENTO: CARACTERES \n"
                   + "ENDEREÇO: CARACTERES \n"
                   + "Nº DE EQUIPAMENTOS: NÚMEROS \n"
                   + "PARCELAS PAGAMENTO: NÚMEROS","ALERTA: ", ERROR_MESSAGE);
       
       }

                
            } else {
                JOptionPane.showMessageDialog(TCC, "Informe um CNPJ válido.", "Erro: número de CNPJ inválido!", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(TCC, "Preencha todos os campos.", "Erro: todos os campos são obrigatórios!", JOptionPane.ERROR_MESSAGE);
        }

    }

    public String procuraLogin() throws SQLException {

        String passa = null;

        LoginDao LD = new LoginDao();

        passa = LD.procuraLogin();

        return passa;

    }
    
     public void limpa() {
        TCC.getCnpj().setText("");
        TCC.getEndereco().setText("");
        TCC.getNequipa().setText("");
        TCC.getNomeem().setText("");
        TCC.getParcelapaga().setText("");
        TCC.getTiposequipa().setText("");
        TCC.getValorassocia().setText("");
    }

    public static boolean validarCNPJ(String CNPJ) {
        CNPJ = CNPJ.replace(".", "");
        CNPJ = CNPJ.replace("-", "");
        CNPJ = CNPJ.replace("/", "");
// considera-se erro CNPJ's formados por uma sequencia de numeros iguais
        if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111")
                || CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333")
                || CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555")
                || CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777")
                || CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999")
                || (CNPJ.length() != 14)) {
            return (false);
        }

        char dig13, dig14;
        int sm, i, r, num, peso;

// "try" - protege o código para eventuais erros de conversao de tipo (int)
        try {
// Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 11; i >= 0; i--) {
// converte o i-ésimo caractere do CNPJ em um número:
// por exemplo, transforma o caractere '0' no inteiro 0
// (48 eh a posição de '0' na tabela ASCII)
                num = (int) (CNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig13 = '0';
            } else {
                dig13 = (char) ((11 - r) + 48);
            }

// Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 12; i >= 0; i--) {
                num = (int) (CNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig14 = '0';
            } else {
                dig14 = (char) ((11 - r) + 48);
            }

// Verifica se os dígitos calculados conferem com os dígitos informados.
            if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    public boolean validarCampos() {
        if (this.TCC.getnSequencial().getText().equals("")) {
            return false;
        } else if (this.TCC.getCnpj().getText().equals("  .   .   /    -  ")) {
            return false;
        } else if (this.TCC.getTiposequipa().getText().equals("")) {
            return false;
        } else if (this.TCC.getValorassocia().getText().equals("")) {
            return false;
        } else if (this.TCC.getNomeem().getText().equals("")) {
            return false;
        } else if (this.TCC.getNequipa().getText().equals("")) {
            return false;
        } else if (this.TCC.getParcelapaga().getText().equals("")) {
            return false;
        }
        return true;
    }

    public void editar() {
        ContratoDao CD = new ContratoDao();
        Contrato c = new Contrato();
     
        try{
        
        c.setnSequencia(Integer.parseInt(TCC.getnSequencial().getText()));
        c.setCnpj(String.valueOf(TCC.getCnpj().getText()));
        c.setTipoequipameno(String.valueOf(TCC.getTiposequipa().getText()));
        c.setValorassociado(Integer.parseInt(TCC.getValorassocia().getText()));
        c.setNomeEmpresa(String.valueOf(TCC.getNomeem().getText()));
        c.setEndereco(TCC.getEndereco().getText());
        c.setNdequipamento(Integer.parseInt(TCC.getNequipa().getText()));
        c.setParcelaspagamento(Integer.parseInt(TCC.getParcelapaga().getText()));
        CD.editar(c);
        
          }catch(Exception var){
       
                  JOptionPane.showMessageDialog(null, "CNPJ: NÚMEROS \n "
                   + "TIPO DE EQUIPAMENTOS: CARACTERES \n "
                   + "VALOR ASSOCIADO: NÚMEROS \n"
                   + "NOME DA EMPRESA: CARACTERES \n "
                   + "NOME EQUIPAMENTO: CARACTERES \n"
                   + "ENDEREÇO: CARACTERES \n"
                   + "Nº DE EQUIPAMENTOS: NÚMEROS \n"
                   + "PARCELAS PAGAMENTO: NÚMEROS","ALERTA: ", ERROR_MESSAGE);
       
       }
        
        
    }
    
    public void ExcluiContrato(){
        int nSequencial = 0;
        ContratoDao CD = new ContratoDao();
        Contrato C = new Contrato();
        
        C.setnSequencia(Integer.parseInt(TCC.getnSequencial().getText()));
        nSequencial = C.getnSequencia();
        
        CD.excluir(nSequencial);
    }

}
