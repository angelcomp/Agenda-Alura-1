package com.aula.alura.agenda.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.aula.alura.agenda.DAO.ContatoDAO;
import com.aula.alura.agenda.R;
import com.aula.alura.agenda.models.Pessoa;

public class NovoContatoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_contato);

        EditText campoNome = findViewById(R.id.et_nome);
        EditText campoTelefone = findViewById(R.id.et_telefone);
        EditText campoEmail = findViewById(R.id.et_email);
        Button btnSalvar = findViewById(R.id.btn_salvar);

        final ContatoDAO dao = new ContatoDAO();

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = campoNome.getText().toString();
                String telefone = campoTelefone.getText().toString();
                String email = campoEmail.getText().toString();

                Pessoa contato = new Pessoa(nome, telefone, email);
                dao.salvaContato(contato);

                startActivity(new Intent(NovoContatoActivity.this, ListaContatosActivity.class));
            }
        });
    }
}