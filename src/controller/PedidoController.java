class PedidoController {
    private List<Pedido> pedidos = new ArrayList<>();

    public void criarPedido(Pedido pedido) {
        pedidos.add(pedido);
        System.out.println("Pedido registrado com sucesso!");
    }

    public List<Pedido> listarPedidos() {
        return pedidos;
    }
}
