package example.util;

import java.util.HashSet;
import java.util.Set;

public class SingletonClass {

  private static SingletonClass instance;
  private Set<String> usedCodes;

  private SingletonClass() {
    usedCodes = new HashSet<>();
  }

  public static synchronized SingletonClass getInstance() {
    if (instance == null) {
      instance = new SingletonClass();
    }
    return instance;
  }

  public void useCode(String code) {
    usedCodes.add(code);
  }

  public boolean isCodeUsed(String code) {
    return usedCodes.contains(code);
  }
}
