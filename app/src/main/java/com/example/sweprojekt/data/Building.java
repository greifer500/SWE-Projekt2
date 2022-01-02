package com.example.sweprojekt.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "rcBuilding")
public class Building {
    @PrimaryKey(autoGenerate = true)
    public Integer id;

    @ColumnInfo(name = "building_prefix")
    public String buildingPrefix;

    @ColumnInfo(name = "description")
    public String description;





}
