package com.aula.alura.agenda.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.aula.alura.agenda.DAO.ContatoDAO;
import com.aula.alura.agenda.R;
import com.aula.alura.agenda.models.Pessoa;

public class NovoContatoActivity extends AppCompatActivity {

    private Button btnSalvar;
    private ContatoDAO dao;
    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_contato);

        setTitle("Novo Contato");
        iniciaFormulario();

        btnSalvar.setOnClickListener(v -> {
            salvarContato();
        });
    }

    void iniciaFormulario() {
        campoNome = findViewById(R.id.et_nome);
        campoTelefone = findViewById(R.id.et_telefone);
        campoEmail = findViewById(R.id.et_email);

        btnSalvar = findViewById(R.id.btn_salvar);
        dao = new ContatoDAO();
    }

    private void salvarContato() {
        Pessoa contato = criaContato();
        dao.salvaContato(contato);
        finish();
    }

    private Pessoa criaContato() {
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();

        Pessoa contato = new Pessoa(nome, telefone, email);

        return contato;
    }
}