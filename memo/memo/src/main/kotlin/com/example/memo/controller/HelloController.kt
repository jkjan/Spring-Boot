package com.example.memo.controller

import com.example.memo.entity.Hello
import com.example.memo.service.HelloService
import org.jetbrains.annotations.NotNull
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class HelloController(private val helloService: HelloService) {
    @RequestMapping(path = ["/"])
    fun hello() = "Hello World!"

    @PostMapping(path = ["/"])
    fun createHello(@Valid @NotNull @RequestBody hello : Hello) {
        helloService.createHello(hello)
    }

    @GetMapping(path = ["/"])
    fun readHello(): List<Hello> = helloService.readHello()

    @PutMapping(path = ["/{id}"])
    fun updateHello(@PathVariable("id") id : String, @Valid @NotNull @RequestBody hello: Hello) {
        helloService.updateHello(hello)
    }

    @DeleteMapping(path = ["/{id}"])
    fun deleteHello(@PathVariable("id") id : String) {
        helloService.deleteHello(id)
    }

    @DeleteMapping(path = ["/warning/deleteAll"])
    fun deleteAllHello() {
        helloService.deleteAllHello()
    }

    @GetMapping(path = ["/{point}"])
    fun findRicherThan(@PathVariable("point") point : Int) = helloService.findRicherThan(point)
}