package com.android.roomtest.data.room.repository

import com.android.roomtest.data.ApiResponse
import com.android.roomtest.data.room.model.Person
import kotlinx.coroutines.flow.Flow

interface IPersonRepository {
     fun insertPerson(person: Person): Flow<ApiResponse<Long?>>

     fun updatePerson(person: Person): Flow<ApiResponse<Unit?>>

     fun deletePerson(person: Person): Flow<ApiResponse<Unit?>>

     fun getPersonById(personId: Int): Flow<ApiResponse<Person?>>

     fun getAllPersons(): Flow<ApiResponse<List<Person>?>>

    // Add other query methods as needed

     fun getPersonsByName(firstName: String, lastName: String): Flow<ApiResponse<List<Person>?>>
}