package com.pagamento.demo.application.usecases

import com.pagamento.demo.domain.Pagamento

interface MeioPagamentoUseCase {
    fun processar(pagamento: Pagamento)
}