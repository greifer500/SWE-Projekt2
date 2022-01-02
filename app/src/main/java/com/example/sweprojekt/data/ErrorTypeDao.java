package com.example.sweprojekt.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface ErrorTypeDao {
    @Query("SELECT * FROM rcErrorType")
    List<ErrorType> getAll();

    @Query("Select * From rcErrorType where id = :id Limit 1")
    ErrorType getByID(int id);

    @Insert
    void insertAll(ErrorType... ErrorTypes);

    @Delete
    void delete(ErrorType errorType);
}
