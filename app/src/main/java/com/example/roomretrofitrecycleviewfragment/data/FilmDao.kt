package com.example.roomretrofitrecycleviewfragment.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomretrofitrecycleviewfragment.model.Result

@Dao
interface FilmDao {

    @Insert
    fun insertFilm(film: Result)

    @Query("select * from Result")
    fun getAllNotes(): LiveData<List<Result>>
}