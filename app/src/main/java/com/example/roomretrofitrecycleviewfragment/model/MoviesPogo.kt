package com.example.roomretrofitrecycleviewfragment.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

data class MoviesPogoResult(
    val results: List<Result>
)
@Entity
@Parcelize
data class Result(
    @PrimaryKey
    val id: Int,
    val popularity: Double,
    val backdrop_path: String,
    val release_date: String,
    val original_title: String
    ) : Parcelable
