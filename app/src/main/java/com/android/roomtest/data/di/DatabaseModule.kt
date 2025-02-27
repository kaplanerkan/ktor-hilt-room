package com.android.roomtest.data.di

import android.content.Context
import androidx.room.Room
import com.android.roomtest.data.room.AppDatabase
import com.android.roomtest.data.room.dao.PersonDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext app: Context) =
      Room.databaseBuilder(app, AppDatabase::class.java, "db").build()
    @Provides
    fun personDao(appDatabase: AppDatabase): PersonDao {
        return appDatabase.personDao()
    }
}