package com.example.tarea4;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tarea4.Adapter.TareaListAdapter;
import com.example.tarea4.Data.TareaViewModel;
//import com.example.tarea4.databinding.ActivityRoomViewBinding
import com.example.tarea4.Entidades.Tarea;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RoomViewActivity extends AppCompatActivity {

    private TareaViewModel mTareaViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_view);

        mTareaViewModel = new ViewModelProvider(this).get(TareaViewModel.class);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final TareaListAdapter adapter = new TareaListAdapter(mTareaViewModel, new TareaListAdapter.TareaDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mTareaViewModel = new ViewModelProvider(this).get(TareaViewModel.class);
        mTareaViewModel.getAllTareas().observe(this, tareas -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(tareas);
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener( view -> {
            Intent intent = new Intent(RoomViewActivity.this, NewTareaActivity.class);
            startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
        });
    }
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Tarea word = new Tarea(data.getStringExtra(NewTareaActivity.EXTRA_REPLY),false  );
            mTareaViewModel.insert(word);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }

}
