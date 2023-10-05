package com.example.tarea4.Adapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tarea4.Data.TareaViewModel;
import com.example.tarea4.Entidades.Tarea;
import com.example.tarea4.NewTareaActivity;
import com.example.tarea4.R;

import org.jetbrains.annotations.NotNull;

public class TareaListAdapter extends ListAdapter<Tarea, TareaListAdapter.TareaViewHolder> {

    private TareaViewModel mTareaViewModel;
    public TareaListAdapter(TareaViewModel tareaViewModel,DiffUtil.ItemCallback<Tarea> diffCallback) {
        super(diffCallback);
        this.mTareaViewModel = tareaViewModel;
    }

    @NonNull
    @NotNull
    @Override
    public TareaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return TareaListAdapter.TareaViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(TareaViewHolder holder, int position) {
        Tarea current = getItem(position);
        holder.bind(current.getDescripcion());

        holder.cbxHecho.setOnCheckedChangeListener(null);

        if(current.getRealizado()){
            holder.tareaItemView.setPaintFlags(holder.tareaItemView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder.cbxHecho.setChecked(true);
        } else {
            holder.tareaItemView.setPaintFlags(holder.tareaItemView.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
            holder.cbxHecho.setChecked(false);
        }

        holder.cbxHecho.setOnCheckedChangeListener((buttonView, isChecked) -> {
            current.setRealizado(isChecked);
            mTareaViewModel.update(current);

            if(isChecked){
                holder.tareaItemView.setPaintFlags(holder.tareaItemView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            } else {
                holder.tareaItemView.setPaintFlags(holder.tareaItemView.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
            }
        });

        holder.btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // int currentPosition = holder.getAdapterPosition();

                new AlertDialog.Builder(view.getContext())
                        .setTitle("Eliminar tarea")
                        .setMessage("Confirmar eliminar tarea")
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mTareaViewModel.delete(current);
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
            }
        });

        holder.btnModificar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                LayoutInflater inflater = LayoutInflater.from(view.getContext());
                View dialogView = inflater.inflate(R.layout.modificar_tarea, null);
                EditText editTarea = dialogView.findViewById(R.id.editTarea);

                editTarea.setText(current.getDescripcion());

                builder.setView(dialogView)
                        .setTitle("Modificar Tarea")
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String updatedTarea = editTarea.getText().toString();
                                current.setDescripcion(updatedTarea);
                                mTareaViewModel.update(current);
                            }
                        })
                        .setNegativeButton("Cancelar", null)
                        .show();
            }

        });
    }

    public static class TareaDiff extends DiffUtil.ItemCallback<Tarea> {

        @Override
        public boolean areItemsTheSame(@NonNull Tarea oldItem, @NonNull Tarea newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Tarea oldItem, @NonNull Tarea newItem) {
            return oldItem.getDescripcion().equals(newItem.getDescripcion());
        }
    }

     static class TareaViewHolder extends RecyclerView.ViewHolder {
        private final TextView tareaItemView;
        private final Button btnEliminar;
        private final Button btnModificar;
        private final CheckBox cbxHecho;

        private TareaViewHolder(View itemView) {
            super(itemView);
            tareaItemView = itemView.findViewById(R.id.textView);
            btnEliminar = itemView.findViewById(R.id.deleteButton);
            btnModificar = itemView.findViewById(R.id.editButton);
            cbxHecho = itemView.findViewById(R.id.checkbox);
        }

        public void bind(String text) {
            tareaItemView.setText(text);
        }

        static TareaViewHolder create(ViewGroup parent) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recyclerview_item, parent, false);
            return new TareaViewHolder(view);
        }
    }
}
