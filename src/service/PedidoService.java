class PedidoService {
    private PedidoController pedidoController;

    public PedidoService(PedidoController pedidoController) {
        this.pedidoController = pedidoController;
    }

    public void fazerPedido(Cliente cliente, List<String> itens, double total) {
        Pedido pedido = new Pedido(cliente, itens, total);
        pedidoController.criarPedido(pedido);
    }
}
