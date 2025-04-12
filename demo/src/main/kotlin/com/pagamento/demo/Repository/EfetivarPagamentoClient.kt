package com.pagamento.demo.Repository

import com.pagamento.demo.model.Pagamento
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class EfetivarPagamentoClient {

    private val webClient = WebClient.create("http://processador-pagamento:8080")

    fun processarCartao(request: Pagamento) {
        webClient.post()
            .uri("/cartao")
            .bodyValue(request)
            .retrieve()
            .bodyToMono(Void::class.java)
            .block()
    }

    fun processarBoleto(request: Pagamento) {
        webClient.post()
            .uri("/boleto")
            .bodyValue(request)
            .retrieve()
            .bodyToMono(Void::class.java)
            .block()
    }
}