package Controle;

import Modelo.Funcionario;
import Modelo.FuncionarioDao;
import Modelo.LoginDao;
import Modelo.UsuarioDao;
import Visao.TelaAddFuncionario;
import Visao.TelaFuncionario;
import java.sql.SQLException;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JTextField;
import javax.swing.text.html.HTML;

public class RegraFuncionario {

    private final TelaAddFuncionario TAF;
    private final TelaFuncionario TF;
    private FuncionarioDao FD;
    private RegraMostraFuncionario rmf;
    private String cpfId;
    private boolean novo;

    RegraFuncionario(TelaAddFuncionario TAF1, TelaFuncionario TF1) {
        this.TAF = TAF1;
        this.TF = TF1;
        this.FD = new FuncionarioDao();

    }

    //METODOS COM BANCO
    public void adicionaFunc(String receClassifica) {
        String recebeClassifica;
        recebeClassifica = receClassifica;
        FuncionarioDao FD = new FuncionarioDao();
        Funcionario F = new Funcionario();

       try{ F.setCpf((TAF.getCpf().getText()));
        F.setNome(TAF.getNome().getText());
        F.setEmail(TAF.getEmail().getText());
        F.setEndereco(TAF.getEndereco().getText());
        F.setTelefone(TAF.getTelefone().getText());
        F.setHorasTrabalhadas(Integer.parseInt(TAF.getHorasdetrabalho().getText()));
        F.setClassificador(recebeClassifica);

        FD.criaFuncionario(F);
        
       }catch(Exception var){
       
           JOptionPane.showMessageDialog(null, "NOME: CARACTERES \n "
                   + "EMAIL: CARACTERES E SIMBOLOS \n "
                   +"CPF: NÚMEROS \n"
                   + "ENDEREÇO: CARACTERES \n "
                   + "TELEFONE: NÚMEROS \n"
                   + "HORAS TRABALHO: NÚMEROS \n","ALERTA: ", ERROR_MESSAGE);
       
       }
    }

    public void editar(String classifica) {
        FuncionarioDao FD = new FuncionarioDao();
        Funcionario F = new Funcionario();

        try{
        
        F.setCpf((TAF.getCpf().getText()));
        F.setNome(TAF.getNome().getText());
        F.setEmail(TAF.getEmail().getText());
        F.setEndereco(TAF.getEndereco().getText());
        F.setTelefone(TAF.getTelefone().getText());
        F.setHorasTrabalhadas(Integer.parseInt(TAF.getHorasdetrabalho().getText()));
        F.setClassificador(classifica);
        FD.editar(F);
        
        }catch(Exception var){
       
           JOptionPane.showMessageDialog(null, "NOME: CARACTERES \n "
                   + "EMAIL: CARACTERES E SIMBOLOS \n "
                   +"CPF: NÚMEROS \n"
                   + "ENDEREÇO: CARACTERES \n "
                   + "TELEFONE: NÚMEROS \n"
                   + "HORAS TRABALHO: NÚMEROS \n","ALERTA: ", ERROR_MESSAGE);
       
       }
    }

    public void ExcluiFunc() {

        String rececpf = null;

        FuncionarioDao FD = new FuncionarioDao();
        Funcionario F = new Funcionario();

        F.setCpf((TAF.getCpf().getText()));

        rececpf = F.getCpf();

        FD.excluir(rececpf);

    }

    public String procuraLogin() throws SQLException {

        String passa = null;

        //Cria variável Login Dao
        LoginDao LD = new LoginDao();

        //Chama método da Login Dao para ver quem fez Login
        passa = LD.procuraLogin();

        return passa;

    }

    //METODOS SEM BANCO
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
        if (this.TAF.getNome().getText().equals("")) {
            return false;
        } else if (this.TAF.getCpf().getText().equals("   .   .   -  ")) {
            return false;
        } else if (this.TAF.getEndereco().getText().equals("")) {
            return false;
        } else if (this.TAF.getEmail().getText().equals("")) {
            return false;
        } else if (this.TAF.getTelefone().getText().equals("(  )     -    ")) {
            return false;
        } else if (this.TAF.getHorasdetrabalho().getText().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean verificaEmail(String email) {
        try {
            int ve = email.indexOf("@");
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void limpar() {

        this.TAF.getCpf().setText("");
        this.TAF.getEmail().setText("");
        this.TAF.getEndereco().setText("");
        this.TAF.getHorasdetrabalho().setText("");
        this.TAF.getNome().setText("");
        this.TAF.getTelefone().setText("");

    }
}
