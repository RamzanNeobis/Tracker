package ru.example.startandroid.develop.fitnesstracker.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "map_table")
public class Map {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    public String length;
    public String  speed;
    public long time;


    public Map(String length, String speed, long time) {
        this.length = length;
        this.speed = speed;
        this.time = time;

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getLength() {
        return length;
    }

    public String getSpeed() {
        return speed;
    }

    public long getTime() {
        return time;
    }
}

