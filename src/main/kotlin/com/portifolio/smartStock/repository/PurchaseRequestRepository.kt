package com.portifolio.smartStock.repository

import com.portifolio.smartStock.entity.PurchaseRequestEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PurchaseRequestRepository : MongoRepository <PurchaseRequestEntity,String> {
}