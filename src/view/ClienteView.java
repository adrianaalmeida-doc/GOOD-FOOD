import java.util.Scanner;
import java.util.List;

public class ClienteView {
    private ClienteService clienteService;
    private Scanner scanner;

    public ClienteView(ClienteService clienteService) {
        this.clienteService = clienteService;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        while (true) {
            System.out.println("=== Menu Cliente ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();
                    clienteService.cadastrarCliente(nome, telefone, endereco);
                    break;
                case 2:
                    List<Cliente> clientes = clienteService.getClientes();
                    System.out.println("=== Clientes Cadastrados ===");
                    for (Cliente cliente : clientes) {
                        System.out.println("Nome: " + cliente.getNome() + ", Telefone: " + cliente.getTelefone() + ", Endereço: " + cliente.getEndereco());
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}