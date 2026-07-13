package model;

public class TransacaoMensal extends Transacao {
  private int diaDoMes; // 1-31

  public TransacaoMensal() {
    super();
  }

  public TransacaoMensal(String descricao, double valor, int diaDoMes) {
    super(descricao, valor);
    this.diaDoMes = diaDoMes;
  }

  public int getDiaDoMes() {
    return diaDoMes;
  }

  public void setDiaDoMes(int diaDoMes) {
    this.diaDoMes = diaDoMes;
  }

  @Override
  public String toString() {
    return String.format("[MENSAL dia %d] %s", diaDoMes, super.toString());
  }
}
