package com.pagamento.demo.adapters.outbound.Repository

import com.pagamento.demo.adapters.inbound.controller.request.PostBoletoRequest
import com.pagamento.demo.adapters.inbound.controller.request.PostCartaoRequest
import com.pagamento.demo.domain.MeioPagamentoRepositoryPort
import com.pagamento.demo.domain.Pagamento
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class EfetivarPagamentoClient : MeioPagamentoRepositoryPort {

    private val webClient = WebClient.builder()
        .baseUrl("http://orquestrador:8080")
        .defaultHeader("Content-Type", "application/json")
        .build()

    override fun processarCartao(request: Pagamento) {
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

    override fun processarBoleto(request: Pagamento) {
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