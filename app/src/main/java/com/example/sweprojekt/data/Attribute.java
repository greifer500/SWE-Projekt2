package com.example.sweprojekt.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "rcAttribute")
public class Attribute {
    @PrimaryKey(autoGenerate = true)
    public Integer id;

    @ColumnInfo(name = "description")
    public String description;
}
