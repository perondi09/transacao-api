# 📊 API Transação

Este projeto é uma API REST para gerenciar transações e calcular estatísticas das transações realizadas nos últimos 60 segundos. A API foi desenvolvida com Java e Spring Boot.

Inspirado no desafio tecnico Itaú Unibanco: https://github.com/feltex/desafio-itau-backend

## 🚀 Tecnologias Utilizadas

Este projeto foi desenvolvido utilizando as seguintes tecnologias:

* **Java 21**
* **Spring Boot 3**
* **Maven** para gerenciamento de dependências

## ⚙️ Pré-requisitos

Antes de começar, você vai precisar ter as seguintes ferramentas instaladas na sua máquina:
* [JDK 21+](https://www.oracle.com/java/technologies/javase-downloads.html)
* [Maven 3.8.1+](https://maven.apache.org/download.cgi)
* [Git](https://git-scm.com/)

## 🛠️ Configuração e Execução

1. Clone o repositório:
```bash
git clone https://github.com/perondi09/minha-biblioteca.git
```

2. Acesse a pasta do projeto:

```bash
cd minha-biblioteca
```

## 📍 Endpoints da Aplicação

#### Receber Transações

```http
  POST /transacao
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `valor` | `BigDecimal` | **Obrigatório**. O valor da transação 
| `dataHora` | `OffsetDateTime` | **Obrigatório**. O horário que a transação ocorreu

#### Limpar Transações

```http
  DELETE /transacao
```

#### Calcular Estatísticas

```http
  GET /estatistica
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `intervaloSegundos` | `integer` | **Não Obrigatório** O padrão default é 60s  |

## 👨‍💻 Autor

Desenvolvido por **Guilherme Perondi** - [Linkedin](https://www.linkedin.com/in/guilherme-perondi/)
