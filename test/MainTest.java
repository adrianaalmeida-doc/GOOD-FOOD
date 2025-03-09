package test;

import model.Cliente;
import repository.ClienteRepository;

public class MainTest {

    public static void main(String[] args) {
        ClienteRepository clienteRepo = new ClienteRepository();

        // Adicionar clientes
        clienteRepo.add(new Cliente(1, "João", "joao@example.com"));
        clienteRepo.add(new Cliente(2, "Maria", "maria@example.com"));

        // Buscar todos os clientes
        clienteRepo.findAll().forEach(cliente -> {
            System.out.println("ID: " + cliente.getId() + " Nome: " + cliente.getNome());
        });

        // Buscar um cliente por ID
        Cliente cliente = clienteRepo.findById(1);
        if (cliente != null) {
            System.out.println("Cliente encontrado: " + cliente.getNome());
        }

        // Atualizar um cliente
        cliente.setNome("João Silva");
        clienteRepo.update(cliente);

        // Remover um cliente
        clienteRepo.delete(2);

        // Exibir clientes novamente
        clienteRepo.findAll().forEach(cliente1 -> {
            System.out.println("ID: " + cliente1.getId() + " Nome: " + cliente1.getNome());
        });
    }
}
