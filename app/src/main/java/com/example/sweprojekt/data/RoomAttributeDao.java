package com.example.sweprojekt.data;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

public interface RoomAttributeDao {
    @Query("SELECT * FROM rcRoom_Attribute")
    List<RoomAttribute> getAll();

    @Query("Select * From rcRoom_Attribute where room_id = :roomID AND attribute_id = :attributeID Limit 1")
    RoomAttribute getByID(int roomID, int attributeID);

    @Insert
    void insertAll(RoomAttribute... RoomAttributes);

    @Delete
    void delete(RoomAttribute roomAttribute);
}
