package com.portifolio.smartStock.client.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class AuthResponse(
    @JsonProperty("access_token") val acessToken: String,
    @JsonProperty("expires_in") val expiresIn: Int,
)
