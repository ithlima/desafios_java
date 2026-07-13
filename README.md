# Projetos Java - Console

Este repositório reúne três aplicações de console em Java puro, organizadas por desafio dentro de `java/`.

## Projetos

| Pasta | Projeto | Entrada |
| --- | --- | --- |
| `java/desafio1` | TaskManager - Gerenciador de Tarefas | `app.TaskManagerApp` |
| `java/desafio2` | FinTrack - Finanças Pessoais | `app.FinTrackApp` |
| `java/desafio3` | MyContacts - Agenda de Contatos | `app.MyContactsApp` |

## Estrutura comum

- `app/`: classe de entrada e menu do console
- `controller/`: regras de negócio e gerenciamento de coleções
- `model/`: classes de domínio
- `exceptions/`: exceções customizadas
- `utils/`: utilitários opcionais

## Como executar

Se o seu terminal ainda estiver usando Java 8, rode com o JDK 21 explícito.

### Desafio 1

```powershell
cd C:\Users\Almeida\Documents\vscode\Treino\java\desafio1
C:\Users\Almeida\jdk21\jdk-21.0.2\bin\javac -d out src\app\TaskManagerApp.java src\controller\TaskManager.java src\model\Tarefa.java src\exceptions\*.java
C:\Users\Almeida\jdk21\jdk-21.0.2\bin\java -cp out app.TaskManagerApp
```

### Desafio 2

```powershell
cd C:\Users\Almeida\Documents\vscode\Treino\java\desafio2
C:\Users\Almeida\jdk21\jdk-21.0.2\bin\javac -d out src\app\FinTrackApp.java src\controller\FinTracker.java src\model\Transacao.java src\model\TransacaoMensal.java src\exceptions\*.java src\utils\Formatador.java
C:\Users\Almeida\jdk21\jdk-21.0.2\bin\java -cp out app.FinTrackApp
```

### Desafio 3

```powershell
cd C:\Users\Almeida\Documents\vscode\Treino\java\desafio3
C:\Users\Almeida\jdk21\jdk-21.0.2\bin\javac -d out src\app\MyContactsApp.java src\controller\Agenda.java src\model\Contato.java src\model\ContatoComercial.java src\exceptions\ContatoNaoEncontradoException.java src\utils\ValidadorEmail.java
C:\Users\Almeida\jdk21\jdk-21.0.2\bin\java -cp out app.MyContactsApp
```

## Observações

- Os projetos funcionam em memória, sem banco de dados.
- Não há classes `Demo`; apenas as aplicações prontas para uso no console.
- A padronização ficou no nome das classes de entrada: `TaskManagerApp`, `FinTrackApp` e `MyContactsApp`.
