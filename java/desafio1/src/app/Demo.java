package app;

import controller.TaskManager;
import exceptions.TarefaNaoEncontradaException;
import model.Tarefa;

public class Demo {
  public static void main(String[] args) {
    TaskManager tm = new TaskManager();

    tm.adicionarTarefa(new Tarefa("Comprar leite", "Ir ao mercado"));
    tm.adicionarTarefa(new Tarefa("Estudar Java", "Ler capítulo sobre OOP"));

    System.out.println("--- Lista inicial ---");
    tm.listarTarefas();
    System.out.println();

    try {
      tm.concluirTarefa(0);
      System.out.println("--- Após concluir a tarefa 1 ---");
      tm.listarTarefas();
      System.out.println();

      tm.removerTarefa(1);
      System.out.println("--- Após remover a tarefa 2 ---");
      tm.listarTarefas();
    } catch (TarefaNaoEncontradaException e) {
      System.out.println("Erro no demo: " + e.getMessage());
    }
  }
}
