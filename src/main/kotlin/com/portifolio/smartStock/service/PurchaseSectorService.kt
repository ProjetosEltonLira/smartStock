package com.portifolio.smartStock.service

import com.portifolio.smartStock.domain.CsvStockItem
import org.springframework.stereotype.Service

@Service
class PurchaseSectorService (private var authService: AuthService){


    fun sendPurchaseRequest(item: CsvStockItem, purchaseQuantity : Int) : Boolean {

        // authencation
        var token = authService.getAuth()

        //enviar solicitação de compra

        // validar se a respota veio com sucesso

        return true
    }
}