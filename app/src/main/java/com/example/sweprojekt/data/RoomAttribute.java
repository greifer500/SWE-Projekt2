package com.example.sweprojekt.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.google.android.material.tabs.TabLayout;

@Entity(tableName = "rcRoom_attribute",
        primaryKeys = {"room_id","attribute_id"},
        foreignKeys = {
        @ForeignKey(
            entity = Room.class,
            parentColumns = "id",
            childColumns = "room_id",
            onDelete = ForeignKey.SET_NULL),
        @ForeignKey(
            entity = Attribute.class,
            parentColumns = "id",
            childColumns = "attribute_id",
            onDelete = ForeignKey.SET_NULL)})
public class RoomAttribute {
    @NonNull
    //@PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "room_id")
    public Integer roomID;

    @NonNull
    //@PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "attribute_id")
    public Integer attributeID;

    @ColumnInfo(name = "attribute_count")
    public Integer attributeCount;




}
