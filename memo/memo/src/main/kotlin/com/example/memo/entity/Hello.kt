package com.example.memo.entity

import javax.persistence.*

@Entity
class Hello(
        @Id
        @Column(name = "id")
        val id : String= "def",
        val point : Int = 0)