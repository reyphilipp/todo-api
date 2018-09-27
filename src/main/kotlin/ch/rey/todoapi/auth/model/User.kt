package ch.rey.todoapi.auth.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank


@Entity
//wenn anderer Tablename @Entity(name = "UserTable")
class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,

        @get: NotBlank
        val username: String ="",
        @get: NotBlank
        val password: String =""
)