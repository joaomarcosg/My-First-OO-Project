package com.joao.firstooproject.services;

import com.joao.firstooproject.database.Database;
import com.joao.firstooproject.entities.Client;

import java.util.Optional;

public class ClientService {
    private Database database;

    public ClientService(Database database) {
        this.database = database;
    }

    public Optional<Client> getClientByCpf(String cpf) {
        if (database.getClient().getCpf().equals(cpf)) {
            return Optional.of(database.getClient());
        } else {
            return Optional.empty();
        }
    }
}
