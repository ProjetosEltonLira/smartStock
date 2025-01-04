package com.portifolio.smartStock.service

import com.portifolio.smartStock.domain.CsvStockItem
import com.portifolio.smartStock.entity.PurchaseRequestEntity
import com.portifolio.smartStock.repository.PurchaseRequestRepository
import org.springframework.stereotype.Service
import java.io.IOException
import java.time.LocalDateTime
import kotlin.math.ceil


@Service
class SmartStockService(private val reportService: ReportService,
                        private val purchaseSectorService: PurchaseSectorService,
                        private val purchaseRequestRepository: PurchaseRequestRepository) {

    private final val PERCENTUAL_RECOMPRA_COM_MARGEM_SEGURANCA: Double = 0.2

    fun start(reportPath: String) {

        try {
            val items = reportService.readStockReport(reportPath)

            items.forEach { item ->
                if (item.quantity < item.reorderThreshold) {

                    val reorderQuantity = calculateReorderQuantity(item.reorderThreshold)
                    println(reorderQuantity)

                    val compraRealizada = purchaseSectorService.sendPurchaseRequest(
                        item = item,
                        purchaseQuantity = reorderQuantity
                    )
                    persist(item,reorderQuantity,compraRealizada)
                }
            }
        }
        catch ( e : IOException){
           throw RuntimeException(e)
        }
    }

    private fun persist(item: CsvStockItem, reorderQuantity: Int, compraRealizada: Boolean) {
        var purchaseEntity = PurchaseRequestEntity(
            itemId = item.itemId,
            itemName = item.itemName,
            quantityOnStock = item.quantity,
            reorderThreshold = item.reorderThreshold,
            supplierName = item.supplierName,
            supplierEmail = item.supplierEmail,
            lastStockUpdateTime = LocalDateTime.parse(item.lastStockUpdateTime),
            purchaseQuantity = reorderQuantity,
            purchasedWithSuccess = compraRealizada,
            purchaseDateTime = LocalDateTime.now(),
        )

        purchaseRequestRepository.save(purchaseEntity)
    }

    private fun calculateReorderQuantity(reorderThreshold: Int): Int {
        return (reorderThreshold + (ceil(reorderThreshold * PERCENTUAL_RECOMPRA_COM_MARGEM_SEGURANCA))).toInt()
    }

}
