package com.example.sweprojekt.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class rcDataBase extends RoomDatabase {
    public abstract UserDao userDoa();


    private static final String DB_NAME = "rcDataBase.db";
    private static volatile rcDataBase instance;

    public static synchronized rcDataBase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;

    }

    protected rcDataBase() { }

    private static rcDataBase create(final Context context) {
        return Room.databaseBuilder(
                context,
                rcDataBase.class,
                DB_NAME).build();
    }
}
