package com.cms_dev.evaluacionu1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class TareasRealizadasActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tareas_realizadas);

        ListView listView = findViewById(R.id.listRelizadas);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TaskManager.getCompletedTasks());
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener((parent, view, position, id)->{

            TaskManager.removeCompleteTask(position);
            adapter.notifyDataSetChanged();
            return true;
        });

        findViewById(R.id.btn_Pendientes).setOnClickListener(view -> {
            Intent intent = new Intent(TareasRealizadasActivity.this, TareasPendientesActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.btnInicio2).setOnClickListener(view -> {
            Intent intent = new Intent(TareasRealizadasActivity.this, MainActivity.class);
            startActivity(intent);
        });

    }
}