package ch.rey.todoapi.auth.controller

import ch.rey.todoapi.auth.model.Test
import ch.rey.todoapi.auth.model.TestService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/test-api")
class TestController(val testService: TestService) {

    @PostMapping("/addTest")
    fun addTest(@Valid @RequestBody test: Test): ResponseEntity<Test> {
        val test: Test =testService.addTest(test)
        return ResponseEntity.ok(test)
    }

    @GetMapping("/tests")
    fun getAllTests():List<Test>{
        return testService.getAllTests()
    }
    //test mit Int
    @GetMapping("/test")
    fun getInt():Int{
        return testService.getInt()
    }

    @GetMapping("/tests/{id}")
    fun getTestById(@PathVariable(value = "id") testId :Long):ResponseEntity<Test>{
        return testService.getTest(testId)
    }

    @PutMapping("/tests/{id}")
    fun updateTestById(@Valid @RequestBody test: Test, @PathVariable(value = "id") testId :Long): ResponseEntity<Any>{
        return testService.putTest(testId, test)
    }

    @DeleteMapping("/tests/{id}")
    fun deleteTestById(@PathVariable(value = "id") testId :Long): ResponseEntity<Any>{
        return testService.deleteTest(testId)
    }
}