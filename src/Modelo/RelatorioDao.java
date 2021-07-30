/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 *
 * @author Emily Nunes
 */
public class RelatorioDao {

    public void criaRelatorio(Relatorio R) {
        String sql = "INSERT INTO Relatorio(nDoRelatorio,cpfTecnico,equipamentosReparados,problemaIdent,empresaSolicitante,nomeTecnico,ComponentesTrocados,solucao,dataRelatorio)VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst;

        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, R.getnDoRelatorio());
            pst.setString(2, R.getCpfTecnico());
            pst.setString(3, R.getEquipamentosReparados());
            pst.setString(4, R.getProblemaIdent());
            pst.setString(5, R.getEmpresaSolicitante());
            pst.setString(6, R.getNomeTecnico());
            pst.setString(7, R.getComponentesTrocados());
            pst.setString(8, R.getSolucao());
            pst.setString(9, R.getDataRelatorio());

            pst.executeUpdate();
            pst.close();

            JOptionPane.showMessageDialog(null, "RELATORIO CRIADO COM SUCESSO!!", "ALERTA:", INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "VERIFIQUE SE SEUS DADOS ESTÃO CORRETOS", "ALERTA!", ERROR_MESSAGE);
        }
    }

    public ArrayList<Relatorio> mostraRela() {
        String sql = "SELECT * FROM Relatorio";

        ArrayList<Relatorio> lista = new ArrayList<>();

        PreparedStatement pst;
        ResultSet rs;

        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                
                Relatorio r = new Relatorio();
                
                r.setnDoRelatorio(rs.getInt("nDoRelatorio"));
                r.setCpfTecnico(rs.getString("cpfTecnico"));
                r.setEquipamentosReparados(rs.getString("equipamentosReparados"));
                r.setProblemaIdent(rs.getString("problemaIdent"));
                r.setEmpresaSolicitante(rs.getString("empresaSolicitante"));
                r.setNomeTecnico(rs.getString("nomeTecnico"));
                r.setComponentesTrocados(rs.getString("componentesTrocados"));
                r.setSolucao(rs.getString("solucao"));
                r.setDataRelatorio(rs.getString("dataRelatorio"));
                lista.add(r);
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return lista;
    }

    public ArrayList<Relatorio> pesquisar(int id) {
        String sql = "SELECT * FROM Relatorio WHERE nDoRelatorio LIKE ? ORDER BY nDoRelatorio";

        ArrayList<Relatorio> listagem = new ArrayList<>();

        PreparedStatement pst;
        ResultSet rs;

        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                Relatorio r = new Relatorio();

                r.setnDoRelatorio(rs.getInt("nDoRelatorio"));
                r.setCpfTecnico(rs.getString("cpfTecnico"));
                r.setEquipamentosReparados(rs.getString("equipamentosReparados"));
                r.setProblemaIdent(rs.getString("problemaIdent"));
                r.setEmpresaSolicitante(rs.getString("empresaSolicitante"));
                r.setNomeTecnico(rs.getString("nomeTecnico"));
                r.setComponentesTrocados(rs.getString("ComponentesTrocados"));
                r.setSolucao(rs.getString("solucao"));
                r.setDataRelatorio(rs.getString("dataRelatorio"));

                listagem.add(r);
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listagem;
    }

    public void editar(Relatorio R) {
        String sql = "UPDATE Relatorio SET nDoRelatorio=?,cpfTecnico=?,equipamentosReparados=?,problemaIdent=?,empresaSolicitante=?,nomeTecnico=?,ComponentesTrocados=?,solucao=?,dataRelatorio=? WHERE nDoRelatorio=?";
        PreparedStatement pst;
        
        
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, R.getnDoRelatorio());
            pst.setString(2, R.getCpfTecnico());
            pst.setString(3, R.getEquipamentosReparados());
            pst.setString(4, R.getProblemaIdent());
            pst.setString(5, R.getEmpresaSolicitante());
            pst.setString(6, R.getNomeTecnico());
            pst.setString(7, R.getComponentesTrocados());
            pst.setString(8, R.getSolucao());
            pst.setString(9, R.getDataRelatorio());
            pst.setInt(10, R.getnDoRelatorio());

            pst.execute();
            pst.close();

            JOptionPane.showMessageDialog(null, "RELATORIO ATUALIZADO COM SUCESSO!!", "ALERTA: RDAO", INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO ATUALIZAR", "ALERA: RDAO", ERROR_MESSAGE);
        }
                
    }
    
    
    
    public Relatorio pesquisa(int id){
        
        String sql = "SELECT * FROM Relatorio WHERE nDoRelatorio=?";
        
        Relatorio r = new Relatorio();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try{
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            
            while(rs.next()){
                r.setnDoRelatorio(rs.getInt("nDoRelatorio"));
                r.setCpfTecnico(rs.getString("cpfTecnico"));
                r.setEquipamentosReparados(rs.getString("equipamentosReparados"));
                r.setProblemaIdent(rs.getString("problemaIdent"));
                r.setEmpresaSolicitante(rs.getString("empresaSolicitante"));
                r.setNomeTecnico(rs.getString("nomeTecnico"));
                r.setComponentesTrocados(rs.getString("ComponentesTrocados"));
                r.setSolucao(rs.getString("solucao"));
                r.setDataRelatorio(rs.getString("dataRelatorio"));
            }
            
            rs.close();
            pst.close();
        
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return r;
    }
    
    public boolean excluir (int relatorio){
        String sql = "DELETE FROM Relatorio WHERE nDoRelatorio=?";
        PreparedStatement pst;
        
        try{
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, relatorio);
            pst.execute();
            pst.close();
            
            JOptionPane.showMessageDialog(null, "FUNCIONÁRIO EXCLUÍDO! ", "ALERTA: RDAO ", INFORMATION_MESSAGE);
        
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR! ", "ALERTA: RDAO ", INFORMATION_MESSAGE);
            System.out.println(ex);
            return false;
        }
        
        return true;
        
    }

}
