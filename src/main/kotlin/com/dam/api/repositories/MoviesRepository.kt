package com.dam.api.repositories

import com.dam.api.models.Movies
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MoviesRepository: CrudRepository<Movies,Long> {
}