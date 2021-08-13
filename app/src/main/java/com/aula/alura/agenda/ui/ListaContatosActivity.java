package com.aula.alura.agenda.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.aula.alura.agenda.DAO.ContatoDAO;
import com.aula.alura.agenda.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListaContatosActivity extends AppCompatActivity {

    FloatingActionButton fabNovoContato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contatos);

        configuraFloatingButton();

        fabNovoContato.setOnClickListener(v ->
                adicionarNovoContato()
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizaLista();
    }

    private void adicionarNovoContato() {
        Intent intent = new Intent(ListaContatosActivity.this, NovoContatoActivity.class);
        startActivity(intent);
    }

    private void configuraFloatingButton() {
        fabNovoContato = findViewById(R.id.fab_novo_contato);
        fabNovoContato.setColorFilter(Color.WHITE);
    }

    private void atualizaLista() {
        ListView lista = findViewById(R.id.lv_lista);
        ContatoDAO dao = new ContatoDAO();
        lista.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.lista()
        ));
    }
}