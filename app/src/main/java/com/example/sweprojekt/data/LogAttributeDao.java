package com.example.sweprojekt.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface LogAttributeDao {
    @Query("SELECT * FROM rcLog_Attribute")
    List<LogAttribute> getAll();

    @Query("Select * From rcLog_Attribute where log_id = :id")
    List<LogAttribute> getByLogID(int id);


    @Insert
    void insertAll(LogAttribute... LogAttributes);

    @Delete
    void delete(LogAttribute logAttribute);
}
