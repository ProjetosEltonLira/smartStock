package com.portifolio.smartStock.service

import org.springframework.stereotype.Service
import java.io.IOException
import kotlin.math.ceil


@Service
class SmartStockService(private val reportService: ReportService,
                        private val purchaseSectorService: PurchaseSectorService) {

    private final val PERCENTUAL_RECOMPRA_COM_MARGEM_SEGURANCA: Double = 0.2

    fun start(reportPath: String) {

        try {
            var items = reportService.readStockReport(reportPath)

            items.forEach { item ->
                if (item.quantity < item.reorderThreshold) {

                    var reorderQuantity = calculateReorderQuantity(item.reorderThreshold)
                    println(reorderQuantity)

                    var compraRealizada = purchaseSectorService.sendPurchaseRequest(
                        item = item,
                        purchaseQuantity = reorderQuantity
                    )
                }
            }
        }
        catch ( e : IOException){
           throw RuntimeException(e)
        }
    }

    private fun calculateReorderQuantity(reorderThreshold: Int): Int {
        return (reorderThreshold + (ceil(reorderThreshold * PERCENTUAL_RECOMPRA_COM_MARGEM_SEGURANCA))).toInt()
    }

}
