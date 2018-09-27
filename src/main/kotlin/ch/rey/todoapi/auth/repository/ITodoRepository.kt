package ch.rey.todoapi.auth.repository

import ch.rey.todoapi.auth.model.Todo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ITodoRepository:JpaRepository<Todo, Long> {
}