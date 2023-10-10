package com.example.aplicacionlistadoproductos.Repositorio;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.aplicacionlistadoproductos.Api.ApiClient;
import com.example.aplicacionlistadoproductos.Api.ApiService;
import com.example.aplicacionlistadoproductos.Entidades.Producto;
import com.example.aplicacionlistadoproductos.Entidades.ProductoList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductoRepository {
    private final ApiService apiService;

    public ProductoRepository() {
        apiService = ApiClient.getRetrofitInstance().create(ApiService.class);
    }

    public LiveData<List<Producto>> getProducts() {
        MutableLiveData<List<Producto>> products = new MutableLiveData<>();
        apiService.getProducts().enqueue(new Callback<ProductoList>() {
            @Override
            public void onResponse(Call<ProductoList> call, Response<ProductoList> response) {
                if (response.isSuccessful() && response.body() != null) {
                    products.setValue(response.body().getProducts());
                }
            }

            @Override
            public void onFailure(Call<ProductoList> call, Throwable t) {
                Log.e("Repository", "Error loading products", t);
            }
        });
        return products;
    }

    public LiveData<Producto> getProductDetails(int productId) {
        MutableLiveData<Producto> product = new MutableLiveData<>();
        apiService.getProductDetails(productId).enqueue(new Callback<Producto>() {
            @Override
            public void onResponse(Call<Producto> call, Response<Producto> response) {
                if (response.isSuccessful()) {
                    product.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Producto> call, Throwable t) {
                Log.e("Repository", "Error loading product details", t);
            }
        });
        return product;
    }

}
