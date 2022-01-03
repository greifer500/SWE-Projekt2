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

    @Query("Select * From rcBuilding where building_prefix = :prefix AND description = :description Limit 1")
    Building getByName(String prefix, String description);

    @Insert
    void insertAll(Building... Buildings);

    @Delete
    void delete(Building building);
}
