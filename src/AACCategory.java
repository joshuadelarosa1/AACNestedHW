import java.lang.String;

public class AACCategory {

  // +-----------+---------------------------------------------------
  // | Constants |
  // +-----------+

  /**
   * The default capacity of the initial array.
   */

  static final int DEFAULT_CAPACITY = 16;

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /*
   * The size of the associative array
   */
  int size;

  /*
   * The name of the associative array
   */
  String name;

  /**
   * The array of key/value pairs.
   */

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  public AACCategory(String name) {
    // STUB
  }

  // +------------------+--------------------------------------------
  // | Standard Methods |
  // +------------------+

  public void addItem(String imageLoc, String text) {
    // STUB
  }

  public String getCategory() {
    return ""; // STUB
  }

  public String getText(String imageLoc) {
    return ""; // STUB
  }

  public boolean hasImage(String imageLoc) {
    return true; // STUB
  }

  public String[] getImages() {
    String result[] = new String[DEFAULT_CAPACITY];
    return result; // STUB
  }

}
