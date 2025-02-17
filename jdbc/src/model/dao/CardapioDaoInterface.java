package model.dao;
import model.dao.entities.Cardapio;
import java.util.List;

public interface CardapioDaoInterface {
    List<Cardapio> listarCardapio();
    Cardapio pesquisar(String codigo);
}
