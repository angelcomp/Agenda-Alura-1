package com.aula.alura.agenda.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.aula.alura.agenda.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaContatosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contatos);

        ListView lista = findViewById(R.id.lv_lista);
        FloatingActionButton fabNovoContato = findViewById(R.id.fab_novo_contato);

        fabNovoContato.setColorFilter(Color.WHITE);

        List<String> alunos = new ArrayList<>(
                Arrays.asList("Angelica", "Luiza", "Helena")
        );

        lista.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                alunos
        ));
    }
}