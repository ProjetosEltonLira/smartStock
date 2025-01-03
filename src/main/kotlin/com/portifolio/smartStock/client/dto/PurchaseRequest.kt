package com.portifolio.smartStock.client.dto

import com.fasterxml.jackson.annotation.JsonProperty


//No java não é uma boa pratica fazer sneak_case.
data class PurchaseRequest(
    @JsonProperty ("item_id")        val itemId: String,
    @JsonProperty ("item_name")      val itemName: String,
    @JsonProperty ("supplier_name")  val supplierName: String,
    @JsonProperty ("supplier_email") val supplierEmail: String,
    @JsonProperty ("quantity")       val quantity: Int?
)