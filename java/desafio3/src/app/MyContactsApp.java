package app;

import java.util.List;
import java.util.Scanner;

import controller.Agenda;
import exceptions.ContatoNaoEncontradoException;
import model.Contato;
import model.ContatoComercial;
import utils.ValidadorEmail;

public class MyContactsApp {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Agenda agenda = new Agenda();
    int opcao;

    do {
      System.out.println("===== AGENDA DE CONTATOS =====");
      System.out.println("1. Adicionar novo contato");
      System.out.println("2. Listar contatos");
      System.out.println("3. Buscar por nome");
      System.out.println("4. Remover contato");
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
          System.out.print("Nome: ");
          String nome = scanner.nextLine();
          System.out.print("Telefone: ");
          String tel = scanner.nextLine();
          System.out.print("Email: ");
          String email = scanner.nextLine();

          if (!ValidadorEmail.validar(email)) {
            System.out.println("Email inválido. Contato não adicionado.");
            break;
          }

          System.out.print("Contato comercial? (s/n): ");
          String com = scanner.nextLine();
          if (com.equalsIgnoreCase("s")) {
            System.out.print("Empresa: ");
            String emp = scanner.nextLine();
            agenda.adicionarContato(new ContatoComercial(nome, tel, email, emp));
          } else {
            agenda.adicionarContato(new Contato(nome, tel, email));
          }
          System.out.println("Contato adicionado.");
          break;

        case 2:
          agenda.listarContatos();
          break;

        case 3:
          System.out.print("Nome para busca: ");
          String q = scanner.nextLine();
          List<Contato> res = agenda.buscarPorNome(q);
          if (res.isEmpty()) {
            System.out.println("Nenhum contato encontrado.");
          } else {
            System.out.println("Resultados:");
            for (int i = 0; i < res.size(); i++) {
              System.out.printf("%2d. %s%n", i + 1, res.get(i));
            }
          }
          break;

        case 4:
          agenda.listarContatos();
          System.out.print("Digite o número do contato para remover: ");
          while (!scanner.hasNextInt()) {
            System.out.print("Digite um número válido: ");
            scanner.next();
          }
          int idx = scanner.nextInt() - 1;
          scanner.nextLine();
          try {
            agenda.removerContato(idx);
            System.out.println("Contato removido.");
          } catch (ContatoNaoEncontradoException e) {
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
