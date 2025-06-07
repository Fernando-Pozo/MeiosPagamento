package com.pagamento.demo.adapters.inbound.controller

import com.pagamento.demo.adapters.inbound.controller.request.PostPagamentoRequest
import com.pagamento.demo.application.service.MeioPagamentoService
import com.pagamento.demo.utils.toPagamentoModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pagamentos")
class MeioPagamentoController(
    private val meioPagamentoService: MeioPagamentoService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun processarMeioPagamento(@RequestBody request: PostPagamentoRequest) {
        meioPagamentoService.processar(request.toPagamentoModel())
    }
}