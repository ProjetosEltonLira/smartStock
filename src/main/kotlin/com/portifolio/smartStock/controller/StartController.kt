package com.portifolio.smartStock.controller

import com.portifolio.smartStock.controller.dto.StartDto
import com.portifolio.smartStock.service.SmartStockService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.CompletableFuture


@RestController
class StartController (
    private val smartStockService : SmartStockService){

    @PostMapping(path = ["/start"])
    fun start(@RequestBody dto: StartDto) : ResponseEntity<Void>{

        CompletableFuture.runAsync {
            smartStockService.process(dto.reportPath)
        }

        return ResponseEntity.accepted().build()     //Utilizado quando temos comportamento assincrono, damos a resposta rapida de que a chamada foi aceita
    }
}