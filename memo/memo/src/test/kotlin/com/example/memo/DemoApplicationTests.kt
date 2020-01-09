package com.example.memo

import com.example.memo.entity.Hello
import com.example.memo.repository.HelloRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

import org.junit.jupiter.api.Assertions.assertEquals

@ExtendWith(SpringExtension::class)
@SpringBootTest
class DemoApplicationTests(@Autowired private val helloRepository: HelloRepository) {
	@Test
	fun createTest() {
		val hello = Hello("hello", 100)
		helloRepository.save(hello)
		val test = helloRepository.findAll()[0]
		assertEquals(test.point, 100)
	}

	@Test
	fun deleteAllTest() {
		helloRepository.deleteAll()
		val helloList = helloRepository.findAll()
		assertEquals(helloList.size, 0)
	}
}
