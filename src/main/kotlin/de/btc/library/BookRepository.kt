package de.btc.library

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional

interface BookRepository : JpaRepository<Book, Long> {

    fun findByIsbn(@Param("isbn") isbn: String): List<Book>
    fun findByTitleContains(@Param("title") title: String): List<Book>

    @Query("update Book x set x.user =:username where x.isbn=:isbn")
    @Modifying
    @Transactional
    fun setUserOnBook(@Param("username") username: String, @Param("isbn") isbn: String)


}
