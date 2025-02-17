package controller;
import model.dao.ClienteDaoInterface;
import model.dao.entities.Cliente;
import jdbc.ConexaoUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao implements ClienteDaoInterface {

    public void inserir(Cliente cliente) {
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "INSERT INTO clientes (nome, cpf, telefone) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCpf());
            statement.setString(3, cliente.getTelefone());
            statement.execute();
            connection.close();
            System.out.println("Cliente inserido com sucesso!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void remover(String cpfCliente) {
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "DELETE FROM clientes WHERE cpf = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cpfCliente);
            statement.executeUpdate();
            connection.close();
            System.out.println("Cliente removido com sucesso!!!");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Cliente> listarClientes(){
        List<Cliente> listaClientes = new ArrayList<>();
        try{
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "SELECT * FROM clientes";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Cliente cliente = new Cliente();
                cliente.setNome(resultSet.getString("nome"));
                cliente.setCpf(resultSet.getString("cpf"));
                cliente.setTelefone(resultSet.getString("telefone"));
                listaClientes.add(cliente);
            }
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return listaClientes;
    }
    public void atualizar(Cliente cliente){
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "UPDATE clientes SET nome = ?, telefone = ? WHERE cpf = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getTelefone());
            statement.setString(3, cliente.getCpf());
            statement.execute();
            statement.close();
            System.out.println("Cliente atualizado com sucesso!!!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public Cliente pesquisar(String cpf) {
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "SELECT * FROM clientes WHERE cpf = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cpf);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setNome(resultSet.getString("nome"));
                cliente.setCpf(resultSet.getString("cpf"));
                cliente.setTelefone(resultSet.getString("telefone"));
                return cliente;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
