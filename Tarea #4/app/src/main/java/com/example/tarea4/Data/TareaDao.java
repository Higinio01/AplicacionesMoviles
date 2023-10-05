package com.example.tarea4.Data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.tarea4.Entidades.Tarea;

import java.util.List;

@Dao
public interface TareaDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Tarea tarea);

    @Query("DELETE FROM tarea_table")
    void deleteAll();

    @Query("SELECT * FROM tarea_table ORDER BY id ASC")
    LiveData<List<Tarea>> getAlphabetizedWords();

    @Delete
    void delete(Tarea tarea);

    @Update
    void update(Tarea tarea);

    @Query("SELECT * FROM tarea_table WHERE id = :taskId")
    Tarea getTareaById(int taskId);

}
