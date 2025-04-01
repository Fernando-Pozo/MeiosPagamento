package com.pagamento.demo.service

import com.pagamento.demo.Repository.EfetivarPagamentoClient
import com.pagamento.demo.enums.PagamentoTipo
import com.pagamento.demo.model.Pagamento
import org.springframework.stereotype.Service

@Service
class MeioPagamentoService(
    private val efetivarPagamentoClient: EfetivarPagamentoClient
) {

    fun processar(pagamento: Pagamento) {
        when (pagamento.tipo) {
            PagamentoTipo.CARTAO -> efetivarPagamentoClient.processarCartao(pagamento)
            PagamentoTipo.BOLETO -> efetivarPagamentoClient.processarBoleto(pagamento)
            else -> throw IllegalArgumentException("Tipo de pagamento inválido.")
        }
    }

}