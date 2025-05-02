package com.pagamento.demo.adapters.inbound.controller.request

class PostCartaoRequest(
    val id: String,
    val valor: Double,
    val bandeira: String,
    val numeroCartao: String,
    val nomeTitular: String
)
