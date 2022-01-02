package com.example.sweprojekt.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "rcLog_Attribute",
        foreignKeys = {
        @ForeignKey(
                entity = Log.class,
                parentColumns = "id",
                childColumns = "room_id",
                onDelete = ForeignKey.SET_NULL),
        @ForeignKey(
                entity = Attribute.class,
                parentColumns = "id",
                childColumns = "attribute_id",
                onDelete = ForeignKey.SET_NULL),
        @ForeignKey(
                entity = ErrorType.class,
                parentColumns = "id",
                childColumns = "error_type_id",
                onDelete = ForeignKey.SET_NULL)})
public class LogAttribute {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "log_id")
    public Integer LogID;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "attribute_id")
    public Integer AttributeID;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "error_type_id")
    public Integer ErrorTypeID;

    @ColumnInfo(name = "attribute_count")
    public Integer AttributeCount;

    @ColumnInfo(name = "error_message")
    public String ErrorMessage;

}
