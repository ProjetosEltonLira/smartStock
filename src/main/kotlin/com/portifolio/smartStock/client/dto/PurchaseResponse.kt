package com.portifolio.smartStock.client.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class PurchaseResponse(
    @JsonProperty("message") val message: String,
)
