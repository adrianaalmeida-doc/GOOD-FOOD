package controller;
import model.dao.PedidoDaoInterface;
import model.dao.entities.Pedido;
import jdbc.ConexaoUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDao implements PedidoDaoInterface {
    @Override
    public void inserir(Pedido pedido) {
        try {
            //CRIANDO A CONEXÃO COM O BANCO
            Connection connection = ConexaoUtil.getInstance().getConnection();
            //COMANDO SQL A SER EXECUTADO
            String sql = "INSERT INTO pedidos (id_pedido, fk_cpf, fk_codigo, total_compra) " +
                    "VALUES (?, ?, ?, ?)";
            //DECLARAÇÃO DA CONEXÃO
            PreparedStatement statement = connection.prepareStatement(sql);
            //INSERÇÃO DOS VALORES NOS ATRIBUTOS
            statement.setInt(1, pedido.getId_pedido());
            statement.setString(2, pedido.getFk_cpf());
            statement.setString(3, pedido.getFk_codigo());
            statement.setDouble(4, pedido.getTotal_compra());
            //EXECUTANDO A DECLARAÇÃO
            statement.execute();
            //FECHANDO A CONEXÃO
            connection.close();
            System.out.println("Pedido realizado com sucesso!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void remover(Integer id_pedido) {
        try {
            //CRIANDO A CONEXÃO COM O BANCO
            Connection connection = ConexaoUtil.getInstance().getConnection();
            //COMANDO SQL A SER EXECUTADO
            String sql = "DELETE FROM pedidos WHERE id_pedido = ?";
            //DECLARAÇÃO DA CONEXÃO
            PreparedStatement statement = connection.prepareStatement(sql);
            //INSERÇÃO DOS VALORES NOS ATRIBUTOS
            statement.setInt(1, id_pedido);
            //EXECUTANDO A DECLARAÇÃO
            statement.executeUpdate();
            //FECHANDO A CONEXÃO
            connection.close();
            System.out.println("Pedido removido com sucesso!!!");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Pedido> listarPedidos() {
        List<Pedido> listaPedidos = new ArrayList<>();
        try{
            //CRIANDO A CONEXÃO COM O BANCO
            Connection connection = ConexaoUtil.getInstance().getConnection();
            //COMANDO SQL A SER EXECUTADO
            String sql = "SELECT * FROM pedidos";
            //DECLARAÇÃO DA CONEXÃO
            PreparedStatement statement = connection.prepareStatement(sql);
            //RECEBENDO O RESULTADO DA DECLARAÇÃO
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                //INSERÇÃO DOS VALORES NOS ATRIBUTOS
                Pedido pedido = new Pedido();
                pedido.setId_pedido(resultSet.getInt("id_pedido"));
                pedido.setFk_cpf(resultSet.getString("fk_cpf"));
                pedido.setFk_codigo(resultSet.getString("fk_codigo"));
                pedido.setData(resultSet.getDate("data"));
                pedido.setTotal_compra(resultSet.getDouble("total_compra"));
                listaPedidos.add(pedido);
            }
            //FECHANDO A CONEXÃO

            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return listaPedidos;
    }

    @Override
    public void atualizar(Pedido pedido) {
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "UPDATE pedidos SET fk_codigo = ? WHERE id_pedido = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pedido.getFk_codigo());
            statement.setInt(2, pedido.getId_pedido());
            statement.execute();
            statement.close();
            System.out.println("Pedido atualizado com sucesso!!!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Pedido pesquisar(Integer id_pedido) {
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "SELECT * FROM pedidos WHERE id_pedido = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id_pedido);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Pedido pedido = new Pedido();
                pedido.setId_pedido(resultSet.getInt("id_pedido"));
                pedido.setFk_cpf(resultSet.getString("fk_cpf"));
                pedido.setFk_codigo(resultSet.getString("fk_codigo"));
                pedido.setData(resultSet.getDate("data"));
                pedido.setTotal_compra(resultSet.getDouble("total_compra"));
                return pedido;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
