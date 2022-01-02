package com.example.sweprojekt.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "rcUser")
public class User {
    @PrimaryKey (autoGenerate = true)
    public int id;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    @ColumnInfo(name = "password_salt")
    public String passwordSalt;

    @ColumnInfo(name = "password_hash")
    public String getPasswordHash;

    @ColumnInfo(name = "admin")
    public Integer admin;

}

