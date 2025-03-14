class Pedido {
    private Cliente cliente;
    private List<String> itens;
    private double total;

    public Pedido(Cliente cliente, List<String> itens, double total) {
        this.cliente = cliente;
        this.itens = itens;
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<String> getItens() {
        return itens;
    }

    public void setItens(List<String> itens) {
        this.itens = itens;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}