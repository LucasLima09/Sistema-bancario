# 🏦 Sistema Bancário API

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)

## 📖 Sobre o Projeto

Este é um projeto de uma API REST para gerenciamento de contas bancárias, desenvolvido como parte do curso de Desenvolvimento de Sistemas.

O objetivo principal foi aplicar conceitos avançados de Orientação a Objetos e Arquitetura de Software, focando em **Clean Architecture** e **Polimorfismo** para tratar diferentes tipos de contas.

## 🚀 Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 3**
* **Maven**
* **Database em cache** (Persistência em memória com Listas)

## ⚙️ Arquitetura e Design Patterns

O projeto segue princípios de **Arquitetura Limpa**, dividindo a aplicação em camadas:

* **Core:** Contém as Regras de Negócio (UseCases) e as Entidades (Models).
* **Infra:** Contém os Controllers (API), Repositorys e Config.
* **Domain Model:** Utilização de herança e polimorfismo (`Conta` -> `ContaCorrente`, `ContaPoupanca`, `ContaCredito`).

## ✨ Funcionalidades

- [x] Cadastro de Clientes (com validação de CPF único).
- [x] Abertura de Contas (Corrente, Poupança e Crédito).
- [x] Transferência entre contas.
- [x] Aplicação em Poupança (Exclusivo para Conta Poupança).
- [x] Uso de Limite de Crédito (Exclusivo para Conta Corrente/Crédito).

## 🔌 Como usar a API (Endpoints)

Aqui estão alguns exemplos de como testar a API usando Bruno, Postman ou Insomnia.

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
`POST /contas/corrente`<br>
`POST /contas/credito`<br>
`POST /contas/poupanca`<br>
```json
  {
    "saldo": 2500,
    "agencia": "Sicredi",
    "numero": "30353-3",
    "clienteId": 1
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
`POST /contas/1/compras`
```json
{
  "valor": 45
}
```
## 📦 Como Rodar o Projeto
Clone este repositório.

Abra o projeto na sua IDE.

Aguarde o Maven baixar as dependências.

Execute a classe principal `BancoApplication`

Acesse a API em http://localhost:8080.
