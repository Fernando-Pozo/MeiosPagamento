package com.pagamento.demo.domain

import com.pagamento.demo.adapters.inbound.controller.request.DadosPagamento

data class Boleto (

    var numeroBoleto: String,

    var nomeTitular: String
): DadosPagamento