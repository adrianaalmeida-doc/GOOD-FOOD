import java.util.List;

public class ClienteService {
    private ClienteController clienteController;

    public ClienteService(ClienteController clienteController) {
        this.clienteController = clienteController;
    }

    public void cadastrarCliente(String nome, String telefone, String endereco) {
        Cliente cliente = new Cliente(nome, telefone, endereco);
        clienteController.adicionarCliente(cliente);
    }
}