package controller;
import model.dao.CardapioDaoInterface;
import model.dao.entities.Cardapio;
import jdbc.ConexaoUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardapioDao implements CardapioDaoInterface {
    @Override
    public List<Cardapio> listarCardapio() {
        List<Cardapio> listaCardapio = new ArrayList<>();
        try{
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "SELECT * FROM cardapio";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Cardapio cardapio = new Cardapio();
                cardapio.setNome(resultSet.getString("nome"));
                cardapio.setCodigo(resultSet.getString("codigo"));
                cardapio.setValor(resultSet.getDouble("valor"));
                listaCardapio.add(cardapio);
            }
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCardapio;
    }
    @Override
    public Cardapio pesquisar(String codigo) {
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "SELECT * FROM cardapio WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, codigo);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Cardapio cardapio = new Cardapio();
                cardapio.setCodigo(resultSet.getString("codigo"));
                cardapio.setNome(resultSet.getString("nome"));
                cardapio.setValor(resultSet.getDouble("valor"));
                return cardapio;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
