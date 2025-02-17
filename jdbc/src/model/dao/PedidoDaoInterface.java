package model.dao;
import model.dao.entities.Pedido;
import java.util.List;

public interface PedidoDaoInterface {
    void inserir(Pedido pedido);
    void remover(Integer id_pedido);
    List<Pedido> listarPedidos();
    void atualizar(Pedido pedido);
    Pedido pesquisar(Integer id_pedido);
}
