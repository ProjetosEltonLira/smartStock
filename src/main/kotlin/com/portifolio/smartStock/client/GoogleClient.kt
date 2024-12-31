package com.portifolio.smartStock.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping

// precisa definir um nome e coloca a URL da chamada.
@FeignClient (name = "GoogleClient", url = "https://www.google.com.br/")
interface GoogleClient {

    @GetMapping
    fun helloGoogle() : ResponseEntity<String>
}