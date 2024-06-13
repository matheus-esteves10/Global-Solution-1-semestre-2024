package br.com.vpinnovation.informacoes;

public class Usuario implements Checagem {
    private String cpf;
    private String email;
    private String senha;
    private int quantidadeReportsSolucionados;

    public Usuario(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (checagem(cpf)) {
            this.cpf = cpf;
        } else {
            throw new RuntimeException("CPF INVÁLIDO");
        }
    }

    public int getQuantidadeReportsSolucionados() {
        return quantidadeReportsSolucionados;
    }

    public void setQuantidadeReportsSolucionados(int quantidadeReportsSolucionados) {
        this.quantidadeReportsSolucionados = quantidadeReportsSolucionados;
    }

    public boolean quantidadeInformadaAtendimentosIsTrue(int quantidadeReportsSolucionados){ //método que verifica a validade da informação: quantidade de reports solucionados
        if (quantidadeReportsSolucionados == getQuantidadeReportsSolucionados()){
            return true;
        }
        return false;
    }

    @Override
    public double checagem(int quantidadeReportsSolucionados) { //método que retorna o benefício do usuário por report solucionado (50 centavos de desconto em parceiros por report)
        double valorPontos = quantidadeReportsSolucionados / 2.0;
        return valorPontos;
    }

    public boolean checagem(String cpf) { //método criado para checar a validade do cpf informado pelo usuário no momento de cadastro no sistema
        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11) {
            return false;
        }

        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int primeiroDigito = 11 - (soma % 11);
        if (primeiroDigito > 9) {
            primeiroDigito = 0;
        }

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        int segundoDigito = 11 - (soma % 11);
        if (segundoDigito > 9) {
            segundoDigito = 0;
        }

        return (Character.getNumericValue(cpf.charAt(9)) == primeiroDigito
                && Character.getNumericValue(cpf.charAt(10)) == segundoDigito);
    }
}
