package com.pagamento.demo.domain

interface MeioPagamentoRepositoryPort {
    fun processarCartao(request: Pagamento)
    fun processarBoleto(request: Pagamento)
}