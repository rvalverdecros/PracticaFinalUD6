package com.dam.api.service.impl

import com.dam.api.commons.GenericServiceImpl
import com.dam.api.models.Movies
import com.dam.api.repositories.MoviesRepository
import com.dam.api.service.api.MoviesServiceAPI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class MoviesServiceImpl: MoviesServiceAPI, GenericServiceImpl<Movies, Long>(){

    @Autowired
    lateinit var moviesRepository: MoviesRepository

    override val dao: CrudRepository<Movies, Long>
        get() = moviesRepository
}