package com.pagamento.demo.extension

import com.pagamento.demo.controller.request.PostPagamentoRequest
import com.pagamento.demo.model.Pagamento

fun PostPagamentoRequest.toPagamentoModel(): Pagamento {
    return Pagamento(
        tipo = this.tipo,
        valor = this.valor,
        dadosCartao = this.dadosCartao,
        dadosBoleto = this.dadosBoleto
    )
}