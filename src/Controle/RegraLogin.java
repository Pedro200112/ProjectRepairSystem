package Controle;

import Modelo.Login;
import Modelo.LoginDao;
import Modelo.Usuario;
import Visao.TelaLogin;
import Visao.TelaPrincipal;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class RegraLogin {

    private final TelaLogin TL;
    private LoginDao LD;

    RegraLogin(TelaLogin TL1) {

        this.TL = TL1;
        this.LD = new LoginDao();

    }

    public void acesso() throws SQLException {

        //Cria variável da classe Login e da classe LoginDao
        Login L = new Login();
        LoginDao LD = new LoginDao();
        
        //Pega os valores dos campos da tela Login (Usuario, Senha)
        L.setUsuario((TL.getCnpj().getText()));
        L.setSenha(TL.getCamposenha().getText());

        //Ele ajuda no processo de Login 
        boolean verifica = false;

        //Eele ajuda no processo de Login
        String verifiTipo = null;

        for (Usuario i : LD.LeituradoLogin(L)) {

            if (L.getUsuario().equals(i.getUsuario()) && i.getSenha().equals(L.getSenha()) && i.getClassificador().equals("Adm")) {

                //Se todos os dados forem equivalentes pode gerar o login
                verifica = true;

                //Quem entra é o administrador
                verifiTipo = "Admnistrador";

                //Classificacao de Login recebe administrador
                L.setClassificacao(verifiTipo);

                //Cria Login
                cria(L);

            } else if (L.getUsuario().equals(i.getUsuario()) && i.getSenha().equals(L.getSenha()) && i.getClassificador().equals("Atendente")) {

                verifica = true;

                verifiTipo = "Atendente";

                L.setClassificacao(verifiTipo);

                cria(L);

            } else if (L.getUsuario().equals(i.getUsuario()) && i.getSenha().equals(L.getSenha()) && i.getClassificador().equals("Supervisor")) {

                verifica = true;

                verifiTipo = "Supervisor";

                L.setClassificacao(verifiTipo);

                cria(L);

            } else if (L.getUsuario().equals(i.getUsuario()) && i.getSenha().equals(L.getSenha()) && i.getClassificador().equals("Vendedor")) {

                verifica = true;

                verifiTipo = "Vendedor";

                L.setClassificacao(verifiTipo);

                cria(L);

            } else if (L.getUsuario().equals(i.getUsuario()) && i.getSenha().equals(L.getSenha()) && i.getClassificador().equals("Tecnico")) {

                verifica = true;

                verifiTipo = "Tecnico";

                L.setClassificacao(verifiTipo);

                cria(L);

            }

        }

        if (verifica == false) {

            JOptionPane.showMessageDialog(null, "LOGIN NÃO ENCONTRADO \n VOCÊ POSSUI LOGIN?", "ALERTA DE LOGIN", ERROR_MESSAGE);

            //Volta pra tela de Login
            ControleLogin CL = new ControleLogin();

        }

        if (verifica == true && verifiTipo.equals("Admnistrador")) {

            //Se Login de Adm abre Adm
            ControlePrincipal CP = new ControlePrincipal();

        } else if (verifica == true && verifiTipo.equals("Atendente")) {

            //Se Login de Atendente abre Atendente
            ControleAtendente CA = new ControleAtendente();

        } else if (verifica == true && verifiTipo.equals("Supervisor")) {

            ControleSupervisor CS = new ControleSupervisor();

        } else if (verifica == true && verifiTipo.equals("Tecnico")) {

            ControleTecnico CT = new ControleTecnico();

        } else if (verifica == true && verifiTipo.equals("Vendedor")) {

            ControleVendedor CV = new ControleVendedor();

        }

    }

    public void cria(Login L) throws SQLException {

        LoginDao LD = new LoginDao();

        LD.CriaLogin(L);

    }

    public void truncateLogin() {

        LoginDao LD = new LoginDao();

        LD.truncaLogin();

    }

}
