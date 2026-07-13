package model;

public class Transacao {
  private String descricao;
  private double valor; // positivo para entrada, negativo para saída

  public Transacao() {
  }

  public Transacao(String descricao, double valor) {
    this.descricao = descricao;
    this.valor = valor;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public boolean isEntrada() {
    return valor >= 0;
  }

  @Override
  public String toString() {
    String tipo = isEntrada() ? "ENTRADA" : "SAÍDA";
    return String.format("%s: %s %s", tipo, descricao == null ? "(sem descrição)" : descricao,
        utils.Formatador.formataMoeda(valor));
  }
}
