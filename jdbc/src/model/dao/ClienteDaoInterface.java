package model.dao;
import model.dao.entities.Cliente;
import java.util.List;

public interface ClienteDaoInterface {
    void inserir(Cliente cliente);
    void remover(String cpfCliente);
    List<Cliente> listarClientes();
    void atualizar(Cliente cliente);
    Cliente pesquisar(String cpfCliente);
}
