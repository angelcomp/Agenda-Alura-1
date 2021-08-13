package com.aula.alura.agenda.models;

public class Pessoa {

    private final String nome;
    private final String telefone;
    private final String email;

    public Pessoa(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    @Override
    public String toString() {
        return nome;
    }
}
