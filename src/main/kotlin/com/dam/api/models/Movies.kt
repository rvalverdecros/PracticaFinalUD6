package com.dam.api.models

import jakarta.persistence.*

@Entity
@Table(name="movies")
class Movies(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long,

    @Column(name="title")
    var title:String,

    @Column(name="director")
    var director:String,

    @Column(name="time")
    var time:String,

    @Column(name="trailer")
    var trailer:String,

    @Column(name="poster_image")
    var poster_image:String,

    @Column(name="screenshot")
    var screenshot:String,


    @Column(name="synopsis", columnDefinition = "TEXT")
    var synopsis:String,




)