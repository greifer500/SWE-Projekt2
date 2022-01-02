package com.example.sweprojekt.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AttributeDao {

    @Query("SELECT * FROM rcAttribute")
    List<Attribute> getAll();

    @Query("Select * From rcAttribute where id = :id Limit 1")
    Attribute getByID(int id);

    @Insert
    void insertAll(Attribute... Attributes);

    @Delete
    void delete(Attribute attribute);
}
