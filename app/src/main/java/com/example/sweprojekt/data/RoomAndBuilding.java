package com.example.sweprojekt.data;

import androidx.room.Embedded;
import androidx.room.Relation;

public class RoomAndBuilding {
    @Embedded
    public Room room;
    @Relation(parentColumn = "building_id",entityColumn = "id")
    public Building building;

}
