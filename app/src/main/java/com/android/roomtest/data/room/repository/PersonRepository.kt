package com.android.roomtest.data.room.repository

import com.android.roomtest.data.ApiResponse
import com.android.roomtest.data.room.dao.PersonDao
import com.android.roomtest.data.room.model.Person
import com.android.roomtest.data.room.roomResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PersonRepository @Inject constructor(private val dao: PersonDao) :
    IPersonRepository {
    override fun insertPerson(person: Person): Flow<ApiResponse<Long?>> = roomResult {
        dao.insertPerson(person)
    }.flowOn(Dispatchers.IO)

    override fun updatePerson(person: Person): Flow<ApiResponse<Unit?>> = roomResult {
        dao.updatePerson(person)
    }.flowOn(Dispatchers.IO)
    override fun deletePerson(person: Person): Flow<ApiResponse<Unit?>> = roomResult {
        dao.deletePerson(person)
    }.flowOn(Dispatchers.IO)

    override fun getAllPersons(): Flow<ApiResponse<List<Person>?>> = roomResult {
        dao.getAllPersons()
    }.flowOn(Dispatchers.IO)

    override fun getPersonById(personId: Int): Flow<ApiResponse<Person?>> = roomResult {
        dao.getPersonById(personId)
    }.flowOn(Dispatchers.IO)

    override fun getPersonsByName(firstName: String, lastName: String): Flow<ApiResponse<List<Person>?>> = roomResult {
        dao.getPersonsByName(firstName, lastName)
    }.flowOn(Dispatchers.IO)
}