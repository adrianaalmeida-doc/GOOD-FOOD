class RelatorioView {
    private RelatorioService relatorioService;

    public RelatorioView(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    public void exibirRelatorio() {
        System.out.println("=== Relatório de Pedidos ===");
        relatorioService.gerarRelatorioPedidos();
    }
}
