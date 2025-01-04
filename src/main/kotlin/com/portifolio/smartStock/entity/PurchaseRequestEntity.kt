package com.portifolio.smartStock.entity

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.data.mongodb.core.mapping.MongoId
import java.time.LocalDateTime


@Document(collection = "collection_purchase_requests")
data class PurchaseRequestEntity (
    @MongoId
    @Field(name = "item_id")
    var itemId : String,

    @Field(name = "item_name")
    var itemName : String,

    @Field(name = "quantity_on_stock")
    var quantityOnStock : Int,

    @Field(name = "reorder_threshold")
    var reorderThreshold: Int,

    @Field(name = "supplier_name")
    var supplierName:String,

    @Field(name = "supplier_email")
    var supplierEmail:String,

    @Field(name = "last_stock_update_time")
    var lastStockUpdateTime: LocalDateTime,

    @Field(name = "purchase_quantity")
    var purchaseQuantity: Int,

    @Field(name = "purchased_with_success")
    var purchasedWithSuccess: Boolean,

    @Field(name = "purchase_date_time")
    var purchaseDateTime: LocalDateTime
)