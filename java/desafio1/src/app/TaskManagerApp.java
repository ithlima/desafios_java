package app;

import java.util.Scanner;

import controller.TaskManager;
import exceptions.EntradaInvalidaException;
import exceptions.TarefaNaoEncontradaException;
import model.Tarefa;

public class TaskManagerApp {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    TaskManager taskManager = new TaskManager();
    int opcao;

    do {
      System.out.println("===== GERENCIADOR DE TAREFAS =====");
      System.out.println("1. Criar nova tarefa");
      System.out.println("2. Listar tarefas");
      System.out.println("3. Marcar tarefa como concluída");
      System.out.println("4. Remover tarefa");
      System.out.println("5. Sair");
      System.out.print("Escolha uma opção: ");

      while (!scanner.hasNextInt()) {
        System.out.print("Digite um número válido: ");
        scanner.next();
      }

      opcao = scanner.nextInt();
      scanner.nextLine();

      switch (opcao) {
        case 1:
          try {
            System.out.print("Título: ");
            String titulo = scanner.nextLine();

            if (titulo == null || titulo.trim().isEmpty()) {
              throw new EntradaInvalidaException("Título não pode ser vazio.");
            }

            System.out.print("Descrição: ");
            String descricao = scanner.nextLine();

            Tarefa tarefa = new Tarefa(titulo.trim(), descricao);
            taskManager.adicionarTarefa(tarefa);
            System.out.println("Tarefa cadastrada com sucesso.");
          } catch (EntradaInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
          }
          break;

        case 2:
          taskManager.listarTarefas();
          break;

        case 3:
          taskManager.listarTarefas();
          System.out.print("Digite o número da tarefa para concluir: ");

          while (!scanner.hasNextInt()) {
            System.out.print("Digite um número válido: ");
            scanner.next();
          }

          int indiceConcluir = scanner.nextInt() - 1;
          scanner.nextLine();

          try {
            taskManager.concluirTarefa(indiceConcluir);
            System.out.println("Tarefa marcada como concluída.");
          } catch (TarefaNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
          }
          break;

        case 4:
          taskManager.listarTarefas();
          System.out.print("Digite o número da tarefa para remover: ");

          while (!scanner.hasNextInt()) {
            System.out.print("Digite um número válido: ");
            scanner.next();
          }

          int indiceRemover = scanner.nextInt() - 1;
          scanner.nextLine();

          try {
            taskManager.removerTarefa(indiceRemover);
            System.out.println("Tarefa removida com sucesso.");
          } catch (TarefaNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
          }
          break;

        case 5:
          System.out.println("Saindo do sistema...");
          break;

        default:
          System.out.println("Opção inválida.");
      }

      System.out.println();
    } while (opcao != 5);

    scanner.close();
  }
}
