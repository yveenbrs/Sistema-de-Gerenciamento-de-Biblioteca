# Sistema de Gerenciamento de Biblioteca

Este é um sistema simples em Java para gerenciamento de materiais de biblioteca. Ele permite o cadastro, busca, exclusão e listagem de **livros** e **revistas**, utilizando conceitos de **orientação a objetos** como herança, polimorfismo e encapsulamento.

---

## Estrutura do Projeto

- **Material (classe abstrata)**: Define os atributos e comportamentos comuns aos materiais da biblioteca (ex: título, autor).
- **Livro (subclasse de Material)**: Representa livros e inclui o gênero como atributo adicional.
- **Revista (subclasse de Material)**: Representa revistas e inclui o número da edição.
- **Biblioteca**: Gerencia a lista de materiais (livros e revistas) utilizando um `ArrayList`.
- **Main**: Contém o menu interativo e a lógica principal do sistema.

---

## Funcionalidades

- **Adicionar materiais** (livros ou revistas)
- **Pesquisar materiais** por título
- **Excluir materiais**
- **Listar todos os materiais cadastrados**

---

## Exemplos de Feedback ao Usuário

- Ao adicionar um material:  
  `"Livro adicionado com sucesso! / Revista adicionada com sucesso!"`

- Ao excluir um material:  
  `"Material removido com sucesso!"`

- Ao tentar excluir/pesquisar um material inexistente:  
  `"Não localizamos o material. Tente novamente"`
  
---

## Como Executar

1. Certifique-se de ter o **Java** instalado.
2. Compile todos os arquivos `.java`:
   ```bash
   javac *.java
3. Execute a classe Main.java
   ```bash
   java Main.java
