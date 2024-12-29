package com.portifolio.smartStock.service

import org.springframework.stereotype.Service
import java.io.IOException


@Service
class SmartStockService(private val reportService: ReportService) {

    fun process(reportPath: String) {

        try {
            var item = reportService.readStockReport(reportPath)
        }
        catch ( e : IOException){
         TODO()

        }
    }
}
