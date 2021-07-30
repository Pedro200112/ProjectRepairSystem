package Controle;

import Modelo.LoginDao;
import Modelo.Relatorio;
import Modelo.RelatorioDao;
import Visao.TelaAddRelatorio;
import Visao.TelaRelatorio;
import java.sql.SQLException;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class RegraRelatorio {

    private final TelaAddRelatorio TAR;
    private final TelaRelatorio TR;
    private RelatorioDao RD;
    private RegraMostraRelatorio RMR;
    private int nRelatorio;

    RegraRelatorio(TelaAddRelatorio TAR, TelaRelatorio TR) {
        this.TAR = TAR;
        this.TR = TR;
        this.RD = new RelatorioDao();
    }

    public String procuraLogin() throws SQLException {

        String passa = null;

        LoginDao LD = new LoginDao();

        passa = LD.procuraLogin();

        return passa;

    }

    public void adicionaRelatorio() {
        if (validarCampos()) {
            if (validarCpf(TAR.getCpfvalido().getText())) {
                RelatorioDao RD = new RelatorioDao();
                Relatorio R = new Relatorio();

                try{
                
                R.setnDoRelatorio(Integer.parseInt(TAR.getNderelatorio().getText()));
                R.setCpfTecnico((TAR.getCpfvalido().getText()));
                R.setEquipamentosReparados((TAR.getEquipamentosreparados().getText()));
                R.setProblemaIdent((TAR.getProblema().getText()));
                R.setEmpresaSolicitante((TAR.getEmpresasolicitante().getText()));
                R.setNomeTecnico((TAR.getNometecnico().getText()));
                R.setComponentesTrocados((TAR.getCompoentestroca().getText()));
                R.setSolucao((TAR.getSolucao().getText()));
                R.setDataRelatorio((TAR.getData().getText()));

                RD.criaRelatorio(R);
                
                }catch(Exception var){
       
                  JOptionPane.showMessageDialog(null, "Nº DO RELATÓRIO: NÚMEROS \n "
                   + "CPF TÉCNICO: NÚMEROS \n "
                   + "EQUIPAMENTOS REPADOS: CARACTERES  \n"
                   + "PROBLEMA IDENTIFICADO: CARACTERES \n "
                   + "EMPRESA SOLICITANTE: CARACTERES \n"
                   +" NOME TÉCNICO: CARACTERES\n"
                   +" COMPONENTES TROCADOS: CARACTERES\n"
                   +" SOLUÇÃO: CARACTERES\n"
                   +" DATA RELATORIO: NÚMEROS\n"
                   ,"ALERTA: ", ERROR_MESSAGE);
       
       }
                
                
            } else {
                JOptionPane.showMessageDialog(null, "SEU CPF NÃO É VÁLIDO \n TENTE NOVAMENTE OU DIRIGA-SE A RECEITA FEDERAL", "ERRO DE CADASTRO: ", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "TODOS OS CAMPOS DEVEM SER PREENCHIDOS!", "ALERTA: ", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void excluir() {
        if (validarCampos()) {
            if (JOptionPane.showConfirmDialog(TAR, "Deseja realmente excluir?", "Confirmação de exclusão",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
                int relatorio = 0;
                Relatorio R = new Relatorio();
                R.setnDoRelatorio(Integer.parseInt(TAR.getNderelatorio().getText()));
                relatorio = R.getnDoRelatorio();
                RD.excluir(relatorio);
            }
        } else {
            JOptionPane.showMessageDialog(null, "REALIZE O CADASTRO DE ALGUM FUNCIONARIO PRIMEIRO", "ALERTA: ", JOptionPane.ERROR_MESSAGE);

        }
    }

    public boolean validarCpf(String cpf) {
        int cont = 0;

        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");

        for (int i = 0; i < 10; i++) {
            if (cpf.charAt(i) == cpf.charAt(i + 1)) {
                cont = cont + 1;
            }
        }

        if (cont == 10 || cpf.length() != 11) {
            return false;
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            //cálculo do 1º dígito verificador;
            sm = 0;
            peso = 10;

            for (i = 0; i < 9; i++) {
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);

            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48);
            }

            //cálculo do 2º dígito verificador;
            sm = 0;
            peso = 11;

            for (i = 0; i < 10; i++) {
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);

            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            //verifica se os digitos calculados conferem com os digitos informados.
            return (dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10));

        } catch (InputMismatchException ex) {
            System.out.println("Deu ruin na verificação do cpf - Classe Regra funcionario - Método " + ex);
            return false;
        }

    }

    public boolean validarCampos() {
        if (this.TAR.getNderelatorio().getText().equals("")) {
            return false;
        } else if (this.TAR.getCpfvalido().getText().equals("   .   .   -  ")) {
            return false;
        } else if (this.TAR.getEquipamentosreparados().getText().equals("")) {
            return false;
        } else if (this.TAR.getProblema().getText().equals("")) {
            return false;
        } else if (this.TAR.getEmpresasolicitante().getText().equals("(  )     -    ")) {
            return false;
        } else if (this.TAR.getNometecnico().getText().equals("")) {
            return false;
        } else if (this.TAR.getCompoentestroca().getText().equals("(  )     -    ")) {
            return false;
        } else if (this.TAR.getSolucao().getText().equals("")) {
            return false;
        } else if (this.TAR.getData().getText().equals("")) {
            return false;
        } else {
            return true;
        }
    }

}
