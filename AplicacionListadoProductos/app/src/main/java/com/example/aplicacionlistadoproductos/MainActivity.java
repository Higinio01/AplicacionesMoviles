package com.example.aplicacionlistadoproductos;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplicacionlistadoproductos.Adapter.ProductoListAdapter;
import com.example.aplicacionlistadoproductos.Repositorio.ProductViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ProductViewModel productViewModel;
    private ProductoListAdapter productoListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = findViewById(R.id.recyclerViewTasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productViewModel = new ViewModelProvider(this).get(ProductViewModel.class);


        productoListAdapter = new ProductoListAdapter(new ArrayList<>(), this, productViewModel);
        recyclerView.setAdapter(productoListAdapter);


        productViewModel.getProducts().observe(this, products -> {
            productoListAdapter.setProducts(products);
        });

    }
}
