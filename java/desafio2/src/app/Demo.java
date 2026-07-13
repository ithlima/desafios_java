package app;

import controller.FinTracker;
import model.Transacao;
import model.TransacaoMensal;

public class Demo {
  public static void main(String[] args) {
    FinTracker ft = new FinTracker();

    try {
      ft.adicionarTransacao(new Transacao("Salário", 5000.0));
      ft.adicionarTransacao(new Transacao("Aluguel", -1200.0));
      ft.adicionarTransacao(new TransacaoMensal("Academia", -120.0, 5));
    } catch (Exception e) {
      System.out.println("Erro no demo: " + e.getMessage());
    }

    System.out.println("--- Transações ---");
    ft.listarTransacoes();
    System.out.println();
    System.out.println("Saldo: " + utils.Formatador.formataMoeda(ft.calcularSaldoTotal()));
  }
}
