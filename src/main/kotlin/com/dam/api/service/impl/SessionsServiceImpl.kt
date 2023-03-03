package com.dam.api.service.impl

import com.dam.api.commons.GenericServiceImpl
import com.dam.api.models.Sessions
import com.dam.api.repositories.SessionsRepository
import com.dam.api.service.api.SessionsServiceAPI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class SessionsServiceImpl: SessionsServiceAPI, GenericServiceImpl<Sessions, Long>(){

    @Autowired
    lateinit var sessionsRepository: SessionsRepository

    override val dao: CrudRepository<Sessions, Long>
        get() = sessionsRepository
}