package com.example.examen1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.examen1.Entidades.Product;

import java.util.List;

public class ProductViewModel extends ViewModel {
    private final ProductoRepository repository;

    public ProductViewModel() {
        repository = new ProductoRepository();
    }

    public LiveData<List<Product>> getProducts() {
        return repository.getProducts();
    }

    public LiveData<Product> getProductDetails(int productId) {
        return repository.getProductDetails(productId);
    }

    public LiveData<List<Product>> searchProducts(String query) {
        return repository.searchProducts(query);
    }
}
