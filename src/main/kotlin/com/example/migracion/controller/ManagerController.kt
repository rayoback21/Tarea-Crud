package com.example.migracion.controller

import com.example.migracion.model.Manager
import com.example.migracion.service.ManagerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/manager")
class ManagerController {
    @Autowired
    lateinit var managerService: ManagerService

    @GetMapping
    fun list(): List<Manager> {
        return managerService.list()
    }
    @PostMapping
    fun save(@RequestBody manager: Manager):Manager {
        return managerService.save(manager)
    }
    @PutMapping
    fun update(@RequestBody manager: Manager): ResponseEntity<Manager> {
        return ResponseEntity(managerService.update(manager),HttpStatus.OK)
    }
    @PatchMapping
    fun updateName(@RequestBody manager: Manager): ResponseEntity<Manager> {
        return ResponseEntity(managerService.updateName(manager),HttpStatus.OK)
    }
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<String> {
        managerService.delete(id)
        return ResponseEntity("Manager eliminado",HttpStatus.OK)
    }

}