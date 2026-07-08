package com.joao.firstooproject.services;

import com.joao.firstooproject.database.Database;
import com.joao.firstooproject.entities.Client;

import java.util.Optional;
import java.util.stream.Stream;

public class ClientService {
    private Database database;

    public ClientService(Database database) {
        this.database = database;
    }

    public void save(Client client) {
        Optional<Client> clientOpt = getClientByCpf(client.getCpf());

        if (clientOpt.isPresent()) {
            System.out.println("Client already exists");
        } else {
            this.database.addClient(client);
            System.out.println("Client added successfully");
        }
    }

    public Optional<Client> getClientByCpf(String cpf) {
        for (Client client : database.getClients()) {
            if (client.getCpf().equals(cpf)) {
                return Optional.of(client);
            }
        }
        return Optional.empty();
    }

    public void delete(String cpf) {
        Optional<Client> clientOpt = getClientByCpf(cpf);

        if (clientOpt.isPresent()) {
            Client clientToDelete = clientOpt.get();
            database.removeClient(clientToDelete);
            System.out.println("Client deleted successfully");
        } else {
            System.out.println("Client does not exists");
        }
    }
}
