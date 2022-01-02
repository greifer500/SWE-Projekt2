package com.example.sweprojekt.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "rcRoom",
foreignKeys = {@ForeignKey(entity = Building.class,
        parentColumns = "id",
        childColumns = "building_id",
        onDelete = ForeignKey.SET_NULL)})
public class Room {

    @PrimaryKey(autoGenerate = true)
    public Integer id;

    @ColumnInfo(name = "building_id")
    public Integer buildingID;

    @ColumnInfo(name = "room_number")
    public Integer roomNumber;

    @ColumnInfo(name = "description")
    public String description;
}
