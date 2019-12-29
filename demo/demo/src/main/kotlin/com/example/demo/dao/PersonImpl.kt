package com.example.demo.dao

import com.example.demo.AppRunner
import com.example.demo.model.Person
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Repository
import java.util.*

@Repository("fakeDao")
class PersonImpl : PersonDao {
    private var DB = arrayListOf<Person>()

    override fun insertPerson(id: UUID, person: Person): Int {
        DB.add(Person(id, person.name))
        AppRunner().log("${person.name} added")
        return 1
    }

    override fun selectAllPeople(): List<Person> = DB

    override fun selectPersonById(id: UUID) : Person? {
        return DB.asSequence().filter { it.id!! == id }.first()
    }

    override fun deletePersonById(id: UUID) : Int {
        val person : Person = selectPersonById(id) ?: return 0
        DB.remove(person)
        return 1
    }

    override fun updatePersonById(id: UUID, person: Person) : Boolean {
        AppRunner().log("update $id to ${person.name}")
        val index = DB.indexOf(selectPersonById(id))
        AppRunner().log("index is $index")
        return if (index >= 0) {
            DB[index] = Person(id, person.name)
            true
        }
        else
            false
    }
}