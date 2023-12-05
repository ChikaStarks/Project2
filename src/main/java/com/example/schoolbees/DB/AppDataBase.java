package com.example.schoolbees.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.schoolbees.LoginActivity;
import com.example.schoolbees.User;

@Database(entities = {User.class}, version = 6)
public abstract class AppDataBase extends RoomDatabase{

    public static final String DATABASE_NAME = "schoolbees.db";
    public static final String User_TABLE = "user_table";
    public static final String USER_TABLE2 = "USER_TABLE2";  //sign in info
    public abstract UserDao getUserDao();


    private static volatile AppDataBase instance;
    private static final Object LOCK = new Object();


    public static AppDataBase getInstance(Context context){
        if(instance == null){
            synchronized (LOCK){
                if(instance == null){
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDataBase.class,
                            DATABASE_NAME).fallbackToDestructiveMigration().build(); //added fallbackToDestructiveMigration()
                }
            }
        }
        return instance;
    }
}