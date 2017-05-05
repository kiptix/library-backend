package de.btc.library

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books")
class BookController(val bookRepository: BookRepository) {
    @GetMapping("/{id}/lend")
    fun lend(@PathVariable("id") id: Long, @RequestParam("user") user: String) :String{
        val book  = bookRepository.findById(id)
        book.ifPresent({
            it.user = user
            bookRepository.save(it)
        })
        return "ok";
    }
}