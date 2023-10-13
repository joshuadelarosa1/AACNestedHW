import structures.AssociativeArray;

public class test {
  public static void main(String args[]) throws Exception {
    AssociativeArray<String, String> AATest = new AssociativeArray<String, String>();

    AATest.set("hello", "world");
    AATest.set("what", "up");
    AATest.set("a", "b");
    AATest.set("world", "bruh");
    AATest.set("it", ":3");
    AATest.set("is", ":D");

    String[] result = AATest.keyNames();
    for (int i = 0; i < result.length; i++) {
      if (result[i] == null) {
        continue;
      } else {
        if (!result[i].equals("null")) {
          System.out.println("result: " + result[i]);
          System.out.println("----------");
        } else {
          continue;
        }
      }
    }
  }
}
