package com.example.migracion.service

import com.example.migracion.model.Manager
import com.example.migracion.repository.managerRespository
import org.apache.catalina.connector.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.server.ResponseStatusException

@Service
class ManagerService {
    @Autowired
    lateinit var managerRespository: managerRespository

    fun  list(): List<Manager>{
        return managerRespository.findAll()
    }
    fun save(manager: Manager):Manager{
        return managerRespository.save(manager)
    }

    fun update(manager: Manager):Manager{
        try {

            managerRespository.findById(manager.id)?: throw Exception("Ingrese otra ID")
            return managerRespository.save(manager)
        }
        catch(ex:Exception){
            throw  ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(manager: Manager):Manager{
        try {

          var response= managerRespository.findById(manager.id)?: throw Exception("Ingrese otra ID")
            response.apply {
                nickname=manager.nickname
            }
            return managerRespository.save(response)
        }
        catch(ex:Exception){
            throw  ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun delete(id: Long) {
        try {
            var response = managerRespository.findById(id).orElseThrow { throw ResponseStatusException(HttpStatus.NOT_FOUND, "El manager no existe en el Id: $id") }
            managerRespository.delete(response)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error eliminando manager", ex)
        }
    }
}

