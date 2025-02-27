package com.android.roomtest.data.room.model
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "persons")
data class Person(
    @PrimaryKey(autoGenerate = true)
    val id: Int ,
    val last_update: Long,
    val first_name: String,
    val last_name: String,
    val phone: String?,
    val description: String?
)