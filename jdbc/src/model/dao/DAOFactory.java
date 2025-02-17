package model.dao;

import controller.CardapioDao;
import controller.ClienteDao;
import controller.PedidoDao;

public class DAOFactory {
    public static ClienteDaoInterface createClienteDao(){
        return new ClienteDao();
    }
    public static PedidoDaoInterface createPedidoDao(){
        return new PedidoDao();
    }
    public static CardapioDaoInterface createCardapioDao(){
        return new CardapioDao();
    }
}
