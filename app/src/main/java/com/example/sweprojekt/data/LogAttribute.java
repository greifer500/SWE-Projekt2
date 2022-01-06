package com.example.sweprojekt.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "rcLog_Attribute",
        primaryKeys = {"log_id","attribute_id"},
        foreignKeys = {
        @ForeignKey(
                entity = Log.class,
                parentColumns = "id",
                childColumns = "log_id",
                onDelete = ForeignKey.SET_NULL),
        @ForeignKey(
                entity = Attribute.class,
                parentColumns = "id",
                childColumns = "attribute_id",
                onDelete = ForeignKey.SET_NULL)
                //,
       // @ForeignKey(
       //         entity = ErrorType.class,
       //         parentColumns = "id",
                //        childColumns = "error_type_id",
       //         onDelete = ForeignKey.SET_NULL)
})
public class LogAttribute {
    //@PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "log_id")
    public Integer logID;

    @NonNull
   // @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "attribute_id")
    public Integer attributeID;

    //@PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "error_type_id")
    public Integer errorTypeID;

    @ColumnInfo(name = "attribute_count_expected")
    public Integer attributeCountExpected;

    @ColumnInfo(name = "attribute_count_is")
    public Integer attributeCountIs;

    @ColumnInfo(name = "attribute_count_bad")
    public Integer attributeCountBad;

    @ColumnInfo(name = "error_message")
    public String errorMessage;

}
