package com.github.kiptix.library

import org.springframework.hateoas.MediaTypes
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books", produces = arrayOf(MediaTypes.HAL_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE))
class BookController(val bookRepository: BookRepository) {

    @PostMapping("/{id}/borrow")
    fun borrow(@PathVariable("id") id: Long, @RequestBody user: String): ResponseEntity<Any> {
        val book = bookRepository.findById(id)
        book.ifPresent({
            it.user = user
            bookRepository.save(it)
        })
        return ResponseEntity.ok().build<Any>();
    }

    @PostMapping("/{id}/return")
    fun returnBook(@PathVariable("id") id: Long): ResponseEntity<Any> {
        val book = bookRepository.findById(id)
        book.ifPresent({
            it.user = null
            bookRepository.save(it)
        })
        return ResponseEntity.ok().build<Any>();
    }
}
