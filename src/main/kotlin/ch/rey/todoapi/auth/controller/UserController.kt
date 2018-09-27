package ch.rey.todoapi.auth.controller

import ch.rey.todoapi.auth.model.AuthService
import ch.rey.todoapi.auth.model.User
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/user-api")
class UserController(val authService: AuthService) {
    @PostMapping("/registration")
    fun registerUser(@Valid @RequestBody user: User):ResponseEntity<User>{
        val user:User=authService.registUser(user)
        return ResponseEntity.ok(user)


    }

    @GetMapping("/users")
    fun getAllUsers():List<User>{
        return authService.getAllUsers()
    }


    //test mit Int
    @GetMapping("/int")
    fun getInt():Int{
        return 6
    }
}