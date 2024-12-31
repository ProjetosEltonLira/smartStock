package com.portifolio.smartStock.domain

import com.opencsv.bean.CsvBindByName

data class CsvStockItem(

    @CsvBindByName (column = "item_id")
    var itemId: String = "",

    @CsvBindByName (column = "item_name")
    var itemName: String= "",

    @CsvBindByName (column = "quantity")
    var quantity: Int = 0 ,

    @CsvBindByName (column = "reorder_threshold")
    var reorderThreshold: Int = 0,

    @CsvBindByName (column = "supplier_name")
    var supplierName: String= "",

    @CsvBindByName (column = "supplier_email")
    var supplierEmail: String= "",

    @CsvBindByName (column = "last_stock_update_time")
    var lastStockUpdateTime: String = ""

) {



    override fun toString(): String {
        return "CsvStockItem(itemId='$itemId', itemName='$itemName', quantity=$quantity, reorderThreshold=$reorderThreshold, supplierName='$supplierName', supplierEmail='$supplierEmail', lastStockUpdateTime='$lastStockUpdateTime')"
    }
}