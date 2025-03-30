package com.pagamento.demo.controller

import com.pagamento.demo.controller.request.PostPagamentoRequest
import com.pagamento.demo.extension.toPagamentoModel
import com.pagamento.demo.service.MeioPagamentoService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

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