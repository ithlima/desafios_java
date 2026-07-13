package utils;

import java.text.NumberFormat;
import java.util.Locale;

public class Formatador {
  public static String formataMoeda(double valor) {
    NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
    return nf.format(valor);
  }
}
