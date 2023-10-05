package com.example.tarea4.Entidades;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tarea_table")
public class Tarea {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    private String Descripcion;
    @NonNull
    private boolean realizado;

    public Tarea() {
    }

    public Tarea(@NonNull String descripcion, @NonNull Boolean realizado) {
        Descripcion = descripcion;
        this.realizado = realizado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(@NonNull String descripcion) {
        Descripcion = descripcion;
    }

    public boolean getRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }
}