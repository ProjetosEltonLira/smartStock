package com.portifolio.smartStock.client.dto

import com.fasterxml.jackson.annotation.JsonProperty


//No java não é uma boa pratica fazer sneak_case.
data class AuthRequest(
    @JsonProperty ("grant_type")    val grantType: String,
    @JsonProperty ("client_id")     val clientId: String,
    @JsonProperty ("client_secret") val clientSecret: String
)
