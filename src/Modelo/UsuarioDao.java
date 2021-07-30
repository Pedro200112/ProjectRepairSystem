package Modelo;

/* import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement; */
 import java.sql.Connection;
import java.sql.PreparedStatement; 

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;

public class UsuarioDao {

    public void CriaUsuario(Funcionario F) {

        Connection conecta = Conexao.getConexao();
        PreparedStatement pst = null;

        try {

            String senhaAleatoria = null;

            senhaAleatoria = F.getCpf() + "senha";

            pst = (PreparedStatement) conecta.prepareStatement("INSERT INTO Usuario(usuario, senha, email, classficacao) VALUES (?,?,?,?)");

            pst.setString(1, F.getCpf());
            pst.setString(2, senhaAleatoria);
            pst.setString(3, F.getEmail());
            pst.setString(4, F.getClassificador());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, " USUÁRIO: " + F.getCpf() + " \n VOCÊ ESTÁ CADASTRADO NO REPAIR SYSTEM \n SUA SENHA:  " + senhaAleatoria, "ALERTA CADASTRO", INFORMATION_MESSAGE);

        } catch (SQLException var) {

            JOptionPane.showMessageDialog(null, "ERRO \n VERIFIQUE SE SEUS DADOS ESTÃO CORRETOS", "ALERTA CADASTRO", ERROR_MESSAGE);

        } finally {

            Conexao.closerConnection(conecta, pst);

        }

    }

    public void RecuperaSenha(Usuario U) {

        String receUser = JOptionPane.showInputDialog("DIGITE O USUÁRIO QUE DESEJA MODIFICAR A SENHA: ", WARNING_MESSAGE);

        String sql = "UPDATE Usuario SET senha = ? WHERE usuario = ?";

        PreparedStatement pst;

        try {

            pst = (PreparedStatement) Conexao.getConexao().prepareStatement(sql);

            pst.setString(1, U.getSenha());
            pst.setString(2, receUser);

            pst.execute();
            pst.close();

            JOptionPane.showMessageDialog(null, "SENHA ALTERADA!", "", INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "ERRO DE DADOS", "ALERTA DE RECUPERAÇÃO", ERROR_MESSAGE);

        }

    }

    public String senhaAdmin() throws SQLException {

        Connection Conecta = Conexao.getConexao();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String retornaSenha = null;

        try {

            pst = (PreparedStatement) Conecta.prepareStatement(" SELECT senha  FROM Usuario WHERE classficacao = 'Adm' ");

            rs = pst.executeQuery();

            while (rs.next()) {

                retornaSenha = rs.getString("senha");

            }

            rs.close();
            pst.close();

        } catch (SQLException ex) {

            throw new RuntimeException(ex);

        }

        return retornaSenha;

    }
    
    public boolean excluirUsuario(Usuario U){
        PreparedStatement pst;
        try{
            pst = Conexao.getConexao().prepareStatement("DELETE FROM usuario WHERE id = ?");
            pst.setInt(1, U.getCodigodeusuario());
            pst.execute();
            pst.close();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"ERRO AO DELETAR FUNCIONÁRIO - FDAO");
            System.out.println(ex);
            return false;
        }
        
        return true;
    }

}
