package com.pagamento.demo.domain

import com.pagamento.demo.domain.enums.PagamentoTipo
import java.util.*

data class Pagamento (

    var id: String = UUID.randomUUID().toString(),

    var tipo: PagamentoTipo? = null,

    var valor: Double? = 0.0,

    val dadosCartao: Cartao? = null,

    val dadosBoleto: Boleto? = null
)