package example.util;

public class VirtualProductCodeManager {
  private SingletonClass singletonClass;

  public VirtualProductCodeManager() {
    singletonClass = SingletonClass.getInstance();
  }

  public void useCode(String code) {
    singletonClass.useCode(code);
  }

  public boolean isCodeUsed(String code) {
    return singletonClass.isCodeUsed(code);
  }
}
