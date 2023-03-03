package com.dam.api.repositories

import com.dam.api.models.Users
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UsersRepository: CrudRepository<Users,Long> {
}