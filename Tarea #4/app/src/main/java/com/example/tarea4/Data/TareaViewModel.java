package com.example.tarea4.Data;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.tarea4.Entidades.Tarea;

import java.util.List;

public class TareaViewModel extends AndroidViewModel {
    private TareaRepositorio mRepository;

    private final LiveData<List<Tarea>> mAllTareas;

    public TareaViewModel (Application application) {
        super(application);
        mRepository = new TareaRepositorio(application);
        mAllTareas = mRepository.getAllTarea();
    }

    public LiveData<List<Tarea>> getAllTareas() { return mAllTareas; }

    public void insert(Tarea tarea) { mRepository.insert(tarea); }
    public void delete(Tarea tarea) { mRepository.delete(tarea);}

    public void update(Tarea tarea) { mRepository.update(tarea);}
}