package com.example.aplicacionlistadoproductos.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplicacionlistadoproductos.Entidades.Producto;
import com.example.aplicacionlistadoproductos.ProductoActivity;
import com.example.aplicacionlistadoproductos.R;
import com.example.aplicacionlistadoproductos.Repositorio.ProductViewModel;

import java.util.List;

public class ProductoListAdapter extends RecyclerView.Adapter<ProductoListAdapter.ViewHolder> {

    private List<Producto> productsList;
    private Context context;
    private ProductViewModel productViewModel;

    public ProductoListAdapter(List<Producto> productsList, Context context, ProductViewModel productViewModel) {
        this.productsList = productsList;
        this.context = context;
        this.productViewModel = productViewModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Producto product = productsList.get(position);
        holder.textViewTitle.setText(product.getTitle());
        holder.textViewDescription.setText(product.getDescription());



        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ProductoActivity.class);
            intent.putExtra("productId", product.getId());
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    public void setProducts(List<Producto> products) {
        this.productsList = products;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;
        TextView textViewDescription;
        ImageView imageViewThumbnail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
        }
    }
}
