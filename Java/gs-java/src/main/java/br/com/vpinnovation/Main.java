package br.com.vpinnovation;

import br.com.vpinnovation.informacoes.Usuario;
import br.com.vpinnovation.recebeReport.Report;
import br.com.vpinnovation.recebeReport.SalvaJson;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Report report = new Report("");

        System.out.println("Bem vindo a central de atendimento dos mares e oceanos.");
        System.out.println("(1): Realizar um chamado um chamado");
        System.out.println("(2): Checar minha quantidade de pontos");
        System.out.println("Informe o que você deseja fazer: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha pendente

        if (opcao == 1) {
            System.out.println("Qual o motivo do seu chamado? (pesca ilegal, descarte de lixo, ajuda de animal): ");
            String descricao = scanner.nextLine();
            report.setDescricao(descricao);



            System.out.println("Informe o seu cpf: ");
            String cpf = scanner.nextLine();
            report.setCpf(cpf);
            System.out.println("Qual é o estado do ocorrido?: ");
            String estado = scanner.nextLine();
            report.setEstado(estado);
            System.out.println("Qual é a cidade do ocorrido?: ");
            String cidade = scanner.nextLine();
            report.setCidade(cidade);
            System.out.println("Qual é o bairro do ocorrido? (caso esteja dentro do mar deixe esse campo vazio): ");
            String bairro = scanner.nextLine();
            report.setBairro(bairro);
            System.out.println("Qual é a rua e um ponto de referência do local da ocorrencia? (caso esteja dentro do mar informe latitude e longitude nesse campo): ");
            String rua = scanner.nextLine();
            report.setRua(rua);
            System.out.println("Digite a data do acontecimento no formato dd/MM/yyyy:");
            String data = scanner.nextLine();
            report.setDataChamado(data);
            System.out.println("Descreva os detalhes da sua solicitação: ");
            String detalhesOcorrencia = scanner.nextLine();
            report.setDetalhesOcorrencia(detalhesOcorrencia);
            System.out.println("Obrigado pela solicitação. Caso a solicitação concretize alguma ajuda você ganhará 1 ponto no sistema. Esses pontos poderão ser trocados por descontos em algumas empresas");


            SalvaJson json = new SalvaJson(report);
            try {
                json.salvaJson();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else if (opcao == 2){
        Usuario usuario = new Usuario("");
        usuario.setQuantidadeReportsSolucionados(2);
        System.out.println("Informe sua quantidade de reports atendidos e solucionados: ");
        int quantidade = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha pendente
        if (usuario.quantidadeInformadaAtendimentosIsTrue(quantidade)) {
            double quantPontos = usuario.checagem(quantidade);
            System.out.println("Você possui R$" + quantPontos + " para troca. Você pode receber esse valor em desconto nas empresas parceiras a qualquer momento");
        } else {
            System.out.println("Você informou a quantidade errada de atendimentos informados.");
        }
        } else {
            throw new RuntimeException("Essa opção não existe");
        }
    }
}