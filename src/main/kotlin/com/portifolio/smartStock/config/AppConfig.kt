package com.portifolio.smartStock.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig(

    //no java é $.{}
    @Value("\${app.client-id}")
    var clientId: String,

    @Value("\${app.client-secret}")
    var clientSecret : String
)