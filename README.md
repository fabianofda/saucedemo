# Projeto de Automação Saucedemo

Este projeto de automação de testes web usando Java17, Maven, Selenium e JUnit5.

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


## Refencias
LinkDin e GitHub:

- [LinkedIn](Fabiano-dias-de-andrade): [https://www.linkedin.com/in/fabiano-dias-de-andrade-4846345b](https://www.linkedin.com/in/fabiano-dias-de-andrade-4846345b)
- [GitHub](Fabianofda): [https://github.com/fabianofda](https://github.com/fabianofda)