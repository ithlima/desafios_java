package utils;

import java.util.regex.Pattern;

public class ValidadorEmail {
  private static final Pattern EMAIL = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

  public static boolean validar(String email) {
    if (email == null)
      return false;
    return EMAIL.matcher(email).matches();
  }
}
