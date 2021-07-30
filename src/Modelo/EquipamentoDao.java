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

public class EquipamentoDao {

    public void criaEquipamento(Equipamento E) {

        Connection conecta = Conexao.getConexao();
        PreparedStatement pst = null;

        try {

            pst = (PreparedStatement) conecta.prepareStatement("INSERT INTO Equipamento(nManutencao, nSerie, tipoEquipamento, valorAssociado, nomeEquipamento, nContrato, DataFabrica, parcelaPagamento) VALUES (?,?,?,?,?,?,?,?)");

            pst.setInt(1, E.getnManutencao());
            pst.setInt(2, E.getnSerie());
            pst.setString(3, E.getTipoEquipamento());
            pst.setInt(4, E.getValorAssociado());
            pst.setString(5, E.getNomeEquipamento());
            pst.setInt(6, E.getnContrato());
            pst.setString(7, E.getAtaFabrica());
            pst.setInt(8, E.getParcelaPagamento());

            //nSerie tipoEquipamento valorAssociado nomeEquipamento nContrato  DataFabrica  parcelaPagamento   
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, " \n EQUIPAMENTO CADASTRADO \n", "ALERTA:", INFORMATION_MESSAGE);

        } catch (SQLException var) {

            JOptionPane.showMessageDialog(null, "ERRO \n VERIFIQUE SE SEUS DADOS ESTÃO CORRETOS", "ALERTA CADASTRO", ERROR_MESSAGE);

        } finally {

            Conexao.closerConnection(conecta, pst);

        }

    }

    public ArrayList<Equipamento> mostraEquipa() {

        String sql = "SELECT * FROM Equipamento ORDER BY nSerie, nomeEquipamento, nContrato, valorAssociado";

        ArrayList<Equipamento> lista = new ArrayList<>();

        PreparedStatement pst;
        ResultSet rs;

        try {

            pst = (PreparedStatement) Conexao.getConexao().prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {

                Equipamento cont = new Equipamento();

                cont.setnSerie(Integer.parseInt(rs.getString("nSerie")));
                cont.setNomeEquipamento(rs.getString("nomeEquipamento"));
                cont.setnContrato(Integer.parseInt(rs.getString("nContrato")));
                cont.setValorAssociado(Integer.parseInt((rs.getString("valorAssociado"))));

                lista.add(cont);
            }

            rs.close();
            pst.close();

        } catch (SQLException ex) {

            System.out.println(ex);
        }

        return lista;
    }

    public ArrayList<Equipamento> pesquisar(String nome) {

        ArrayList<Equipamento> lista = new ArrayList<>();

        PreparedStatement pst;
        ResultSet rs;

        try {

            String sql = "SELECT * FROM Equipamento WHERE nomeEquipamento LIKE ? ORDER BY nSerie,nomeEquipamento,nContrato,nSerie ";

            pst = Conexao.getConexao().prepareStatement(sql);

            pst.setString(1, "%"+nome+"%");

            rs = pst.executeQuery();

            Equipamento E = new Equipamento();

            while (rs.next()) {

                E.setnManutencao(rs.getInt("nManutencao"));
                E.setnSerie(rs.getInt("nSerie"));
                E.setTipoEquipamento(rs.getString("tipoEquipamento"));
                E.setValorAssociado(rs.getInt("valorAssociado"));
                E.setNomeEquipamento(rs.getString("nomeEquipamento"));
                E.setnContrato(rs.getInt("nContrato"));
                E.setAtaFabrica(rs.getString("DataFabrica"));
                E.setParcelaPagamento(rs.getInt("parcelaPagamento"));

                lista.add(E);

            }
            rs.close();
            pst.close();

        } catch (SQLException var) {

            JOptionPane.showMessageDialog(null, "VERIFIQUE SE OS DADOS ESTÃO CORRETOS", "ALERTA: EDAO", ERROR_MESSAGE);

        }

        return lista;
    }

    public void editar(Equipamento E) {
        String sql = "UPDATE Equipamento SET nManutencao=?,nSerie=?,tipoEquipamento=?,valorAssociado=?,nomeEquipamento=?,nContrato=?,DataFabrica=?,parcelaPagamento=? WHERE nManutencao=?";

        PreparedStatement pst;

        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, E.getnManutencao());
            pst.setInt(2, E.getnSerie());
            pst.setString(3, E.getTipoEquipamento());
            pst.setInt(4, E.getValorAssociado());
            pst.setString(5, E.getNomeEquipamento());
            pst.setInt(6, E.getnContrato());
            pst.setString(7, E.getAtaFabrica());
            pst.setInt(8, E.getParcelaPagamento());
            pst.setInt(9, E.getnManutencao());
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "EQUIPAMENTO ATUALIZADO COM SUCESSO!!", "ALERTA: ", INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO ATUALIZAR", "ALERA: EDAO", ERROR_MESSAGE);
        }
    }

    public Equipamento pesquisa(int id) {
        String sql = "SELECT * FROM Equipamento WHERE nSerie = ?";

        Equipamento e = new Equipamento();

        PreparedStatement pst;
        ResultSet rs;

        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                e.setnManutencao(rs.getInt("nManutencao"));
                e.setnSerie(rs.getInt("nSerie"));
                e.setTipoEquipamento(rs.getString("tipoEquipamento"));
                e.setValorAssociado(rs.getInt("valorAssociado"));
                e.setNomeEquipamento(rs.getString("nomeEquipamento"));
                e.setnContrato(rs.getInt("nContrato"));
                e.setAtaFabrica(rs.getString("DataFabrica"));
                e.setParcelaPagamento(rs.getInt("parcelaPagamento"));
            }

            rs.close();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return e;
    }

    public boolean excluir(int E) {
        String sql = "DELETE FROM Equipamento WHERE nManutencao=?";
        PreparedStatement pst;

        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, E);
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "EQUIPAMENTO EXCLUÍDO! ", "ALERTA: EDAO", INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR O EQUIPAMENTO", "ALERTA: EDAO", ERROR_MESSAGE);
            return false;
        }
        return true;
    }

}
