package com.example.aplicacionlistadoproductos.Repositorio;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.aplicacionlistadoproductos.Entidades.Producto;

import java.util.List;

public class ProductViewModel extends ViewModel {
    private final ProductoRepository repository;

    public ProductViewModel() {
        repository = new ProductoRepository();
    }

    public LiveData<List<Producto>> getProducts() {
        return repository.getProducts();
    }

    public LiveData<Producto> getProductDetails(int productId) {
        return repository.getProductDetails(productId);
    }
}
