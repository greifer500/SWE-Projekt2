package com.example.sweprojekt.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.sweprojekt.ui.list.ListFragment;

import java.util.List;
@Dao
public interface RoomAttributeDao {
    @Query("SELECT * FROM rcRoom_Attribute")
    List<RoomAttribute> getAll();

    @Query("Select * From rcRoom_Attribute where room_id = :roomID AND attribute_id = :attributeID Limit 1")
    RoomAttribute getByID(int roomID, int attributeID);

    @Query("Select * From rcRoom_Attribute where room_id = :roomID  ")
    List<RoomAttribute>getByRoom(int roomID);

    @Insert
    void insertAll(RoomAttribute... RoomAttributes);

    @Delete
    void delete(RoomAttribute roomAttribute);

    @Update
    void update(RoomAttribute roomAttribute);
}
