package controller;

import java.util.ArrayList;
import model.Transacao;
import exceptions.EntradaInvalidaException;
import exceptions.TransacaoNaoEncontradaException;

public class FinTracker {
  private ArrayList<Transacao> transacoes;

  public FinTracker() {
    this.transacoes = new ArrayList<>();
  }

  public void adicionarTransacao(Transacao t) throws EntradaInvalidaException {
    if (t == null)
      throw new EntradaInvalidaException("Transação nula.");
    if (t.getDescricao() == null || t.getDescricao().trim().isEmpty()) {
      throw new EntradaInvalidaException("Descrição não pode ser vazia.");
    }
    if (Double.isNaN(t.getValor()) || Double.isInfinite(t.getValor())) {
      throw new EntradaInvalidaException("Valor inválido.");
    }

    transacoes.add(t);
  }

  public void listarTransacoes() {
    if (transacoes.isEmpty()) {
      System.out.println("Nenhuma transação registrada.");
      return;
    }

    for (int i = 0; i < transacoes.size(); i++) {
      System.out.printf("%2d. %s%n", i + 1, transacoes.get(i));
    }
  }

  public void removerTransacao(int indice) throws TransacaoNaoEncontradaException {
    if (indice < 0 || indice >= transacoes.size()) {
      throw new TransacaoNaoEncontradaException("Transação não encontrada: " + (indice + 1));
    }
    transacoes.remove(indice);
  }

  public double calcularSaldoTotal() {
    double total = 0.0;
    for (Transacao t : transacoes) {
      total += t.getValor();
    }
    return total;
  }

  public ArrayList<Transacao> getTransacoes() {
    return transacoes;
  }
}
