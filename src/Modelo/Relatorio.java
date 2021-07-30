/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Emily Nunes
 */
public class Relatorio {
    private int nDoRelatorio;
    private String cpfTecnico;
    private String equipamentosReparados;
    private String problemaIdent;
    private String empresaSolicitante;
    private String nomeTecnico;
    private String componentesTrocados;
    private String solucao;
    private String dataRelatorio;

    public int getnDoRelatorio() {
        return nDoRelatorio;
    }

    public void setnDoRelatorio(int nDoRelatorio) {
        this.nDoRelatorio = nDoRelatorio;
    }

    public String getCpfTecnico() {
        return cpfTecnico;
    }

    public void setCpfTecnico(String cpfTecnico) {
        this.cpfTecnico = cpfTecnico;
    }


    public String getEquipamentosReparados() {
        return equipamentosReparados;
    }

    public void setEquipamentosReparados(String equipamentosReparados) {
        this.equipamentosReparados = equipamentosReparados;
    }

    public String getProblemaIdent() {
        return problemaIdent;
    }

    public void setProblemaIdent(String problemaIdent) {
        this.problemaIdent = problemaIdent;
    }

    public String getEmpresaSolicitante() {
        return empresaSolicitante;
    }

    public void setEmpresaSolicitante(String empresaSolicitante) {
        this.empresaSolicitante = empresaSolicitante;
    }

    public String getNomeTecnico() {
        return nomeTecnico;
    }

    public void setNomeTecnico(String nomeTecnico) {
        this.nomeTecnico = nomeTecnico;
    }

    public String getComponentesTrocados() {
        return componentesTrocados;
    }

    public void setComponentesTrocados(String componentesTrocados) {
        this.componentesTrocados = componentesTrocados;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public String getDataRelatorio() {
        return dataRelatorio;
    }

    public void setDataRelatorio(String dataRelatorio) {
        this.dataRelatorio = dataRelatorio;
    }

        
    
}
