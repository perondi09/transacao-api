# 📊 API Transação

Este projeto é uma API REST para gerenciar transações e calcular estatísticas das transações realizadas nos últimos 60 segundos. A API foi desenvolvida com Java e Spring Boot.

Inspirado no desafio técnico do Itaú Unibanco: https://github.com/feltex/desafio-itau-backend

## 🚀 Tecnologias Utilizadas

- Java
- Spring Boot

## ▶️ Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/perondi09/api-transacao.git
```

2. Acesse a pasta do projeto:
```bash
cd api-transacao
```

## 📍 Endpoints da Aplicação

#### Receber Transações

```http
POST /transacao
```

| Parâmetro  | Tipo             | Descrição                                    |
| :--------- | :--------------- | :------------------------------------------- |
| `valor`    | `Double`         | **Obrigatório.** O valor da transação        |
| `dataHora` | `OffsetDateTime` | **Obrigatório.** O horário em que a transação ocorreu |

---

#### Limpar Transações

```http
DELETE /transacao
```

---

#### Calcular Estatísticas

```http
GET /estatistica
```

| Parâmetro           | Tipo      | Descrição                                        |
| :------------------ | :-------- | :----------------------------------------------- |
| `intervaloSegundos` | `Integer` | **Não obrigatório.** O padrão é 60 segundos      |

## 👨‍💻 Autor

Desenvolvido por **Guilherme Perondi** — [LinkedIn](https://www.linkedin.com/in/guilherme-perondi/)
