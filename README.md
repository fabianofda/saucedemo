# Projeto de Automação Saucedemo

Este projeto de automação de testes web usando Java, Maven, Selenium e JUnit.

## Estrutura do Projeto

- `src/test/java/com/sucedemo/e2e`: Contém os testes de automação e2e


## Configuração

Certifique-se de ter as seguintes ferramentas instaladas e configuradas corretamente:

- Java 17
- Maven

Para instalar as dependências do projeto, execute o seguinte comando:

> mvn clean install

## Executando Testes
Para executar os testes do projeto, gerar os relatórios HTML use o seguinte comando:

>mvn clean test surefire-report:report

Para executar os testes por suite:

>mvn test -Dtest=com.sucedemo.e2e.CartTest

>mvn test -Dtest=com.sucedemo.e2e.CheckoutTest

>mvn test -Dtest=com.sucedemo.e2e.Login

>mvn test -Dtest=com.sucedemo.e2e.Inventory


## Backlog

A pasta "backlog" contém os seguintes arquivos relacionados ao desenvolvimento:

- [BDD.md](backlog/BDD.md)
- [Desenvolvimento Prático – Fase 01.md](backlog/Desenvolvimento%20Pr%C3%A1tico%20%E2%80%93%20Fase%2001.md)
- [Desenvolvimento Prático – Fase 02.md](backlog/Desenvolvimento%20Pr%C3%A1tico%20%E2%80%93%20Fase%2002.md)
- [Desenvolvimento Prático – Fase 03.md](backlog/Desenvolvimento%20Pr%C3%A1tico%20%E2%80%93%20Fase%2003.md)
- [Desenvolvimento Teórico.md](backlog/Desenvolvimento%20Te%C3%B3rico.md)


## Refencias
LinkDin e GitHub:

- [LinkedIn](Fabiano-dias-de-andrade): [https://www.linkedin.com/in/fabiano-dias-de-andrade-4846345b](https://www.linkedin.com/in/fabiano-dias-de-andrade-4846345b)
- [GitHub](Fabianofda): [https://github.com/fabianofda](https://github.com/fabianofda)
