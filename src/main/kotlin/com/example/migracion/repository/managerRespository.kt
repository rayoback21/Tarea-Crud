package com.example.migracion.repository

import com.example.migracion.model.Manager
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface managerRespository:JpaRepository<Manager, Long> {
    fun findById(id:Long?):Manager?
}