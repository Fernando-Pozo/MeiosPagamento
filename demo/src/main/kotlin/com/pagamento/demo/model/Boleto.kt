package com.pagamento.demo.model

import com.pagamento.demo.controller.request.DadosPagamento

data class Boleto (

    var numeroBoleto: String,

    var nomeTitular: String
): DadosPagamento