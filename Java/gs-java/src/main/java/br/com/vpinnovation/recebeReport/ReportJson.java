package br.com.vpinnovation.recebeReport;

public record ReportJson(String cpf, String estado, String cidade, String bairro, String rua, String dataChamado, String descricao, String detalhesOcorrencia, int numeroProtocolo) {
}
