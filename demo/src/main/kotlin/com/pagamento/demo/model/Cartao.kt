package com.pagamento.demo.model

import com.pagamento.demo.controller.request.DadosPagamento

data class Cartao (
    var bandeira: String,

    var numeroCartao: String,

    var nomeTitular: String
): DadosPagamento