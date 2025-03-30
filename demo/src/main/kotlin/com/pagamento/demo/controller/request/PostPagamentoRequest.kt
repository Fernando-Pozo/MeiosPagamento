package com.pagamento.demo.controller.request

import com.pagamento.demo.enums.PagamentoTipo
import com.pagamento.demo.model.Boleto
import com.pagamento.demo.model.Cartao

class PostPagamentoRequest(

    val tipo: PagamentoTipo?,

    var valor: Double?,

    val dadosCartao: Cartao?,

    val dadosBoleto: Boleto?

)