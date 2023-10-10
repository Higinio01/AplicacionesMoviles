package com.example.aplicacionlistadoproductos.Api;

import com.example.aplicacionlistadoproductos.Entidades.Producto;
import com.example.aplicacionlistadoproductos.Entidades.ProductoList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("products")
    Call<ProductoList> getProducts();

    @GET("products/{id}")
    Call<Producto> getProductDetails(@Path("id") int productId);

}
