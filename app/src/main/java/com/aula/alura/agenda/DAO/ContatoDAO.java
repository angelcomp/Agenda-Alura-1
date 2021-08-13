package com.aula.alura.agenda.DAO;

import com.aula.alura.agenda.models.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {
    private final static List<Pessoa> contatos = new ArrayList<>();

    public void salvaContato(Pessoa pessoa) {
        contatos.add(pessoa);
    }

    public List<Pessoa> lista() {
        return new ArrayList<>(contatos);
    }
}
