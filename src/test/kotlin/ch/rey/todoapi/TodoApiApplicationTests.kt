package ch.rey.todoapi

import ch.rey.todoapi.auth.controller.TodoController
import ch.rey.todoapi.auth.model.Todo
import ch.rey.todoapi.auth.repository.ITodoRepository
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import javax.inject.Inject



@RunWith(SpringRunner::class)
@SpringBootTest
class TodoApiApplicationTests {

    @Inject
    //lateinit var iUserRepository: IUserRepository
    lateinit var  iTodoRepository: ITodoRepository

	/*@Test
	fun contextLoads() {

		val sut = AuthService(iUserRepository)

        val user = sut.registUser(User(username = "Max", password = "123"))

        Assert.assertThat(user.id, CoreMatchers.not(0L))

	}*/

    @Test
    fun contextLoads(){
        val sut = TodoController(iTodoRepository)

        val todo = sut.createTodo((Todo(titel = "hh", todo = "hoi" )))

        Assert.assertThat(todo.statusCodeValue, CoreMatchers.equalTo(200))

    }



}
