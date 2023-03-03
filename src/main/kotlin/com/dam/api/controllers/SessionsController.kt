package com.dam.api.controllers


import com.dam.api.models.Movies
import com.dam.api.models.Sessions
import com.dam.api.service.impl.MoviesServiceImpl
import com.dam.api.service.impl.SessionsServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*


@RestController
@RequestMapping("/api/v1/sessions")
@CrossOrigin("*")
class SessionsController {

    @Autowired
    lateinit var sessionsService: SessionsServiceImpl

    //url "api/v1/sessions/"
    @GetMapping("/")
    fun getAll():ResponseEntity<MutableList<Sessions>>{
        var listaSessions:MutableList<Sessions>? = mutableListOf()
        listaSessions = sessionsService.all
        return ResponseEntity(listaSessions, HttpStatus.OK)
    }

    fun visualizarfun(res:MutableList<Sessions>):MutableList<Sessions>{
        val returnList: MutableList<Sessions> = mutableListOf()
        res.forEach{ obj: Sessions -> returnList.add(obj) }
        return returnList
    }
    //url "api/v1/sessions/sincetoday"
    @GetMapping("/sincetoday")
    fun getSinceToday():ResponseEntity<MutableList<Sessions>> {
        val hoy = LocalDateTime.now()
        val date = LocalDate.of(hoy.year, hoy.month, hoy.dayOfMonth)
        var listaSessions: MutableList<Sessions>? = mutableListOf()
        var listaSessionsToday: MutableList<Sessions>? = mutableListOf()
        listaSessions = sessionsService.all
        if (listaSessions != null) {
            for (i in 0..listaSessions.size-1) {
                val fecha = listaSessions[i].date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
                if (fecha.year > date.year) {
                    listaSessionsToday?.add(listaSessions[i])
                    }
                if(fecha.year == date.year && fecha.monthValue > date.monthValue){
                    listaSessionsToday?.add(listaSessions[i])
                }
                if(fecha.year == date.year && fecha.monthValue == date.monthValue && fecha.dayOfMonth > date.dayOfMonth){
                    listaSessionsToday?.add(listaSessions[i])
                }
                if(fecha.year == date.year && fecha.monthValue == date.monthValue && fecha.dayOfMonth == date.dayOfMonth){
                    listaSessionsToday?.add(listaSessions[i])
                }
            }
        }
        return ResponseEntity(listaSessionsToday, HttpStatus.OK)
    }

    //url "api/v1/sessions/today"
    @GetMapping("/today")
    fun getToday():ResponseEntity<MutableList<Sessions>>{
        val hoy = LocalDateTime.now()
        val date = LocalDate.of(hoy.year, hoy.month, hoy.dayOfMonth)
        var listaSessions:MutableList<Sessions>? = mutableListOf()
        var listaSessionsToday:MutableList<Sessions>? = mutableListOf()
        listaSessions = sessionsService.all
        if (listaSessions != null) {
            for (i in 0..listaSessions.size-1){
                val fecha = listaSessions[i].date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
                if (fecha.year == date.year && fecha.monthValue == date.monthValue && fecha.dayOfMonth == date.dayOfMonth){
                    listaSessionsToday?.add(listaSessions[i])
                }
            }
        }
        return ResponseEntity(listaSessionsToday, HttpStatus.OK)
    }

    //url "api/v1/sessions/"
    @PostMapping("/")
    fun insertSessions(@RequestBody sessions: Sessions): ResponseEntity<String>{
        sessionsService.save(sessions)
        return ResponseEntity<String>("INSERTED", HttpStatus.OK)
    }
}