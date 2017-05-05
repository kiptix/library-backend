package de.btc.library

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Book(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        val author: String,
        val title: String,
        val publisher: String,
        val isbn: String,
        val publication: String
)