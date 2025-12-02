# 🏦 Sistema Bancário API

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)

## Sobre o Projeto

Este é um projeto de uma API REST para gerenciamento de contas bancárias, desenvolvido como avaliação final do curso de Desenvolvimento de Sistemas.

O objetivo principal foi aplicar conceitos de Orientação a Objetos e Arquitetura de Software, focando em **Clean Architecture** e **Polimorfismo** para tratar diferentes tipos de contas.

## Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 3**
* **Maven**
* **Database em cache** (Persistência em memória com Listas do próprio Java)

## Arquitetura e Design Patterns

O projeto segue princípios de **Arquitetura Limpa**, dividindo a aplicação em camadas:

* **Core:** Contém as Regras de Negócio (UseCases) e as Entidades (Models).
* **Infra:** Contém os Controllers (API), Repositorys e Config.
* **Domain Model:** Utilização de herança e polimorfismo (`Conta` -> `ContaCorrente`, `ContaPoupanca`, `ContaCredito`).

## Funcionalidades

- Cadastro de Clientes (com validação de CPF único).
- Abertura de Contas (Corrente, Poupança e Crédito).
- Transferência entre contas.
- Aplicação em Poupança (Exclusivo para Conta Poupança).
- Uso de Limite de Crédito (Exclusivo para Conta Crédito).

## Como usar a API (Endpoints)

Alguns exemplos de como testar a API usando Bruno, Postman ou Insomnia.

### 1. Criar Cliente
`POST /clientes`
```json
{
  "nome": "Lucas",
  "sobrenome":"Ferreira de Lima",
  "cpf": "12345678900"
}
```
### 2. Criar Conta Corrente, Crédito e Poupança
`POST /contas/corrente`

```json
  {
    "saldo": 2500,
    "agencia": "Sicredi",
    "numero": "30353-3",
    "clienteId": 1
  }
```
`POST /contas/credito`

```json
  {
    "saldo": 1000,
    "agencia": "Sicredi",
    "numero": "30112-3",
    "clienteId": 1,
    "creditoLimite": 2000
  }
  ```
O valor de `creditoLimite` vem em R$1.500 por padrão, caso não seja passado na requisição, mas pode ser incluido no JSON como no exemplo para setar o valor desejado.
<br>

`POST /contas/poupanca`

```json
  {
    "saldo": 1000,
    "agencia": "Sicredi",
    "numero": "30621-3",
    "clienteId": 1,
    "saldoPoupanca": 1500
  }
  ```
### 3. Realizar Transferência
`POST /contas/transferencias`
```json
{
  "origem": 1,
  "destino": 2,
  "valor": 1000
}
```
### 4. Aplicar na Poupança
`POST /contas/{id}/aplicacoes`
```json
{
  "valor": 1000
}
```
### 5. Usar Crédito
`POST /contas/{id}/compras`
```json
{
  "valor": 45
}
```
## Como Rodar o Projeto
Clone este repositório.

Abra o projeto na sua IDE.

Aguarde o Maven baixar as dependências.

Execute a classe principal `BancoApplication`

Acesse a API em http://localhost:8080.
