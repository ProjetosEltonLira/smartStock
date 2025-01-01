package com.portifolio.smartStock.client

import com.portifolio.smartStock.client.dto.AuthRequest
import com.portifolio.smartStock.client.dto.AuthResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(name = "AuthClient", url = "\${api.auth-url}")
interface AuthClient {

    @PostMapping(path = ["/api/token"])
    fun authenticate (@RequestBody request: AuthRequest) : ResponseEntity<AuthResponse>

}