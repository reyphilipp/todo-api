package ch.rey.todoapi.auth.model

import ch.rey.todoapi.auth.repository.IUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.streams.toList

@Service
class AuthService(@Autowired val repository : IUserRepository) {

    fun registUser(user:User):User{
        repository.save(user)
        return user
    }

    fun getAllUsers():List<User>{
        return repository.findAll().stream().map { user -> User(user.id, username = user.username, password = "") }
                .toList()
    }

}