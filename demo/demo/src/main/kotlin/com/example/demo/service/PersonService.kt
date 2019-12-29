package com.example.demo.service

import com.example.demo.dao.PersonDao
import com.example.demo.model.Person
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonService(@Qualifier("fakeDao") private val personDao: PersonDao) {
    fun addPerson(person : Person) : Int {
        return personDao.insertPerson(person)
    }

    fun getAllPeople() : List<Person> = personDao.selectAllPeople()

    fun getPersonById (id : UUID) = personDao.selectPersonById(id)

    fun deletePerson (id : UUID) = personDao.deletePersonById(id)

    fun updatePerson(id : UUID, person : Person) = personDao.updatePersonById(id, person)
}