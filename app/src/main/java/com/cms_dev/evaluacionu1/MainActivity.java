package com.cms_dev.evaluacionu1;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ImageButton btnRealizadas = findViewById(R.id.btn_realizadas);
        btnRealizadas.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TareasRealizadasActivity.class);
            startActivity(intent);
        });

        ImageButton btnPendientes = findViewById(R.id.btn_pendientes);
        btnPendientes.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, TareasPendientesActivity.class);
            startActivity(intent);
        });

        EditText editTextNombre = findViewById(R.id.editTxtNombre);
        Button btnAgregar = findViewById(R.id.btnAgregar);

        btnAgregar.setOnClickListener(view -> {
            String task = editTextNombre.getText().toString().trim();
            if (!task.isEmpty()){
                TaskManager.addTask(task);
                editTextNombre.setText("");
            }
        });
    }
}