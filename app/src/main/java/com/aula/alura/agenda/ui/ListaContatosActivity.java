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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contatos);

        FloatingActionButton fabNovoContato = findViewById(R.id.fab_novo_contato);

        fabNovoContato.setColorFilter(Color.WHITE);
        
        Intent intent = new Intent(ListaContatosActivity.this, NovoContatoActivity.class);
        fabNovoContato.setOnClickListener(v ->
                startActivity(intent)
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListView lista = findViewById(R.id.lv_lista);
        ContatoDAO dao = new ContatoDAO();
        lista.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.lista()
        ));
    }
}