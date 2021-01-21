package com.example.roomretrofitrecycleviewfragment.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomretrofitrecycleviewfragment.model.MoviesPogoResult
import com.example.roomretrofitrecycleviewfragment.model.Result

@Database(entities = [Result::class], version = 1, exportSchema = false)
abstract class FilmDB : RoomDatabase() {
    abstract fun getDoaInstance(): FilmDao

    companion object {
        var instance: FilmDB? = null
        fun getFilmsDB(context: Context): FilmDB {
            instance ?: synchronized(this) {
                instance = Room.databaseBuilder(context, FilmDB::class.java, "FilmsDBRoom").build()
            }
            return instance!!
        }
    }
}