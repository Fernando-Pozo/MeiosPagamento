package com.pagamento.demo.adapters.inbound.controller.request

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.pagamento.demo.domain.enums.PagamentoTipo
import com.pagamento.demo.domain.Boleto
import com.pagamento.demo.domain.Cartao

class PostPagamentoRequest(

    val tipo: PagamentoTipo,

    var valor: Double?,

    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
        property = "tipo"
    )
    @JsonSubTypes(
        JsonSubTypes.Type(value = Cartao::class, name = "CARTAO"),
        JsonSubTypes.Type(value = Boleto::class, name = "BOLETO")
    )
    var dadosPagamento: DadosPagamento

)