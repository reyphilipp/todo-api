package ch.rey.todoapi.auth.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
class Test (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        //GenerationType.TABLE
        val id: Long = 0,

        @get: NotNull
        val temp: Double =0.0,
        @get: NotBlank
        val zimmer: String =""
)