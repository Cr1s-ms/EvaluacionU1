package com.cms_dev.evaluacionu1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.List;

public class TareasPendientesActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tareas_pendientes);

        ListView listView =findViewById(R.id.listPendientes);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TaskManager.getPendingTasks());
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener((parent, view, position, id) ->{
            TaskManager.completeTask(position);
            adapter.notifyDataSetChanged();
            return true;
        });

        findViewById(R.id.btn_Completadas).setOnClickListener(v -> {
            Intent intent = new Intent(TareasPendientesActivity.this, TareasRealizadasActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.btn_inicio).setOnClickListener(view -> {
            Intent intent2 = new Intent(TareasPendientesActivity.this, MainActivity.class);
            startActivity(intent2);
        });

    }

}