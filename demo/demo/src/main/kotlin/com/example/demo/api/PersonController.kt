package com.example.demo.api

import com.example.demo.model.Person
import com.example.demo.service.PersonService
import org.jetbrains.annotations.NotNull
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RequestMapping("clover")
@RestController
class PersonController(private val personService: PersonService) {
    @PostMapping
    fun addPerson(@Valid @NotNull @RequestBody person : Person) {
        personService.addPerson(person)
    }

    @GetMapping
    fun getAllPeople() : List<Person> = personService.getAllPeople()

    @GetMapping(path = ["/{id}"])
    fun getPersonById(@PathVariable("id") id : UUID) = personService.getPersonById(id)

    @DeleteMapping(path = ["/{id}"])
    fun deletePersonById(@PathVariable("id") id : UUID) {
        personService.deletePerson(id)
    }

    @PutMapping(path = ["/{id}"])
    fun updatePerson(@PathVariable("id") id : UUID, @Valid @NotNull @RequestBody person : Person) {
        personService.updatePerson(id, person)
    }

    @RequestMapping(path = ["/"])
    fun hello() = "Hello World!"
}