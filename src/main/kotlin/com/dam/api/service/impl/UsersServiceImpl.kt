package com.dam.api.service.impl

import com.dam.api.commons.GenericServiceImpl
import com.dam.api.models.Users
import com.dam.api.repositories.UsersRepository
import com.dam.api.service.api.UsersServiceAPI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class UsersServiceImpl: UsersServiceAPI, GenericServiceImpl<Users, Long>(){

    @Autowired
    lateinit var usersRepository: UsersRepository

    override val dao: CrudRepository<Users, Long>
        get() = usersRepository
}