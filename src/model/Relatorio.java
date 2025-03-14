class Relatorio {
    public static void gerarRelatorio(List<Pedido> pedidos) {
        System.out.println("=== Relatório de Pedidos ===");
        for (Pedido pedido : pedidos) {
            System.out.println("Cliente: " + pedido.getCliente().getNome());
            System.out.println("Itens: " + pedido.getItens());
            System.out.println("Total: R$ " + pedido.getTotal());
            System.out.println("---------------------------");
        }
    }
}
