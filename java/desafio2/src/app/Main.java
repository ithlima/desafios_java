package app;

import java.util.Scanner;
import controller.FinTracker;
import model.Transacao;
import model.TransacaoMensal;
import exceptions.EntradaInvalidaException;
import exceptions.TransacaoNaoEncontradaException;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    FinTracker ft = new FinTracker();
    int opcao;

    do {
      System.out.println("===== FINTRACK - SEU CONTROLE FINANCEIRO =====");
      System.out.println("1. Adicionar nova transação");
      System.out.println("2. Listar transações");
      System.out.println("3. Mostrar saldo atual");
      System.out.println("4. Remover transação");
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
            System.out.print("Descrição: ");
            String desc = scanner.nextLine();

            System.out.print("Valor (use negativo para despesas): ");
            while (!scanner.hasNextDouble()) {
              System.out.print("Digite um valor numérico: ");
              scanner.next();
            }
            double valor = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("É recorrente mensal? (s/n): ");
            String rec = scanner.nextLine();
            if (rec.equalsIgnoreCase("s")) {
              System.out.print("Dia do mês (1-31): ");
              while (!scanner.hasNextInt()) {
                System.out.print("Digite um número válido: ");
                scanner.next();
              }
              int dia = scanner.nextInt();
              scanner.nextLine();
              ft.adicionarTransacao(new TransacaoMensal(desc, valor, dia));
            } else {
              ft.adicionarTransacao(new Transacao(desc, valor));
            }

            System.out.println("Transação adicionada.");
          } catch (EntradaInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
          }
          break;

        case 2:
          ft.listarTransacoes();
          break;

        case 3:
          double saldo = ft.calcularSaldoTotal();
          System.out.println("Saldo atual: " + utils.Formatador.formataMoeda(saldo));
          break;

        case 4:
          ft.listarTransacoes();
          System.out.print("Digite o número da transação para remover: ");
          while (!scanner.hasNextInt()) {
            System.out.print("Digite um número válido: ");
            scanner.next();
          }
          int idx = scanner.nextInt() - 1;
          scanner.nextLine();
          try {
            ft.removerTransacao(idx);
            System.out.println("Removida com sucesso.");
          } catch (TransacaoNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
          }
          break;

        case 5:
          System.out.println("Saindo...");
          break;

        default:
          System.out.println("Opção inválida.");
      }

      System.out.println();
    } while (opcao != 5);

    scanner.close();
  }
}
