package de.btc.library

import javax.persistence.Entity

@Entity
data class Lending(val book: Book, val user: String)