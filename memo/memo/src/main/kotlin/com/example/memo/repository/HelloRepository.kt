package com.example.memo.repository

import com.example.memo.entity.Hello
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HelloRepository : JpaRepository<Hello, String> {
    fun findByPointGreaterThan(point : Int) : List<Hello>
}