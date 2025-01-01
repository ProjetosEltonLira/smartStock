package com.portifolio.smartStock.service

import com.portifolio.smartStock.client.AuthClient
import com.portifolio.smartStock.client.dto.AuthRequest
import com.portifolio.smartStock.config.AppConfig
import com.portifolio.smartStock.exception.SmartStockException
import org.springframework.stereotype.Service
import java.time.LocalDateTime


@Service
class AuthService (
    private var authClient: AuthClient,
    private var appConfig: AppConfig
    ){

    val GRANT_TYPE : String = "client_credentials"
    var expiresIn : LocalDateTime = LocalDateTime.now()
    var token : String = ""

    fun getAuth() : String{
            if (token.isBlank()) {
                generateToken()
            }
            else if (expiresIn.isBefore(LocalDateTime.now())) {
                generateToken()
            }
            return token
        }

    private fun generateToken() {

        var requestBody = AuthRequest(
            grantType = GRANT_TYPE,
            clientId = appConfig.clientId,
            clientSecret = appConfig.clientSecret
        )

        //Aqui utiliza a interface do Feign pra chamar a api.
        var response = authClient.authenticate(requestBody)

        if (!response.statusCode.is2xxSuccessful) {
            throw SmartStockException(
                "cannot generate token, " +
                        "status: " + response.statusCode +
                        "response: " + response.body
            )
        }
        token = response.body!!.acessToken
        expiresIn = LocalDateTime.now().plusSeconds((response.body!!.expiresIn.toLong()))
    }
}