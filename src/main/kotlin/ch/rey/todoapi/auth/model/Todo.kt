package ch.rey.todoapi.auth.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
class Todo (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,

    @get: NotBlank
    val titel: String ="",
    @get: NotBlank
    val todo: String =""
    )
