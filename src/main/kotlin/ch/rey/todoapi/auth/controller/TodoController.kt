package ch.rey.todoapi.auth.controller

import ch.rey.todoapi.auth.model.Todo
import ch.rey.todoapi.auth.model.User
import ch.rey.todoapi.auth.repository.ITodoRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import kotlin.streams.toList


@RestController
@RequestMapping("/todo-api")
class TodoController(val todoRepository: ITodoRepository) {

    @PostMapping("/todos")
    fun createTodo(@Valid @RequestBody todo: Todo): ResponseEntity<Todo> {
        val savedTodo = todoRepository.save(todo)
        return ResponseEntity.ok(savedTodo)
    }

    @GetMapping("/todos")
    fun getAllTodos(): List<Todo> {
        return todoRepository.findAll()
        //Für Filterung
        /*return todoRepository.findAll().stream().map { todo -> Todo(titel = todo.titel, todo = todo.todo) }
                .toList()*/
    }

    @GetMapping("/todos/{id}")
    fun getTodoById(@PathVariable(value = "id") todoId :Long):ResponseEntity<Todo>{
        val result = todoRepository.findById(todoId)

        if (result.isPresent){
            return ResponseEntity.ok(result.get())
        }
        return ResponseEntity.notFound().build()
    }

    @PutMapping("/todos/{id}")
    fun updateTodoById(@Valid @RequestBody todo: Todo, @PathVariable(value = "id") todoId :Long): ResponseEntity<Any>{
        val result = todoRepository.findById(todoId)

        if (result.isPresent){
            todoRepository.save(Todo(todoId, todo.titel, todo.todo))
            return ResponseEntity.ok().build()
        }
        return ResponseEntity.notFound().build()
    }

    @DeleteMapping("/todos/{id}")
    fun deleteTodoById(@PathVariable(value = "id") todoId :Long): ResponseEntity<Any>{
        val result = todoRepository.findById(todoId)

        if (result.isPresent){
            todoRepository.delete(result.get())
            return ResponseEntity.ok().build()
        }
        return ResponseEntity.notFound().build()
    }

}