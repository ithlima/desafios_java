package controller;

import java.util.ArrayList;
import java.util.List;
import model.Contato;
import exceptions.ContatoNaoEncontradoException;

public class Agenda {
  private ArrayList<Contato> contatos;

  public Agenda() {
    this.contatos = new ArrayList<>();
  }

  public void adicionarContato(Contato c) {
    if (c == null)
      throw new IllegalArgumentException("Contato nulo");
    contatos.add(c);
  }

  public void listarContatos() {
    if (contatos.isEmpty()) {
      System.out.println("Nenhum contato cadastrado.");
      return;
    }
    for (int i = 0; i < contatos.size(); i++) {
      System.out.printf("%2d. %s%n", i + 1, contatos.get(i));
    }
  }

  public List<Contato> buscarPorNome(String nome) {
    ArrayList<Contato> resultados = new ArrayList<>();
    if (nome == null || nome.trim().isEmpty())
      return resultados;
    String q = nome.trim();
    for (Contato c : contatos) {
      if (c.getNome() != null && c.getNome().toLowerCase().contains(q.toLowerCase())) {
        resultados.add(c);
      }
    }
    return resultados;
  }

  public void removerContato(int indice) throws ContatoNaoEncontradoException {
    if (indice < 0 || indice >= contatos.size()) {
      throw new ContatoNaoEncontradoException("Contato não encontrado: " + (indice + 1));
    }
    contatos.remove(indice);
  }

  public ArrayList<Contato> getContatos() {
    return contatos;
  }
}
