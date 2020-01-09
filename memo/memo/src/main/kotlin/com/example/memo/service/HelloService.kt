package com.example.memo.service

import com.example.memo.entity.Hello
import com.example.memo.repository.HelloRepository
import org.springframework.stereotype.Service

@Service
class HelloService(private val helloRepository: HelloRepository) {
    fun createHello (hello : Hello) = helloRepository.save(hello)
    fun readHello(): MutableList<Hello> = helloRepository.findAll()
    fun updateHello(hello: Hello) = helloRepository.save(hello)
    fun deleteHello (id : String) = helloRepository.deleteById(id)
    fun deleteAllHello() = helloRepository.deleteAll()
}