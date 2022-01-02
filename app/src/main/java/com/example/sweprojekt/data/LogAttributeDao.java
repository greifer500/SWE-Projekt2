package com.example.sweprojekt.data;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

public interface LogAttributeDao {
    @Query("SELECT * FROM rcLog_Attribute")
    List<ErrorType> getAll();

    @Query("Select * From rcLog_Attribute where log_id = :id")
    List<ErrorType> getByID(int id);

    @Insert
    void insertAll(LogAttribute... LogAttributes);

    @Delete
    void delete(ErrorType errorType);
}
