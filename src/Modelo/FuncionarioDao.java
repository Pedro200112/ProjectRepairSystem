package Modelo;

/*import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;*/
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

public class FuncionarioDao {

    public void criaFuncionario(Funcionario F) {

        Connection conecta = Conexao.getConexao();
        PreparedStatement pst = null;

        try {

            pst = (PreparedStatement) conecta.prepareStatement("INSERT INTO Funcionario(cpf, nome, email, endereco, telefone, horastrabalhadas, classificacao) VALUES (?,?,?,?,?,?,?)");

            pst.setString(1, F.getCpf());
            pst.setString(2, F.getNome());
            pst.setString(3, F.getEmail());
            pst.setString(4, F.getEndereco());
            pst.setString(5, F.getTelefone());
            pst.setInt(6, F.getHorasTrabalhadas());
            pst.setString(7, F.getClassificador());

            pst.executeUpdate();

            UsuarioDao UD = new UsuarioDao();

            UD.CriaUsuario(F);

        } catch (SQLException var) {

            JOptionPane.showMessageDialog(null, "ERRO \n SEUS DADOS ESTÃO CORRETOS? \n EXISTE CPF DUPLICADO? \n ", "ALERTA CADASTRO", ERROR_MESSAGE);

        } finally {

            Conexao.closerConnection(conecta, pst);

        }

    }

    public ArrayList<Funcionario> mostraFunc() {

        String sql = "SELECT * FROM Funcionario ORDER BY cpf,classificacao,nome";

        ArrayList<Funcionario> lista = new ArrayList<>();

        PreparedStatement pst;
        ResultSet rs;

        try {
            pst = (PreparedStatement) Conexao.getConexao().prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {

                Funcionario cont = new Funcionario();

                cont.setCpf(rs.getString("cpf"));
                cont.setClassificador(rs.getString("classificacao"));
                cont.setNome((rs.getString("nome")));

                lista.add(cont);
            }

            rs.close();
            pst.close();

        } catch (SQLException ex) {

            System.out.println(ex);

        }

        return lista;
    }

    public ArrayList<Funcionario> pesquisar(String nome) {

        ArrayList<Funcionario> lista = new ArrayList<>();

        PreparedStatement pst;
        ResultSet rs;

        try {

            String sql = "SELECT * FROM Funcionario WHERE nome LIKE ? ORDER BY nome,cpf";

            pst = Conexao.getConexao().prepareStatement(sql);

            pst.setString(1, "%" + nome + "%");

            rs = pst.executeQuery();

            Funcionario F = new Funcionario();

            while (rs.next()) {

                F.setCpf(rs.getString("cpf"));
                F.setNome(rs.getString("nome"));
                F.setEmail(rs.getString("email"));
                F.setEndereco(rs.getString("endereco"));
                F.setTelefone(rs.getString("telefone"));
                F.setHorasTrabalhadas(rs.getInt("horasTrabalhadas"));
                F.setClassificador(rs.getString("classificacao"));

                lista.add(F);

            }
            rs.close();
            pst.close();

        } catch (SQLException var) {

            JOptionPane.showMessageDialog(null, "ERRO \n VERIFIQUE SE OS DADOS ESTÃO CORRETOS", "ALERTA:", ERROR_MESSAGE);

        }

        return lista;

    }

    public Funcionario pesquisa(String cpf) {
        
        String sql = "SELECT * FROM Funcionario WHERE cpf = ?";

        Funcionario func = new Funcionario();

        PreparedStatement pst;
        ResultSet rs;

        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, cpf);
            rs = pst.executeQuery();

            while (rs.next()) {
                func.setCpf(rs.getString("cpf"));
                func.setNome(rs.getString("nome"));
                func.setEmail(rs.getString("email"));
                func.setEndereco(rs.getString("endereco"));
                func.setTelefone(rs.getString("telefone"));
                func.setHorasTrabalhadas(rs.getInt("horasTrabalhadas"));
                func.setClassificador(rs.getString("classificacao"));
            }

            rs.close();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return func;
    }

    public void editar(Funcionario F) {
        
        String sql = "UPDATE Funcionario SET nome =?, email=?, endereco=?,telefone=?,horasTrabalhadas=?,classificacao=? WHERE cpf=?";

        PreparedStatement pst = null;

        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            
            pst.setString(1, F.getNome());
            pst.setString(2, F.getEmail());
            pst.setString(3, F.getEndereco());
            pst.setString(4, F.getTelefone());
            pst.setInt(5, F.getHorasTrabalhadas());
            pst.setString(6, F.getClassificador());
            pst.setString(7, F.getCpf());

            pst.execute();
            pst.close();
            
            JOptionPane.showMessageDialog(null, "EDIÇÃO FINALIZADA! ", "AVISO: ", INFORMATION_MESSAGE);

        } catch (SQLException var) {

            JOptionPane.showMessageDialog(null, "ERRO AO EDITAR!", "ERRO FDAO", ERROR_MESSAGE);

        }

    }

    public boolean excluir(String pegacpf) {
        
        String sql = "DELETE FROM Funcionario WHERE cpf = ?";
        PreparedStatement pst;
        
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, pegacpf);
            pst.execute();
            pst.close();
            
            JOptionPane.showMessageDialog(null, "FUNCIONÁRIO EXCLUÍDO! ", "AVISO: ", INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO DELETAR FUNCIONÁRIO", "AVISO! ", ERROR_MESSAGE);
            System.out.println(ex);
            return false;
        }
        return true;
    }

    public ArrayList<Funcionario> mostraTecn() {

        String sql = "SELECT * FROM Funcionario WHERE classificacao = 'Tecnico'";

        ArrayList<Funcionario> lista = new ArrayList<>();

        PreparedStatement pst;
        ResultSet rs;

        try {
            pst = (PreparedStatement) Conexao.getConexao().prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {

                Funcionario cont = new Funcionario();

                cont.setCpf(rs.getString("cpf"));
                cont.setClassificador(rs.getString("classificacao"));
                cont.setNome((rs.getString("nome")));

                lista.add(cont);
            }

            rs.close();
            pst.close();

        } catch (SQLException ex) {

            System.out.println(ex);

        }

        return lista;
    }
}
