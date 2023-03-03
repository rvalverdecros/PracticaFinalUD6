package com.dam.api.controllers

import com.dam.api.models.Sessions
import com.dam.api.models.Users
import com.dam.api.service.impl.UsersServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin("*")
class UsersController {

    @Autowired
    lateinit var usersService: UsersServiceImpl

    //url "api/v1/users/"
    @GetMapping("/")
    fun getAll():ResponseEntity<MutableList<Users>>{
        var listaUsers:MutableList<Users>? = mutableListOf()
        listaUsers = usersService.all
        return ResponseEntity(listaUsers, HttpStatus.OK)
    }

    //url "api/v1/users/{nick}"
    @GetMapping("/{nick}")
    fun getOneUser(@PathVariable nick:String):ResponseEntity<Users>{
        var listaUsers:MutableList<Users>? = mutableListOf()
        var res : Users? = null
        listaUsers = usersService.all
        if (listaUsers != null) {
            for (i in 0.. listaUsers.size-1){
                if (listaUsers[i].nick == nick){
                    res = listaUsers[i]
                }
            }
        }
        return ResponseEntity(res, HttpStatus.OK)
    }

    //url "api/v1/users/"
    @PostMapping("/")
    fun insertSessions(@RequestBody users: Users): ResponseEntity<String>{
        usersService.save(users)
        return ResponseEntity<String>("INSERTED", HttpStatus.OK)
    }

    //url "api/v1/users/{nick}"
    @PutMapping("/{nick}")
    fun actUsers(@RequestBody user:Users, @PathVariable nick: String): ResponseEntity<String>{
        usersService.save(user)
        return ResponseEntity<String>("UPDATED", HttpStatus.OK)
    }

    //url "api/v1/users/{nick}"
    @DeleteMapping("/{nick}")
    fun deleteUsers(@PathVariable nick: String): ResponseEntity<String>{
        var listaUsers:MutableList<Users>? = mutableListOf()
        var res : Users? = null
        listaUsers = usersService.all
        if (listaUsers != null) {
            for (i in 0.. listaUsers.size-1){
                if (listaUsers[i].nick == nick){
                    res = listaUsers[i]
                }
            }
        }
        if (res != null) {
            usersService.delete(res.id.toLong())
        }
        return ResponseEntity<String>("DELETED", HttpStatus.OK)
    }
}