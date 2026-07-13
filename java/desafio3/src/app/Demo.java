package app;

import controller.Agenda;
import model.Contato;
import model.ContatoComercial;

public class Demo {
  public static void main(String[] args) {
    Agenda agenda = new Agenda();
    agenda.adicionarContato(new Contato("Ana Silva", "(11) 99999-0000", "ana@example.com"));
    agenda.adicionarContato(new ContatoComercial("Empresa X", "(11) 88888-1111", "contato@empresax.com", "Empresa X"));

    System.out.println("--- Lista inicial ---");
    agenda.listarContatos();

    System.out.println();
    System.out.println("Busca por 'ana':");
    var res = agenda.buscarPorNome("ana");
    res.forEach(c -> System.out.println(c));

    System.out.println();
    System.out.println("Removendo contato 1...");
    try {
      agenda.removerContato(0);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    System.out.println("--- Lista final ---");
    agenda.listarContatos();
  }
}
