class RelatorioController {
    private PedidoController pedidoController;

    public RelatorioController(PedidoController pedidoController) {
        this.pedidoController = pedidoController;
    }

    public void gerarRelatorio() {
        Relatorio.gerarRelatorio(pedidoController.listarPedidos());
    }
}
