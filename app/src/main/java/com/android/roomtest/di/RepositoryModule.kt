package com.android.roomtest.di

import com.android.roomtest.data.room.dao.PersonDao
import com.android.roomtest.data.room.repository.PersonRepository
import com.android.roomtest.data.room.repository.IPersonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    fun providePersonRepository(dao: PersonDao): IPersonRepository {
        return PersonRepository(dao)
    }

}