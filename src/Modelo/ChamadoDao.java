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

public class ChamadoDao {

    public void CriaChamado(Chamado C) {

        Connection conecta = Conexao.getConexao();
        PreparedStatement pst = null;

        try {
            pst = (PreparedStatement) conecta.prepareStatement("INSERT INTO Chamado(nChamado, nomeEmpresa, idEquipamento, motivoChamada, dataAtendimento) VALUES (?,?,?,?,?)");
            pst.setInt(1, C.getnChamado());
            pst.setString(2, C.getNomeEmpresa());
            pst.setInt(3, C.getIdEquipamento());
            pst.setString(4, C.getMotivoChamada());
            pst.setString(5, C.getDataentendimento());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, " \n CHAMADO ENCAMINHADO! ", "ALERTA DE CHAMADO:", INFORMATION_MESSAGE);

        } catch (SQLException var) {

            JOptionPane.showMessageDialog(null, "ERRO \n VERIFIQUE SE OS DADOS ESTÃO CORRETOS", "ALERTA:", ERROR_MESSAGE);

        } finally {

            Conexao.closerConnection(conecta, pst);

        }

    }
    
    

    public ArrayList<Chamado> mostraChama() {

        String sql = "SELECT * FROM Chamado ORDER BY nChamado, nomeEmpresa";

        ArrayList<Chamado> lista = new ArrayList<>();

        PreparedStatement pst;
        ResultSet rs;

        try {
            pst = (PreparedStatement) Conexao.getConexao().prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {

                Chamado cont = new Chamado();

                cont.setnChamado(Integer.parseInt(rs.getString("nChamado")));
                cont.setNomeEmpresa(rs.getString("nomeEmpresa"));

                lista.add(cont);
            }

            rs.close();
            pst.close();

        } catch (SQLException ex) {

            System.out.println(ex);

        }

        return lista;
    }

    public ArrayList<Chamado> pesquisar(int id) {

        ArrayList<Chamado> lista = new ArrayList<>();

        PreparedStatement pst;
        ResultSet rs;

        try {

            String sql = "SELECT * FROM Chamado WHERE nChamado = ?";

            pst = Conexao.getConexao().prepareStatement(sql);

            pst.setInt(1, id);

            rs = pst.executeQuery();

            Chamado C = new Chamado();

            while (rs.next()) {

                C.setnChamado(rs.getInt("nChamado"));
                C.setNomeEmpresa(rs.getString("nomeEmpresa"));
                C.setIdEquipamento(rs.getInt("idEquipamento"));
                C.setMotivoChamada(rs.getString("motivoChamada"));
                C.setDataentendimento(rs.getString("dataAtendimento"));

                lista.add(C);

            }
            rs.close();
            pst.close();

        } catch (SQLException var) {

            JOptionPane.showMessageDialog(null, "ERRO \n VERIFIQUE SE OS DADOS ESTÃO CORRETOS", "ALERTA:", ERROR_MESSAGE);

        }

        return lista;

    }

    public Chamado pesquisa(int id) {
        
        String sql = "SELECT * FROM Chamado WHERE nChamado = ?";

        Chamado C = new Chamado();

        PreparedStatement pst;
        ResultSet rs;

        try {
            
            pst = Conexao.getConexao().prepareStatement(sql);
            
            pst.setInt(1, id);
            
            rs = pst.executeQuery();

            while (rs.next()) {
                C.setnChamado(rs.getInt("nChamado"));
                C.setNomeEmpresa(rs.getString("nomeEmpresa"));
                C.setIdEquipamento(rs.getInt("idEquipamento"));
                C.setMotivoChamada(rs.getString("motivoChamada"));
                C.setDataentendimento(rs.getString("dataAtendimento"));
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return C;
    }

    public void editar(Chamado C) {
        
        String sql = "UPDATE Chamado SET nomeEmpresa=?, idEquipamento=?, motivoChamada=?, dataAtendimento=? WHERE nChamado=?";

        PreparedStatement pst = null;

        try {
            
            pst = Conexao.getConexao().prepareStatement(sql);
            
            pst.setString(1, C.getNomeEmpresa());
            pst.setInt(2, C.getIdEquipamento());
            pst.setString(3, C.getMotivoChamada());
            pst.setString(4, C.getDataentendimento());
            pst.setInt(5, C.getnChamado());

            pst.execute();
            pst.close();
            
             JOptionPane.showMessageDialog(null, "EDIÇÃO FINALIZADA! ", "AVISO: ", INFORMATION_MESSAGE);


        } catch (SQLException var) {

            JOptionPane.showMessageDialog(null, "ERRO AO EDITAR!", "ALERTA: ", ERROR_MESSAGE);

        }
    }

    public boolean excluir(int peganChamado) {
        
        String sql = "DELETE FROM Chamado WHERE nChamado = ?";
        
        PreparedStatement pst;
        
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, peganChamado);
            pst.execute();
            pst.close();
            
            JOptionPane.showMessageDialog(null, "CHAMADO DELETADO!", "ALERTA:", INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "ERRO AO DELETAR CHAMADO!", "ALERTA:", ERROR_MESSAGE);
            System.out.println(ex);
            return false;
        }

        return true;
    }

}
