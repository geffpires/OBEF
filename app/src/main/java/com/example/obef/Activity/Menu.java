package com.example.obef.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.obef.Activity.MainActivity;
import com.example.obef.R;

public class Menu extends AppCompatActivity {

    private Button botaoJogar;
    private Button botaoDesafio;
    private Button botaoPontos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        botaoJogar = findViewById(R.id.botaoJogar);
        botaoDesafio = findViewById(R.id.botaoDesafio);
        botaoPontos = findViewById(R.id.botaoPontos);

        botaoJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}
