class RelatorioService {
    private RelatorioController relatorioController;

    public RelatorioService(RelatorioController relatorioController) {
        this.relatorioController = relatorioController;
    }

    public void gerarRelatorioPedidos() {
        relatorioController.gerarRelatorio();
    }
}
