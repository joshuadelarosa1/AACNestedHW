import java.lang.String;
import structures.AssociativeArray;

public class AACCategory {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The associative array of strings (locs) and strings (text)
   */
  AssociativeArray<String, String> AA;

  /*
   * The name of the category
   */
  String name;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /*
   * Creates a new empty category with the given name
   */
  public AACCategory(String name) {
    this.name = name;
    AA = new AssociativeArray<String, String>();
  } // AACAtegory(String, AssociativeArray<String, String>)

  // +------------------+--------------------------------------------
  // | Standard Methods |
  // +------------------+

  /*
   * Adds the mapping of the imageLoc to the text to the category
   */
  public void addItem(String imageLoc, String text) {
    AA.set(imageLoc, text);
  } // addItem(String, String)

  /*
   * Returns the name of the category
   */
  public String getCategory() {
    return this.name;
  } // getCategory()

  /*
   * Returns the text associated with the given image loc in this category
   */
  public String getText(String imageLoc) throws Exception {
    String result;

    try {
      result = AA.get(imageLoc);
    } catch (Exception e) {
      throw new Exception("This value was not found. Please try again.");
    }

    return result;
  } // getText(String imageLoc)

  /*
   * Determines if the provided images is stored in the category
   */
  public boolean hasImage(String imageLoc) {
    return AA.hasKey(imageLoc);
  } // hasImage(String imageLoc)

  /*
   * Returns an array of all image locations
   */
  public String[] getImages() {
    String result[];
    result = AA.keyNames();

    return result;
  } // getImages()

} // class AACCategory
