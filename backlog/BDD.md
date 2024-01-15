##    Testes do projeto:

Cenário: Login com sucesso
    Dado que estou na página de login
    Quando realizo o login com credenciais válidas
    Então devo ser redirecionado para a página principal
    E o sistema deve indicar o login bem-sucedido

Cenário: Login com Usuário Bloqueado
    Dado que estou na página de login
    Quando realizo o login com um usuário bloqueado
    Então devo ver uma mensagem de erro indicando que o usuário está bloqueado

Cenário: Login sem Informar o Nome de Usuário
    Dado que estou na página de login
    Quando eu tento fazer login sem informar o nome de usuário
    Então devo ver uma mensagem de erro indicando que o nome de usuário é obrigatório

Cenário: Login sem Informar a Senha
    Dado que estou na página de login
    Quando eu tento fazer login sem informar a senha
    Então devo ver uma mensagem de erro indicando que a senha é obrigatória

Cenário: Login com Credenciais Inválidas
    Dado que estou na página de login
    Quando eu tento fazer login com credenciais inválidas
    Então devo ver uma mensagem de erro indicando que as credenciais não correspondem a nenhum usuário

Cenário: Logout com sucesso
    Dado que estou logado no sistema
    Quando clico no botão de menu
    E seleciono a opção de logout
    Então devo visualizar a tela de login

Cenário: Inserir Produto no Carrinho
    Dado que estou logado no sistema
    Quando adiciono o produto "Sauce Labs Backpack" ao carrinho
    Então a quantidade de itens no carrinho deve ser igual a 1

Cenário: Remover Produto do Carrinho
    Dado que estou logado no sistema
    E o produto "Sauce Labs Backpack" está no meu carrinho
    Quando removo o produto do carrinho
    Então a quantidade de itens no carrinho deve ser igual a 0

Cenário: Filtrar por Nome em Ordem Crescente (AZ)
    Dado que estou logado no sistema
    Quando seleciono a opção de ordenação por nome em ordem crescente (AZ)
    Então a lista de nomes de produtos deve estar em ordem crescente

Cenário: Filtrar por Nome em Ordem Decrescente (ZA)
    Dado que estou logado no sistema
    Quando seleciono a opção de ordenação por nome em ordem decrescente (ZA)
    Então a lista de nomes de produtos deve estar em ordem decrescente

Cenário: Filtrar por Preço de Baixo para Alto
    Dado que estou logado no sistema
    Quando seleciono a opção de ordenação por preço de baixo para alto
    Então a lista de preços de produtos deve estar em ordem crescente

Cenário: Filtrar por Preço de Alto para Baixo
    Dado que estou logado no sistema
    Quando seleciono a opção de ordenação por preço de alto para baixo
    Então a lista de preços de produtos deve estar em ordem decrescente

Cenário: Validar Carrinho de Compras
    Dado que estou logado no sistema
    E há produtos disponíveis no catálogo
    Quando adiciono produtos ao carrinho
    E visualizo o conteúdo do carrinho
    Então a quantidade de itens no carrinho deve ser correta
    E os detalhes dos produtos no carrinho são exibidos corretamente

  Cenário: Finalizar uma compra com sucesso
    Dado que estou autenticado
    Quando adiciono um produto ao carrinho
    E prossigo para o checkout
    E finalizo a compra
    Então vejo a mensagem "Obrigado pela sua compra!"

Cenário: Validar mensagem de erro sem Nome
    Dado que estou autenticado
    Quando adiciono um produto ao carrinho
    E prossigo para o checkout
    E tento finalizar a compra sem preencher o campo de Nome
    Então vejo a mensagem de erro "Nome é obrigatório"

Cenário: Validar checkout sem Sobrenome
    Dado que estou autenticado
    Quando adiciono um produto ao carrinho
    E prossigo para o checkout
    E preencho o formulário de checkout sem um Sobrenome
    Então devo ver a mensagem de erro "Erro: Sobrenome é obrigatório"

Cenário: Validar checkout sem CEP
    Dado que estou autenticado
    Quando adiciono um produto ao carrinho
    E prossigo para o checkout
    E preencho o formulário de checkout sem um CEP
    Então devo ver a mensagem de erro "Erro: CEP é obrigatório"
