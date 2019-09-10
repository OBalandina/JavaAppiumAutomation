package lesson1.test3;

import org.junit.Assert;
import org.junit.Test;

public class MainClassTest {
  private String str;

  @Test
  public void testGetClassString() {

    MainClass a = new MainClass();

    String s2 = a.getClassString().substring(0, 5);

    if (s2.equals("Hello")) {
      System.out.println("Hello, world");
    } else {
      System.out.println("Такого значения нет");
    }
    if (s2.equals("hello")) {
      System.out.println("hello, world");
    } else {
      System.out.println("Такого значения нет");
    }
    Assert.assertTrue("Нет Hello и hello", s2.equals("Hello") | s2.equals("hello"));

  }
}


//    if (s2 != "Hello") {
//     Assert.fail("Oшибка");
//    }
//    if (s2 != "hello"){
//      Assert.fail("ошибка");
//    }


//    Assert.assertTrue("Нет Hello и hello","s2 != \"hello\"");

    //   if (a.getClassString() == "Hello, world") {
//    if (a.getClassString().substring(0, 5) == "Hello") {
    //   }
//      System.out.println(a.getClassString().substring(0, 5));
//    }
    //  else {
    //     System.out.println("false");
    //  }
//  }

//}


//    if (a.getClassString() == "hello") {
//      System.out.println("пусто");
//    }
//    else
//    if (a.getClassString() == "Hello")
//    {System.out.println("Hello,world");
//    }


//    if (a.getClassString()== "Hello")
//      {System.out.println("Hello,world");}
