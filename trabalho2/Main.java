import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaRotas lista = new ListaRotas();
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o tipo de transporte (Ônibus ou Metrô): ");
        String tipo = input.nextLine();

        lista.carregarRotas("rotas_de_transportes.txt", tipo);

        int opcao;
        do {
            System.out.println("\nMENU:");
            System.out.println("1 - Exibir rotas (Ida)");
            System.out.println("2 - Exibir rotas (Volta)");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1 -> lista.exibirRotas(true);
                case 2 -> lista.exibirRotas(false);
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);
    }
}
