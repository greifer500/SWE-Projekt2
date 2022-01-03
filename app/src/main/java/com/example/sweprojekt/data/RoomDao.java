package com.example.sweprojekt.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface RoomDao {
    @Query("SELECT * FROM rcRoom")
    List<Room> getAll();

    @Query("Select * From rcRoom where id = :id Limit 1")
    Room getByID(int id);

    @Query("Select * From rcRoom where room_number = :roomNumber AND building_id = :buildingID Limit 1")
    Room getByRoomNumberAndBuildingID(int roomNumber, int buildingID);

    @Insert
    void insertAll(Room... Rooms);

    @Delete
    void delete(Room room);
}
