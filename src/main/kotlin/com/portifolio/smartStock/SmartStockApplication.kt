package com.portifolio.smartStock

import com.portifolio.smartStock.config.AppConfig
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class SmartStockApplication (private var appConfig: AppConfig) : CommandLineRunner {

	override fun run(vararg args: String?) {
		println( appConfig.clientId)
		println( appConfig.clientSecret)
	}
}

fun main(args: Array<String>) {
	runApplication<SmartStockApplication>(*args)
}

