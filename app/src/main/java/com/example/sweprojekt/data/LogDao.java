package com.example.sweprojekt.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface LogDao {
    @Query("SELECT * FROM rcLog")
    List<Log> getAll();

    @Query("Select * From rcLog where id = :id Limit 1")
    Log getByID(int id);

    @Query("Select * From rcLog where room_id = :roomID " +
            "AND id = (Select Max(id) from rcLog where room_id = :roomID) Limit 1")
    Log getLatestByRoomID(int roomID);

    @Insert
    void insertAll(Log... Logs);

    @Delete
    void delete(Log log);
}
