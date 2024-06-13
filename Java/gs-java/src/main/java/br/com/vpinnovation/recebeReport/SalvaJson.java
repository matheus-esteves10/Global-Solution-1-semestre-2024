package br.com.vpinnovation.recebeReport;

import br.com.vpinnovation.recebeReport.Report;
import br.com.vpinnovation.recebeReport.ReportJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;


public class SalvaJson {
    private ReportJson reportJson;
    private Report report;
    public SalvaJson(Report report) {
        this.report = report;
        report.setNumeroProtocolo();
        reportJson = new ReportJson(report.getCpf(), report.getEstado(), report.getCidade(), report.getBairro(), report.getRua(), report.getDataChamado(), report.getDescricao(), report.getDetalhesOcorrencia(), report.getNumeroProtocolo());
    }

    public void salvaJson() throws IOException { //método que nomeia e salva as informações do chamado em um json (simulação de banco de dados)
        Report report = new Report("");
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String nomeArquivo;

        if (report.tipoReport(this.reportJson.descricao()) == 0) {
            nomeArquivo = "pescaIlegal" + this.reportJson.numeroProtocolo() + ".json";
        } else if (report.tipoReport(this.reportJson.descricao()) == 1) {
            nomeArquivo = "descarteDeLixo" + this.reportJson.numeroProtocolo() + ".json";
        } else if (report.tipoReport(this.reportJson.descricao()) == 2) {
            nomeArquivo = "resgateAnimal" + this.reportJson.numeroProtocolo() + ".json";
        } else {
            throw new IllegalArgumentException("Tipo de report desconhecido");
        }

        String finalSave = nomeArquivo;


        String json = gson.toJson(reportJson);


        try (FileWriter escrita = new FileWriter(finalSave)) {
            escrita.write(json);
        }
    }
}


