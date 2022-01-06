package com.example.sweprojekt.data;

import androidx.room.Embedded;
import androidx.room.Relation;

public class LogAndRoom {
    @Embedded
    public Log log;
    @Relation(parentColumn = "room_id",entityColumn = "id")
    public Room room;
}
