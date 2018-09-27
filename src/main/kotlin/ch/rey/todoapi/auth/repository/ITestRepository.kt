package ch.rey.todoapi.auth.repository

import ch.rey.todoapi.auth.model.Test
import org.springframework.data.jpa.repository.JpaRepository

interface ITestRepository : JpaRepository<Test, Long>