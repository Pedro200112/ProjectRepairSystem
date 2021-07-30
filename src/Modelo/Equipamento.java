
package Modelo;

public class Equipamento {
    
    
    int nManutencao;
    int nSerie ;
    String tipoEquipamento; 
    int valorAssociado;
    String nomeEquipamento;
    int nContrato;
    String ataFabrica;
    int parcelaPagamento;

    public int getnManutencao() {
        return nManutencao;
    }

    public void setnManutencao(int nManutencao) {
        this.nManutencao = nManutencao;
    }

    public int getnSerie() {
        return nSerie;
    }

    public void setnSerie(int nSerie) {
        this.nSerie = nSerie;
    }

    

    public String getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(String tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public int getValorAssociado() {
        return valorAssociado;
    }

    public void setValorAssociado(int valorAssociado) {
        this.valorAssociado = valorAssociado;
    }

    public String getNomeEquipamento() {
        return nomeEquipamento;
    }

    public void setNomeEquipamento(String nomeEquipamento) {
        this.nomeEquipamento = nomeEquipamento;
    }

    public int getnContrato() {
        return nContrato;
    }

    public void setnContrato(int nContrato) {
        this.nContrato = nContrato;
    }

    public String getAtaFabrica() {
        return ataFabrica;
    }

    public void setAtaFabrica(String ataFabrica) {
        this.ataFabrica = ataFabrica;
    }

    public int getParcelaPagamento() {
        return parcelaPagamento;
    }

    public void setParcelaPagamento(int parcelaPagamento) {
        this.parcelaPagamento = parcelaPagamento;
    }
    
    
    
}
