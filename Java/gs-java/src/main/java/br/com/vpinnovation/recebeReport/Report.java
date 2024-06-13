package br.com.vpinnovation.recebeReport;

import br.com.vpinnovation.informacoes.Usuario;

import java.util.Random;

public class Report extends Usuario {
    private int numeroProtocolo;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String dataChamado;
    private String descricao;
    private String detalhesOcorrencia;


    public Report(String cpf, String estado, String cidade, String bairro, String rua, String dataChamado, String descricao, String detalhesOcorrencia) {
        super(cpf);
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.dataChamado = dataChamado;
        this.descricao = descricao;
        this.detalhesOcorrencia = detalhesOcorrencia;
    }

    public Report(String cpf) {
        super(cpf);
    }

    public int getNumeroProtocolo() {
        return numeroProtocolo;
    }

    public void setNumeroProtocolo() {
        if(this.numeroProtocolo == 0) { // Verifica se o número de protocolo ainda não foi atribuído
            Random random = new Random();
            int numeroProtocoloAleatorio = random.nextInt(99999) + 1;
            this.numeroProtocolo = numeroProtocoloAleatorio;
        }
    }

    public void setNumeroProtocolo(int numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getDataChamado() {
        return dataChamado;
    }

    public void setDataChamado(String dataChamado) {
        this.dataChamado = dataChamado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDetalhesOcorrencia() {
        return detalhesOcorrencia;
    }

    public void setDetalhesOcorrencia(String detalhesOcorrencia) {
        this.detalhesOcorrencia = detalhesOcorrencia;
    }

    public double tipoReport(String descricao) { //método que verifica o tipo de chamado para futuramente nomear corretamente o arquivo json
        if (descricao.equalsIgnoreCase("Pesca ilegal")) {
            return 0;
        } else if (descricao.equalsIgnoreCase("Descarte de lixo")) {
            return 1;
        } else if (descricao.equalsIgnoreCase("Ajuda de animal")) {
            return 2;
        } else {
            return 3;
        }
    }
}
