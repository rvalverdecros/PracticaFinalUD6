package com.dam.api.controllers

import com.dam.api.models.Movies
import com.dam.api.service.impl.MoviesServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin("*")
class MoviesController {

    @Autowired
    lateinit var moviesService: MoviesServiceImpl

    //url "api/v1/movies/"
    @GetMapping("/")
    fun getAll():ResponseEntity<MutableList<Movies>>{
        var listaMovies:MutableList<Movies>? = mutableListOf()
        listaMovies = moviesService.all
        return ResponseEntity(listaMovies, HttpStatus.OK)
    }

    //url "api/v1/movies/{id}"
    @GetMapping("/{id}")
    fun getOneProduct(@PathVariable id:String):ResponseEntity<Movies>{

        var idMov = id.toLong()
        var movie : Movies? = moviesService[idMov]

        return ResponseEntity<Movies>(movie,HttpStatus.OK)
    }

    @PostMapping("/")
    fun insertMovies(@RequestBody mov:Movies): ResponseEntity<String>{
        moviesService.save(mov)
        return ResponseEntity<String>("INSERTED", HttpStatus.OK)
    }
}