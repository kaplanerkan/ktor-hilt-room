package com.android.roomtest.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.android.roomtest.data.room.model.Person
import com.android.roomtest.data.room.converter.RoomConverter
import com.android.roomtest.data.room.dao.PersonDao


@Database(
    entities = [

        Person::class,

    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(RoomConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun personDao(): PersonDao


}