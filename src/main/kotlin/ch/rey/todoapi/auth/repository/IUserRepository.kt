package ch.rey.todoapi.auth.repository

import ch.rey.todoapi.auth.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface IUserRepository :JpaRepository<User, Long>