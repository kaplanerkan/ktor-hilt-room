package com.android.roomtest.di
import com.android.roomtest.data.room.repository.PersonRepository
import com.android.roomtest.dataservice.KtorApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class KtorModule {
    @Provides
    fun provideKtorApplication(
        personRepository: PersonRepository,
        ): KtorApplication {
        return KtorApplication(
            personRepository = personRepository,
            )
    }
}