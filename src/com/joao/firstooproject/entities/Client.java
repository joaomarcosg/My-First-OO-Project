package com.joao.firstooproject.entities;

public class Client {
    private String name;
    private String cpf;

    public Client() {
        this.name = "John Doe";
        this.cpf = "1234567890";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
