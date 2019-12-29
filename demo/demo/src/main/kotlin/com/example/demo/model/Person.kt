package com.example.demo.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*
import javax.validation.constraints.NotBlank

data class Person(@JsonProperty("id") val id : UUID?,
                  @NotBlank @JsonProperty("name") val name : String)