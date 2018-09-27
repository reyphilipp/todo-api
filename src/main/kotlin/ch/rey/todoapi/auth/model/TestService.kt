package ch.rey.todoapi.auth.model

import ch.rey.todoapi.auth.repository.ITestRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import kotlin.streams.toList

@Service
class TestService(@Autowired val repository : ITestRepository) {

    fun addTest(test:Test):Test{
        repository.save(test)
        return test
    }

    fun getAllTests():List<Test>{
        return repository.findAll().stream().map { test -> Test(test.id, temp = test.temp, zimmer = "") }
                .toList()
    }

    fun getInt():Int{
        return 44
    }

    fun getTest(id:Long):ResponseEntity<Test>{
        val result = repository.findById(id)

        if (result.isPresent){
            return ResponseEntity.ok(result.get())
        }
        return ResponseEntity.notFound().build()
    }

    fun putTest(id: Long, test: Test): ResponseEntity<Any> {
        val result = repository.findById(id)

        if (result.isPresent){
            repository.save(Test(test.id, test.temp, test.zimmer))
            return ResponseEntity.ok().build()
        }
        return ResponseEntity.notFound().build()
    }

    fun deleteTest(id: Long): ResponseEntity<Any> {
        val result = repository.findById(id)

        if (result.isPresent){
            repository.delete(result.get())
            return ResponseEntity.ok().build()
        }
        return ResponseEntity.notFound().build()
    }

}