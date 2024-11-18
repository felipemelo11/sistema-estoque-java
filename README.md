# Sistema de Gerenciamento de Estoque
Bem-vindo ao repositório do Sistema de Gerenciamento de Estoque! Este projeto foi desenvolvido em Java e oferece uma solução robusta para gerenciar o estoque de produtos de um estabelecimento comercial.

## Funcionalidades Principais 🚀
- Adicionar Produtos: Insira novos itens no estoque com informações detalhadas.
- Listar Produtos: Exiba todos os produtos disponíveis no estoque.
- Atualizar Quantidade: Ajuste a quantidade de produtos conforme necessário.
- Remover Produtos: Exclua produtos que não estão mais disponíveis.

## Tecnologias Utilizadas 💻
- Java: Linguagem de programação para desenvolvimento do sistema.
- Coleções (HashMap): Estrutura de dados para gerenciar produtos.
- Tratamento de Exceções: Garante a integridade dos dados e a robustez do sistema.
- Interação com Usuário: Interface de linha de comando amigável.

## Estrutura do Projeto 📂
- **src**: Diretório contendo o código-fonte do projeto.
- **padrao**: Pacote contendo as classes principais do sistema.
- `Main.java`: Classe principal que executa o sistema.
- `Estabelecimento.java`: Classe que gerencia o estoque de produtos.
- `Produto.java`: Classe que representa um produto no estoque.
- `QuantidadeNegativaException.java`: Exceção personalizada para quantidade negativa.
- `PrecoNegativoException.java`: Exceção personalizada para preço negativo.

## Aviso Importante ⚠️
Antes de executar o sistema, certifique-se de ter o **Java Development Kit (JDK)** e o **Java Runtime Environment (JRE)** instalados no seu computador.
Recomendo instalar a versão mais recente do JDK e JRE, que pode ser baixada a partir do [site oficial da Oracle](https://www.oracle.com/java/technologies/javase-downloads.html).

## Como Executar 📖
Siga os passos abaixo para executar o sistema de gerenciamento de estoque:
1. **Clone este repositório**: git clone https://github.com/felipemelo11/sistema-estoque-java.git
2. **Navegar até o Diretório do Projeto**: cd sistema-estoque-java/src
3. **Compilar os Arquivos Java**: javac padrao/*.java
4. **Executar o Programa**: java padrao.Main.java

## Contribuições 🤝
- Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e enviar pull requests para melhorias e correções.
