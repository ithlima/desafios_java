package controller;

import java.util.ArrayList;

import model.Tarefa;
import exceptions.TarefaNaoEncontradaException;

public class TaskManager {
  private ArrayList<Tarefa> tarefas;

  public TaskManager() {
    this.tarefas = new ArrayList<>();
  }

  public void adicionarTarefa(Tarefa tarefa) {
    tarefas.add(tarefa);
  }

  public void listarTarefas() {
    if (tarefas.isEmpty()) {
      System.out.println("Nenhuma tarefa cadastrada.");
      return;
    }

    final String GREEN = "\u001B[32m";
    final String YELLOW = "\u001B[33m";
    final String RESET = "\u001B[0m";

    for (int i = 0; i < tarefas.size(); i++) {
      var t = tarefas.get(i);
      String status = t.isConcluida() ? "concluída" : "pendente";
      String color = t.isConcluida() ? GREEN : YELLOW;
      String titulo = t.getTitulo() == null ? "(sem título)" : t.getTitulo();
      String descricao = t.getDescricao() == null || t.getDescricao().trim().isEmpty() ? "(sem descrição)"
          : t.getDescricao().trim();
      System.out.printf("%2d. %s%s%s - %s - %s%n", i + 1, color, status, RESET, titulo, descricao);
    }
  }

  public void concluirTarefa(int indice) throws TarefaNaoEncontradaException {
    if (indice < 0 || indice >= tarefas.size()) {
      throw new TarefaNaoEncontradaException("Tarefa não encontrada: " + (indice + 1));
    }

    tarefas.get(indice).setConcluida(true);
  }

  public void removerTarefa(int indice) throws TarefaNaoEncontradaException {
    if (indice < 0 || indice >= tarefas.size()) {
      throw new TarefaNaoEncontradaException("Tarefa não encontrada: " + (indice + 1));
    }

    tarefas.remove(indice);
  }

  public ArrayList<Tarefa> getTarefas() {
    return tarefas;
  }
}