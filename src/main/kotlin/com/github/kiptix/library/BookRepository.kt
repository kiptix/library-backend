package com.github.kiptix.library

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param

interface BookRepository : JpaRepository<Book, Long> {

    fun findByIsbn(@Param("isbn") isbn: String): List<Book>
    fun findByTitleContains(@Param("title") title: String): List<Book>
}
