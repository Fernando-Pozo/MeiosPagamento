package com.pagamento.demo.controller.request

class PostCartaoRequest(
    val id: String,
    val valor: Double,
    val bandeira: String,
    val numeroCartao: String,
    val nomeTitular: String
)
