# API - Meios de Pagamento

Este é um projeto de API desenvolvido em **Kotlin** com **Spring Boot**, composto por três partes. Uma delas é responsável pela **infraestrutura**, que deve ser clonada e executada separadamente para que a aplicação funcione corretamente.

## ✅ Requisitos

* [JDK 17+](https://adoptium.net/)
* [IntelliJ IDEA](https://www.jetbrains.com/idea/)
* [Docker](https://www.docker.com/) instalado e em execução
* [Git](https://git-scm.com/) para clonar os repositórios

## 🧩 Estrutura do Projeto

O projeto depende de três componentes principais:

1. **API Peça A – Meios de Pagamento** *(este repositório)*
2. **API Peça B – Orquestração** ([Repositório](https://github.com/Fernando-Pozo/orquestracao))
3. **Infraestrutura** ([Repositório](https://github.com/Fernando-Pozo/infra-microservicos))

## ▶️ Como Rodar Localmente

### 1. Clone o repositório de infraestrutura

```bash
git clone https://github.com/Fernando-Pozo/infra-microservicos
```

### 2. Execute a infraestrutura

1. Certifique-se de que o **Docker** esteja em execução.
2. No terminal ou IntelliJ, navegue até o diretório clonado e inicie a infraestrutura conforme as instruções do repositório.

### 3. Configure o DynamoDB no LocalStack

1. Acesse o site do [LocalStack](https://app.localstack.cloud/sign-in).
2. Faça login ou crie uma conta.
3. No painel, selecione **DynamoDB**.
4. Clique em **Create table** e preencha os campos:

   * **Table Name:** `pagamento_entity`
   * **Partition Key (HASH):** `ID` (String)
   * **Billing Mode:** `PAY_PER_REQUEST`

> 🚨 Essa tabela é imprescindível para o funcionamento da API.

### 4. Execute a API de Meios de Pagamento

1. Abra este repositório no IntelliJ.
2. Aguarde a indexação do projeto.
3. Execute a classe principal (`Application.kt`).

## 🧪 Testando a API

Utilize **Insomnia**, **Postman** ou `curl` para testar a API.

### Exemplo de requisição POST:

```bash
curl --request POST \
  --url http://localhost:8081/pagamentos \
  --header 'Content-Type: application/json' \
  --data '{
    "tipo": "CARTAO",
    "valor": 150.75,
    "dadosPagamento": {
      "bandeira": "VISA",
      "numeroCartao": "4111111111111111",
      "nomeTitular": "João Silva",
      "tokenTransacao": "token123456"
    }
  }'
```

---

Para dúvidas ou contribuições, abra uma issue ou envie um pull request.
