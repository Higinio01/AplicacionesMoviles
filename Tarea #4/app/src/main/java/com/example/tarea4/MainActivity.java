package com.example.tarea4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnListTarea = findViewById(R.id.btnListTarea);

        // Agrega un listener de clic al botón
        btnListTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inicia la actividad RoomViewActivity al hacer clic en el botón
                Intent intent = new Intent(MainActivity.this, RoomViewActivity.class);
                startActivity(intent);
            }
        });
    }
}