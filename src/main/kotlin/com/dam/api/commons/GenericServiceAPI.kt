package com.dam.api.commons

import jakarta.persistence.Entity

interface GenericServiceAPI<T, ID> {

    fun save(entity: T):T
    fun delete(id:ID)
    operator fun get(id:ID): T?
    val all: MutableList<T>?

}