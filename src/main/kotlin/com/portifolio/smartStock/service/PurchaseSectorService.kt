package com.portifolio.smartStock.service

import com.portifolio.smartStock.client.PurchaseSectorClient
import com.portifolio.smartStock.client.dto.PurchaseRequest
import com.portifolio.smartStock.domain.CsvStockItem
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service


@Service
class PurchaseSectorService (private var authService: AuthService,
                             private var purchaseSectorClient: PurchaseSectorClient){

    private val logger : Logger = LoggerFactory.getLogger(PurchaseSectorService::class.java)

    fun sendPurchaseRequest(item: CsvStockItem, purchaseQuantity : Int) : Boolean {

        // authencation
        var token = authService.getAuth()

        var requestBody = PurchaseRequest(
            itemId = item.itemId,
            itemName = item.itemName,
            supplierName = item.supplierName ,
            supplierEmail = item.supplierEmail,
            quantity = purchaseQuantity
        )
        //enviar solicitação de compra
        var purchaseResponse = purchaseSectorClient.purchase(
            request = requestBody,
            authorization = token
        )

        // validar se a respota veio com sucesso
        if (!purchaseResponse.statusCode.value().equals(HttpStatus.ACCEPTED.value())) {
            logger.error(
                "Error while sending purchase ," +
                        "statuscode: {} " +
                        "requestBody: {} ", purchaseResponse.statusCode, purchaseResponse.body
            )
            return false
        }
        return true
    }
}