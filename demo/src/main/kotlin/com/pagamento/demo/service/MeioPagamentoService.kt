package com.pagamento.demo.service

import com.pagamento.demo.enums.PagamentoTipo
import com.pagamento.demo.model.Pagamento
import org.springframework.stereotype.Service

@Service
class MeioPagamentoService {

    fun processar(pagamento: Pagamento){
        when (pagamento.tipo) {
            PagamentoTipo.CARTAO -> {
                if (pagamento.dadosCartao == null) {
                    throw IllegalArgumentException("Dados do cartão são obrigatórios para pagamento com cartão.")
                }
//                // Converte o model para o objeto que a 2ª peça espera
//                val requestCartao = pagamento.toCartaoRequest()
//                // Chama o endpoint da 2ª peça para processar o pagamento com cartão
//                segundaPecaClient.processarCartao(requestCartao)
            }
            PagamentoTipo.BOLETO -> {
                if (pagamento.dadosBoleto == null) {
                    throw IllegalArgumentException("Dados do boleto são obrigatórios para pagamento com boleto.")
                }
//                // Converte o model para o objeto que a 2ª peça espera
//                val requestBoleto = pagamento.toBoletoRequest()
//                // Chama o endpoint da 2ª peça para processar o pagamento com boleto
//                segundaPecaClient.processarBoleto(requestBoleto)
            }

            null -> TODO()
        }
    }

}