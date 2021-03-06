package com.example.memo.service

import com.example.memo.entity.Hello
import com.example.memo.repository.HelloRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

import org.junit.jupiter.api.Assertions.assertEquals
import java.util.*

@ExtendWith(SpringExtension::class)
@SpringBootTest
class HelloServiceTest(@Autowired private val helloRepository: HelloRepository) {
    @Test
    fun createTest() {
        val hello = Hello("hello", 100)
        helloRepository.save(hello)
        val test = helloRepository.findById("hello")
        assertEquals(test.get().point, 100)
    }

    @Test
    fun deleteAllTest() {
        helloRepository.deleteAll()
        val helloList = helloRepository.findAll()
        assertEquals(helloList.size, 0)
    }

    @Test
    fun deleteTest() {
        helloRepository.save(Hello("test", 100))
        helloRepository.deleteById("test")

        /* 두 가지 방법이 다 가능하다.
        assertThrows<NoSuchElementException> {
            helloRepository.findById("test").get()
        }
        */

        assertEquals(helloRepository.findById("test"), Optional.empty<Hello>())
    }
}
