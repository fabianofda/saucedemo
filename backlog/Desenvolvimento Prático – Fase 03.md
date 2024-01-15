Desenvolvimento Prático – Fase 03

7) [Gerenciamento/Monitoramento dos Testes]

Simulação de Cadastro de Bugs por Tipologia:

Bug Implementação de Error:

- Cenário: Remover um Produto do Carrinho
Descrição: Ao tentar remover um produto do carrinho, a aplicação trava e exibe uma mensagem de erro.
Tipologia: Implementação
Passos para Reproduzir:
Faça login com um usuário válido.
Adicione um produto ao carrinho.
Tente remover o produto do carrinho.
Verifique se a aplicação trava e exibe uma mensagem de erro.

Bug de Arquitetura:

- Cenário: Finalizar uma Compra com Sucesso
Descrição: Durante o processo de finalização de compra, o sistema realiza chamadas ineficientes ao servidor, resultando em lentidão.
Tipologia: Arquitetura
Passos para Reproduzir:
Adicione produtos ao carrinho.
Inicie o processo de checkout.
Complete as informações necessárias.
Tente finalizar a compra.
Verifique se a finalização da compra é demorada devido a chamadas ineficientes.

Bug de Requisitos:

- Cenário: Validar Carrinho de Compras
Descrição: O carrinho de compras não exibe corretamente a quantidade total de itens adicionados.
Tipologia: Requisitos
Passos para Reproduzir:
Adicione vários produtos ao carrinho.
Verifique se o carrinho exibe corretamente a quantidade total de itens adicionados.
Observe se a quantidade total no carrinho não corresponde ao número real de itens.

8) [Gerenciamento/Monitoramento dos Testes] 

Simulação de Cadastro de Bugs por Criticidade:

Bug de Criticidade Bloqueado:

- Cenário: Login com Sucesso
Descrição: Após inserir as credenciais corretas e clicar no botão de login, o usuário é redirecionado para uma página em branco.
Criticidade: Bloqueado
Passos para Reproduzir:
Acesse a página de login.
Insira o nome de usuário "standard_user" e a senha correta.
Clique no botão de login.
Verifique se a página fica em branco.

Bug de Criticidade Alta:

- Cenário: Inserir Produto no Carrinho
Descrição: Após adicionar o produto "sauce-labs-backpack" ao carrinho, o sistema não reflete corretamente no carrinho.
Criticidade: Alta
Passos para Reproduzir:
Faça login com um usuário válido.
Vá para a página de produtos.
Adicione o produto "sauce-labs-backpack" ao carrinho.
Verifique se o produto não aparece corretamente no carrinho.

Bug de Criticidade Média:

- Cenário: Login com Usuário Bloqueado
Descrição: Após inserir as credenciais de um usuário bloqueado e clicar no botão de login, o sistema permite o acesso.
Criticidade: Média
Passos para Reproduzir:
Acesse a página de login.
Insira o nome de usuário "locked_out_user" e uma senha válida.
Clique no botão de login.
Verifique se o sistema permite o acesso ao usuário bloqueado.

Bug de Criticidade Baixa:

- Cenário: Filtrar por Nome (A to Z)
Descrição: Após selecionar a opção de filtrar produtos por nome de A a Z, a lista de produtos não é ordenada corretamente.
Criticidade: Baixa
Passos para Reproduzir:
Vá para a página de produtos.
Selecione a opção de filtrar por nome de A a Z.
Verifique se a lista de produtos não está ordenada corretamente.