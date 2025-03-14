class PedidoView {
    private PedidoService pedidoService;
    private Scanner scanner;

    public PedidoView(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        while (true) {
            System.out.println("=== Menu Pedido ===");
            System.out.println("1. Criar Pedido");
            System.out.println("2. Listar Pedidos");
            System.out.println("3. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Itens do pedido (separados por vírgula): ");
                    String itensStr = scanner.nextLine();
                    List<String> itens = List.of(itensStr.split(","));
                    System.out.print("Total do pedido: R$ ");
                    double total = scanner.nextDouble();
                    scanner.nextLine();
                    pedidoService.fazerPedido(new Cliente(nomeCliente, "", ""), itens, total);
                    break;
                case 2:
                    List<Pedido> pedidos = pedidoService.getPedidos();
                    System.out.println("=== Pedidos Cadastrados ===");
                    for (Pedido pedido : pedidos) {
                        System.out.println("Cliente: " + pedido.getCliente().getNome() + ", Itens: " + pedido.getItens() + ", Total: R$ " + pedido.getTotal());
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