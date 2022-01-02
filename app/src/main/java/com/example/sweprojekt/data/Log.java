package com.example.sweprojekt.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "rcLog",
        foreignKeys = {
        @ForeignKey(
            entity = Room.class,
            parentColumns = "id",
            childColumns = "room_id",
            onDelete = ForeignKey.SET_NULL),
        @ForeignKey(
            entity = User.class,
            parentColumns = "id",
            childColumns = "user_id",
            onDelete = ForeignKey.SET_NULL)})
public class Log {
    @PrimaryKey(autoGenerate = true)
    public Integer id;

    @ColumnInfo(name = "user_id")
    public Integer userId;

    @ColumnInfo(name = "room_id")
    public Integer roomId;

    @ColumnInfo(name = "timestamp")
    public Integer timestamp;






}
