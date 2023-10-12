import java.lang.String;
import structures.AssociativeArray;

public class AACCategory {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The associative array of catgeories and associative arrays
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
  public AACCategory(String name, AssociativeArray<String, String> AA) {
    this.AA = AA;
    this.name = name;
  } // AACAtegory(String, AssociativeArray<String, String>)

  // +------------------+--------------------------------------------
  // | Standard Methods |
  // +------------------+

  /*
   * Adds the mapping of the imageLoc to the text to the category
   */
  public void addItem(String imageLoc, String text) {
    this.AA.set(imageLoc, text);
  } // addItem(String, String)

  /*
   * Returns the name of the category
   */
  public String getCategory() {

    return "";
  } // getCategory()

  /*
   * Returns the text associated with the given image loc in this category
   */
  public String getText(String imageLoc) throws Exception {
    String result;

    try {
      result = this.AA.get(imageLoc);
    } catch (Exception e) {
      throw new Exception("This value was not found. Please try again.");
    }

    return result;
  } // getText(String imageLoc)

  /*
   * Determines if the provided images is stored in the category
   */
  public boolean hasImage(String imageLoc) {
    return this.AA.hasKey(imageLoc);
  } // hasImage(String imageLoc)

  /*
   * Returns an array of all image locations
   */
  public String[] getImages() {
    String result[];
    result = this.AA.keys();

    return result;
  } // getImages()

} // class AACCategory
