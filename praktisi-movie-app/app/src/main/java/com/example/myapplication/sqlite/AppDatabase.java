package com.example.myapplication.sqlite;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myapplication.models.Movie;
import com.example.myapplication.models.Note;
import com.example.myapplication.models.TvShow;
import com.example.myapplication.sqlite.dao.MovieDao;
import com.example.myapplication.sqlite.dao.NoteDao;
import com.example.myapplication.sqlite.dao.TvShowDao;

@Database(
        entities = {
                Movie.class,
                TvShow.class,
                Note.class
        },
        version = 1,
        exportSchema = false
)

public abstract class AppDatabase extends RoomDatabase {
    public abstract MovieDao movieDao();
    public abstract TvShowDao tvShowDao();

    public abstract NoteDao noteDao();

    private static AppDatabase instance;

    public static AppDatabase getInstance() {
        return instance;
    }

    public static void createDatabase(Context context) {
        instance = Room.databaseBuilder(
                        context.getApplicationContext(),
                        AppDatabase.class,
                        "my_movie_app"
                )
                .allowMainThreadQueries()
                .build();
    }

}
