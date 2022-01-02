package com.example.sweprojekt.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM rcUser")
    List<User> getAll();

   @Query("SELECT * FROM rcUser WHERE first_name LIKE :first AND " +
                  "last_name LIKE :last LIMIT 1")
   User findByName(String first, String last);

    @Query("Select * From rcUser where id = :id Limit 1")
    User getByID(int id);

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);


}
