package com.portifolio.smartStock.client

import com.portifolio.smartStock.client.dto.PurchaseRequest
import com.portifolio.smartStock.client.dto.PurchaseResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient (name = "PurchaseSectorClient", url = "\${api.purchase-sector-url}")
interface PurchaseSectorClient {

    @PostMapping(path = ["/api/purchases"])
    fun purchase (@RequestBody request: PurchaseRequest,
                  @RequestHeader authorization: String)
    : ResponseEntity<PurchaseResponse>
}