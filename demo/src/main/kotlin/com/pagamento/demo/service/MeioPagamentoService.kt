package com.pagamento.demo.service

import com.pagamento.demo.Repository.EfetivarPagamentoClient
import com.pagamento.demo.enums.PagamentoTipo
import com.pagamento.demo.model.Pagamento
import org.springframework.stereotype.Service

@Service
class MeioPagamentoService(
    private val efetivarPagamentoClient: EfetivarPagamentoClient
) {

    fun processar(pagamento: Pagamento){
        when (pagamento.tipo) {
            PagamentoTipo.CARTAO -> {
                if (pagamento.dadosCartao == null) {
                    throw IllegalArgumentException("Dados do cartão são obrigatórios para pagamento com cartão.")
                }
                efetivarPagamentoClient.processarCartao(pagamento)
            }
            PagamentoTipo.BOLETO -> {
                if (pagamento.dadosBoleto == null) {
                    throw IllegalArgumentException("Dados do boleto são obrigatórios para pagamento com boleto.")
                }
                efetivarPagamentoClient.processarBoleto(pagamento)
            }

            null -> TODO()
        }
    }

}