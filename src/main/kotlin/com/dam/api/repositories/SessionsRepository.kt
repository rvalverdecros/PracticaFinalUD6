package com.dam.api.repositories


import com.dam.api.models.Sessions
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SessionsRepository: CrudRepository<Sessions,Long> {
}