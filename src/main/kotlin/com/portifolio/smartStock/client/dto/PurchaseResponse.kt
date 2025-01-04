package com.portifolio.smartStock.client.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class PurchaseResponse(
    @JsonProperty("message") val message: String,
)
