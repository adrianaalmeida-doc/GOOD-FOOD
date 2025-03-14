class Main {
    public static void main(String[] args) {
        ClienteController clienteController = new ClienteController();
        PedidoController pedidoController = new PedidoController();
        RelatorioController relatorioController = new RelatorioController(pedidoController);

        ClienteService clienteService = new ClienteService(clienteController);
        PedidoService pedidoService = new PedidoService(pedidoController);
        RelatorioService relatorioService = new RelatorioService(relatorioController);

        ClienteView clienteView = new ClienteView(clienteService);
        PedidoView pedidoView = new PedidoView(pedidoService);
        RelatorioView relatorioView = new RelatorioView(relatorioService);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=== Sistema da Pizzaria ===");
            System.out.println("1. Menu Cliente");
            System.out.println("2. Menu Pedido");
            System.out.println("3. Gerar Relatório");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    clienteView.exibirMenu();
                    break;
                case 2:
                    pedidoView.exibirMenu();
                    break;
                case 3:
                    relatorioView.exibirRelatorio();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
