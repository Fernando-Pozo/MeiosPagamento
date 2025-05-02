package com.pagamento.demo.domain

import com.pagamento.demo.adapters.inbound.controller.request.DadosPagamento

data class Cartao (
    var bandeira: String,

    var numeroCartao: String,

    var nomeTitular: String
): DadosPagamento