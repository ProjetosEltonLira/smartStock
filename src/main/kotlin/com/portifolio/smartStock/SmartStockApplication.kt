package com.portifolio.smartStock

import com.portifolio.smartStock.client.GoogleClient
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class SmartStockApplication (private var googleClient: GoogleClient) : CommandLineRunner {


	override fun run(vararg args: String?) {
		googleClient.helloGoogle()
	}
}

fun main(args: Array<String>) {
	runApplication<SmartStockApplication>(*args)
}

