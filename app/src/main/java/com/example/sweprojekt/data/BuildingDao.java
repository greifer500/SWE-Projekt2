package com.example.sweprojekt.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BuildingDao {
    @Query("SELECT * FROM rcBuilding")
    List<Building> getAll();

    @Query("Select * From rcBuilding where id = :id Limit 1")
    Building getByID(int id);

    @Insert
    void insertAll(Building... Buildings);

    @Delete
    void delete(Building building);
}
