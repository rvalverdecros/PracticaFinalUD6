package com.dam.api.models


import jakarta.persistence.*
import java.util.*

@Entity
@Table(name="users")
class Users(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long,

    @Column(name="nick")
    var nick:String,

    @Column(name="email")
    var email:String,

    @Column(name="password")
    var password:String,

    @Column(name="profilePicture")
    var profilePicture:String,

) {
}