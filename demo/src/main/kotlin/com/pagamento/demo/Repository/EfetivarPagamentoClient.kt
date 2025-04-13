package com.pagamento.demo.Repository

import com.pagamento.demo.controller.request.PostBoletoRequest
import com.pagamento.demo.controller.request.PostCartaoRequest
import com.pagamento.demo.model.Pagamento
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class EfetivarPagamentoClient {

    private val webClient = WebClient.builder()
        .baseUrl("http://localhost:8080")
        .defaultHeader("Content-Type", "application/json")
        .build()

    fun processarCartao(request: Pagamento) {
        val cartao = request.dadosCartao
            ?: throw IllegalArgumentException("Pagamento com cartão sem dados do cartão")

        val body = PostCartaoRequest(
            id = request.id,
            valor = request.valor ?: 0.0,
            bandeira = cartao.bandeira,
            numeroCartao = cartao.numeroCartao,
            nomeTitular = cartao.nomeTitular
        )

        webClient.post()
            .uri("/cartao")
            .bodyValue(body)
            .retrieve()
            .bodyToMono(Void::class.java)
            .block()
    }

    fun processarBoleto(request: Pagamento) {
        val boleto = request.dadosBoleto
            ?: throw IllegalArgumentException("Pagamento com boleto sem dados do boleto")

        val body = PostBoletoRequest(
            id = request.id,
            valor = request.valor ?: 0.0,
            numeroBoleto = boleto.numeroBoleto,
            nomeTitular = boleto.nomeTitular
        )

        webClient.post()
            .uri("/boleto")
            .bodyValue(body)
            .retrieve()
            .bodyToMono(Void::class.java)
            .block()
    }

}