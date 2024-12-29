package com.portifolio.smartStock.service

import com.opencsv.bean.CsvToBeanBuilder
import com.portifolio.smartStock.domain.CsvStockItem
import org.springframework.stereotype.Service
import java.io.BufferedReader
import java.io.FileReader
import java.io.Reader


@Service
class ReportService {

    fun readStockReport(reportPath: String): List<CsvStockItem> {

        //.use é equivalente ao try with resources do java e encerra os recursos assim que utilizado.
        BufferedReader(FileReader(reportPath)).use { reader ->
            val csvToBean = CsvToBeanBuilder<CsvStockItem>(reader)
                .withType(CsvStockItem::class.java)
                .build()

            val stockItems = csvToBean.parse()

            // Exibição dos itens lidos do CSV
            stockItems.forEach { println(it) }

            return stockItems
        }
    }
}
