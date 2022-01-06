package com.example.sweprojekt.data;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;
@Dao
public interface LogAndRoomDao {
    @Transaction
    @Query("select * from rcLog")
     List<LogAndRoom> getAll();
}
