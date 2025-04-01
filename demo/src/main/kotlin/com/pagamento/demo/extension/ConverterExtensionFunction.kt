package com.pagamento.demo.extension

import com.pagamento.demo.controller.request.PostPagamentoRequest
import com.pagamento.demo.enums.PagamentoTipo
import com.pagamento.demo.model.Boleto
import com.pagamento.demo.model.Cartao
import com.pagamento.demo.model.Pagamento

fun PostPagamentoRequest.toPagamentoModel(): Pagamento {
    return when (this.tipo) {
        PagamentoTipo.CARTAO -> {
            // Cast seguro: se o dadosPagamento não for do tipo Cartao, lança uma exceção.
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