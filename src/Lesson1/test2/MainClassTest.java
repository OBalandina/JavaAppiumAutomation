package lesson1.test2;

import org.junit.Test;

public class MainClassTest {
  @Test
  public void testGetClassNumber() {

    MainClass a = new MainClass();

    if (a.getClassNumber() > 45) {
      System.out.println("truu");
    } else {
      System.out.println("false");
    }
  }
}