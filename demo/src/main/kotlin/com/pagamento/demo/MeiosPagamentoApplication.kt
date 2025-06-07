package com.pagamento.demo

import com.pagamento.demo.model.MyMessage
import io.awspring.cloud.sqs.operations.SqsTemplate
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component

@SpringBootApplication
class MeiosPagamentoApplication

fun main(args: Array<String>) {
	runApplication<MeiosPagamentoApplication>(*args)
}

@Component
class StartupRunner(
	private val sqsTemplate: SqsTemplate
) : CommandLineRunner {
	override fun run(vararg args: String?) {
		val queueUrl = "https://localhost.localstack.cloud:4566/000000000000/minha-fila"
		val message = MyMessage("meu valor de start")
		sqsTemplate.send(queueUrl, message)
		println("Mensagem enviada para SQS: $message")
	}
}
