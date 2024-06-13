package br.com.vpinnovation.informacoes;

public class UnidadeAutoridade implements Checagem {

    private String nomeUnidade;
    private String telefone;
    private String endereco;
    private String tipoUnidade;
    private int quantidadeReportsSolucionados;

    public UnidadeAutoridade(String nomeUnidade, String telefone, String endereco, String tipoUnidade) {
        this.nomeUnidade = nomeUnidade;
        this.telefone = telefone;
        this.endereco = endereco;
        this.tipoUnidade = tipoUnidade;
    }
    public String getNomeUnidade() {
        return nomeUnidade;
    }

    public void setNomeUnidade(String nomeUnidade) {
        this.nomeUnidade = nomeUnidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipoUnidade() {
        return tipoUnidade;
    }

    public void setTipoUnidade(String tipoUnidade) {
        this.tipoUnidade = tipoUnidade;
    }

    public int getQuantidadeReportsAtendidos() {
        return quantidadeReportsSolucionados;
    }

    public void setQuantidadeReportsAtendidos(int quantidadeReportsAtendidos) {
        this.quantidadeReportsSolucionados = quantidadeReportsAtendidos;
    }

    @Override // a unidade que mais resolver chamados no ano receberá a bonificação descrita do método (5 reais por report solucionado). Esse método é válido somente para a unidade CAMPEÃ.
    public double checagem(int quantidadeReportsSolucionados) {
        int valorBonusUnidade = quantidadeReportsSolucionados * 5;
        return  valorBonusUnidade;
    }
}
