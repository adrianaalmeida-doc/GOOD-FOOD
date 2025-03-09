package repository;
import model.Cliente;
import java.io.*;
import java.util.*;
import com.google.gson.Gson;

public class ClienteRepository {


    private static final String FILE_PATH = "clientes.json";
    private static Gson gson = new Gson();

    // Método para ler os clientes do arquivo JSON
    public List<Cliente> findAll() {
        List<Cliente> clientes = new ArrayList<>();
        try (Reader reader = new FileReader(FILE_PATH)) {
            clientes = Arrays.asList(gson.fromJson(reader, Cliente[].class));
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Criando um novo arquivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientes;
    }

     // Método para salvar ou atualizar os clientes no arquivo JSON
     public void save(List<Cliente> clientes) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(clientes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para adicionar um novo cliente
    public void add(Cliente cliente) {
        List<Cliente> clientes = findAll();
        clientes.add(cliente);
        save(clientes);
    }

    // Método para buscar um cliente por ID
    public Cliente findById(int id) {
        List<Cliente> clientes = findAll();
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    // Método para atualizar um cliente
    public void update(Cliente updatedCliente) {
        List<Cliente> clientes = findAll();
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == updatedCliente.getId()) {
                clientes.set(i, updatedCliente);
                save(clientes);
                return;
            }
        }
    }

    // Método para remover um cliente
    public void delete(int id) {
        List<Cliente> clientes = findAll();
        clientes.removeIf(cliente -> cliente.getId() == id);
        save(clientes);
    }
    
}
