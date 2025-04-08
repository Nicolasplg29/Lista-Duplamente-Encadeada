import java.io.*;
import java.util.Scanner;

public class ListaRotas {
    private Rota inicio;
    private Rota fim;

    public void inserirRota(String codigo, String tipo, String origem, String destino) {
        Rota nova = new Rota(codigo, tipo, origem, destino);
        if (fim != null) {
            fim.prox = nova;
            nova.ant = fim;
        } else {
            inicio = nova;
        }
        fim = nova;
    }

    public void carregarRotas(String nomeArquivo, String tipoFiltro) {
        try (Scanner scanner = new Scanner(new File(nomeArquivo))) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] dados = linha.split(";");
                if (dados.length == 4 && dados[1].equalsIgnoreCase(tipoFiltro)) {
                    inserirRota(dados[0], dados[1], dados[2], dados[3]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + nomeArquivo);
        }
    }

    public void exibirRotas(boolean ida) {
        if (inicio == null) {
            System.out.println("Nenhuma rota cadastrada.");
            return;
        }

        Rota atual = ida ? inicio : fim;
        System.out.println("\nRotas (" + (ida ? "Ida" : "Volta") + "):");
        while (atual != null) {
            System.out.printf("[%s] %s: %s -> %s\n", atual.codigo, atual.tipo, atual.origem, atual.destino);
            atual = ida ? atual.prox : atual.ant;
        }
    }
}
