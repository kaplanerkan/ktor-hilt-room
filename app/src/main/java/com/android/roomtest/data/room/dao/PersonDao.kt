package com.android.roomtest.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.android.roomtest.data.room.model.Person

@Dao
interface PersonDao {
    @Insert
     fun insertPerson(person: Person) :Long

    @Update
     fun updatePerson(person: Person)

    @Delete
     fun deletePerson(person: Person)

    @Query("SELECT * FROM persons WHERE id = :personId")
     fun getPersonById(personId: Int): Person?

    @Query("SELECT * FROM persons ORDER BY id DESC LIMIT 1")
     fun getAllPersons(): List<Person>

    // Add other query methods as needed

    // Example of querying persons by first and last names
    @Query("SELECT * FROM persons WHERE first_name = :firstName AND last_name = :lastName")
     fun getPersonsByName(firstName: String, lastName: String): List<Person>
}