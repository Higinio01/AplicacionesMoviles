package com.example.tarea4.Data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.tarea4.Entidades.Tarea;

import java.util.List;

public class TareaRepositorio {
    private TareaDao mTareaDao;
    private LiveData<List<Tarea>> mAllTareas;

    TareaRepositorio(Application application) {
        TareaRoomDatabase db = TareaRoomDatabase.getDatabase(application);
        mTareaDao = db.tareaDao();
        mAllTareas = mTareaDao.getAlphabetizedWords();
    }

    LiveData<List<Tarea>> getAllTarea() {
        return mAllTareas;
    }

    void insert(Tarea tarea) {
        TareaRoomDatabase.databaseWriteExecutor.execute(() -> {
            mTareaDao.insert(tarea);
        });
    }

    void delete(Tarea tarea){
        TareaRoomDatabase.databaseWriteExecutor.execute(() ->{
            mTareaDao.delete(tarea);
        });
    }

    public Tarea getTareaById(int taskId) {
        return mTareaDao.getTareaById(taskId);
    }

    public void update(Tarea tarea) {
        new Thread(() -> {
            mTareaDao.update(tarea);
        }).start();
    }
}
