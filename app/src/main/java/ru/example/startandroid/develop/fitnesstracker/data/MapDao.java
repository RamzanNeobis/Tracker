package ru.example.startandroid.develop.fitnesstracker.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MapDao {

    @Insert
    void insert(Map run);

    @Update
    void update(Map run);

    @Delete
    void delete(Map run);

  //  @Query("DELETE FROM product_table WHERE id = :id")
    //void delete(long id);

    @Query("DELETE FROM map_table")
    void deleteAllMaps();

    @Query("SELECT * FROM map_table ORDER BY time DESC")
    LiveData<List<Map>> getAllMaps();
}

