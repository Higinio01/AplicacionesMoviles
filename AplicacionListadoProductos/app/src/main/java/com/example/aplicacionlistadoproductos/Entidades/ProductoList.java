package com.example.aplicacionlistadoproductos.Entidades;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductoList {
    @SerializedName("products")
    private List<Producto> products;

    public List<Producto> getProducts() {
        return products;
    }
}
