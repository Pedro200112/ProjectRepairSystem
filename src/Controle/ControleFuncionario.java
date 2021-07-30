package Controle;

import Modelo.Funcionario;
import Modelo.FuncionarioDao;
import Modelo.UsuarioDao;
import Visao.TelaAddFuncionario;
import Visao.TelaAtendente;
import Visao.TelaFuncionario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class ControleFuncionario implements ActionListener {

    //Cria as variáveis Tela mostra Funcionário, Regra Funcionário, Regra Login
    private final TelaAddFuncionario TAF;
    private final TelaFuncionario TF;
    private final RegraFuncionario RF;
    private final RegraLogin RL = null;
    String Classificacao = null;

    public ControleFuncionario() {

        this.TAF = new TelaAddFuncionario(null, true);
        this.TF = new TelaFuncionario(null, true);
        this.RF = new RegraFuncionario(TAF, TF);

        addListerners();

        this.TAF.setVisible(true);

        TAF.getNome().setEditable(true);
        TAF.getCpf().setEditable(true);
        TAF.getEndereco().setEditable(true);
        TAF.getEmail().setEditable(true);
        TAF.getTelefone().setEditable(true);
        TAF.getHorasdetrabalho().setEditable(true);

    }

    public void addListerners() {

        this.TAF.getBotaoExcluir().addActionListener(this);
        this.TAF.getBotaoSalvar().addActionListener(this);
        this.TAF.getBotonSair().addActionListener(this);
        this.TAF.getBotonEditar().addActionListener(this);
        //this.TAF.getBotaoVisualizar().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent var) {

        //Botão Excluir
        if (var.getSource().equals(this.TAF.getBotaoExcluir())) {
            if (RF.validarCampos()) {
                if (JOptionPane.showConfirmDialog(TAF, "Deseja realmente excluir?", "Confirmação de exclusão",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
                    this.RF.ExcluiFunc();
                    ControleMostraFuncionario CMF = new ControleMostraFuncionario();
                    this.TAF.dispose();
                }

            } else {
                JOptionPane.showMessageDialog(null, "REALIZE O CADASTRO DE ALGUM FUNCIONARIO PRIMEIRO", "ALERTA: ", JOptionPane.ERROR_MESSAGE);

            }
        } else if (var.getSource().equals(this.TAF.getBotaoSalvar())) {

            if (this.TAF.getMarcaAdm().isSelected()) {

                this.Classificacao = "Adm";

            } else if (this.TAF.getMarcaSuper().isSelected()) {

                this.Classificacao = "Supervisor";

            } else if (this.TAF.getMarcaTecni().isSelected()) {

                this.Classificacao = "Tecnico";

            } else if (this.TAF.getMarcaVende().isSelected()) {

                this.Classificacao = "Vendedor";

            } else {

                this.Classificacao = "Atendente";

            }

            boolean ver = false, testa = false;

            if (this.RF.validarCampos()) {

                ver = true;

            } else {

                JOptionPane.showMessageDialog(null, "TODOS OS CAMPOS DEVEM SER PREENCHIDOS!", "ALERTA: ", JOptionPane.ERROR_MESSAGE);

            }

            if (this.RF.validarCpf(TAF.getCpf().getText())) {

                testa = true;

            } else {

                JOptionPane.showMessageDialog(null, "SEU CPF NÃO É VÁLIDO \n TENTE NOVAMENTE OU DIRIGA-SE A RECEITA FEDERAL", "ERRO DE CADASTRO: ", JOptionPane.ERROR_MESSAGE);

            }

            if (ver == true && testa == true) {

                this.RF.adicionaFunc(Classificacao);

            }

            //Criar um Funcionário
        } //Botão Sair
        else if (var.getSource().equals(this.TAF.getBotonEditar())) {

            //Verifica qual rádio foi marcado
            //Se foi o Adm adiciona a classificação Adm
            if (this.TAF.getMarcaAdm().isSelected()) {

                this.Classificacao = "Adm";

            } else if (this.TAF.getMarcaSuper().isSelected()) {

                this.Classificacao = "Supervisor";

            } else if (this.TAF.getMarcaTecni().isSelected()) {

                this.Classificacao = "Tecnico";

            } else if (this.TAF.getMarcaVende().isSelected()) {

                this.Classificacao = "Vendedor";

            } else {

                this.Classificacao = "Atendente";

            }

            this.RF.editar(Classificacao);

            //Criar um Funcionário
        } //Botão Sair
        else if (var.getSource().equals(this.TAF.getBotonSair())) {

            //Ajuda ver quem fez o Login
            String rece = null;

            try {

                rece = this.RF.procuraLogin();

                if (rece.equals("Admnistrador")) {

                    ControleMostraFuncionario CMF = new ControleMostraFuncionario();

                    this.TAF.dispose();

                } else if (rece.equals("Atendente")) {

                    ControleAtendente CA = new ControleAtendente();

                    this.TAF.dispose();
                } else if (rece.equals("Supervisor")) {

                    ControleSupervisor CS = new ControleSupervisor();

                    this.TAF.dispose();

                } else if (rece.equals("Tecnico")) {

                    ControleTecnico CT = new ControleTecnico();

                    this.TAF.dispose();

                } else if (rece.equals("Vendedor")) {

                    ControleVendedor CV = new ControleVendedor();

                    this.TAF.dispose();
                }

                TAF.dispose();

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "ERRO", "XXXX", ERROR_MESSAGE);
            }

        }

    }

    public void setDados(Funcionario f) {

        this.TAF.limpar();

        TAF.getNome().setText(f.getNome());
        TAF.getCpf().setText(f.getCpf());
        TAF.getEndereco().setText(f.getEndereco());
        TAF.getEmail().setText(f.getEmail());
        TAF.getTelefone().setText(f.getTelefone());
        TAF.getHorasdetrabalho().setText(String.valueOf(f.getHorasTrabalhadas()));
        //FALTA O RADIO BUTTON

        //FALTA O RADIO BUTTON
    }

}
