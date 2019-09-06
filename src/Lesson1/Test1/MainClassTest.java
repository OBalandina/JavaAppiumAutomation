package lesson1.test1;

import org.junit.Test;

public class MainClassTest {
  @Test
  public void testGetLocalNumber() {
    MainClass a = new MainClass();

    if (a.getLocalNumber()==14)
     System.out.println(a.getLocalNumber());

  }
}
