package com.pagamento.demo.application.service

import com.pagamento.demo.adapters.outbound.Repository.EfetivarPagamentoClient
import com.pagamento.demo.application.usecases.MeioPagamentoUseCase
import com.pagamento.demo.domain.enums.PagamentoTipo
import com.pagamento.demo.domain.Pagamento
import org.springframework.stereotype.Service

@Service
class MeioPagamentoService(
    private val efetivarPagamentoClient: EfetivarPagamentoClient
) : MeioPagamentoUseCase {

    override fun processar(pagamento: Pagamento) {
        when (pagamento.tipo) {
            PagamentoTipo.CARTAO -> efetivarPagamentoClient.processarCartao(pagamento)
            PagamentoTipo.BOLETO -> efetivarPagamentoClient.processarBoleto(pagamento)
            else -> throw IllegalArgumentException("Tipo de pagamento inválido.")
        }
    }

}