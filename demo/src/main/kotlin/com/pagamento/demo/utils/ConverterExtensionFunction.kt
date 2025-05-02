package com.pagamento.demo.utils

import com.pagamento.demo.adapters.inbound.controller.request.PostPagamentoRequest
import com.pagamento.demo.domain.Boleto
import com.pagamento.demo.domain.Cartao
import com.pagamento.demo.domain.Pagamento
import com.pagamento.demo.domain.enums.PagamentoTipo

fun PostPagamentoRequest.toPagamentoModel(): Pagamento {
    return when (this.tipo) {
        PagamentoTipo.CARTAO -> {
            val cartao = this.dadosPagamento as? Cartao
                ?: throw IllegalArgumentException("Dados do cartão são inválidos ou não foram informados para pagamento com cartão.")
            Pagamento(
                tipo = this.tipo,
                valor = this.valor,
                dadosCartao = cartao,
                dadosBoleto = null
            )
        }
        PagamentoTipo.BOLETO -> {
            val boleto = this.dadosPagamento as? Boleto
                ?: throw IllegalArgumentException("Dados do boleto são inválidos ou não foram informados para pagamento com boleto.")
            Pagamento(
                tipo = this.tipo,
                valor = this.valor,
                dadosCartao = null,
                dadosBoleto = boleto
            )
        }
        else -> throw IllegalArgumentException("Tipo de pagamento inválido.")
    }
}