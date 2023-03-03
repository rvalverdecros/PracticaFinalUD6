package com.dam.api.models


import jakarta.persistence.*
import java.util.*

@Entity
@Table(name="sessions")
class Sessions(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long,

    @Column(name="movie_id")
    var movie_id:Int,

    @Column(name="room_id")
    var room_id:Int,

    @Column(name="date")
    var date: Date,
){

}