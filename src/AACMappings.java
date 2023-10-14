import structures.AssociativeArray;
import structures.KeyNotFoundException;

public class AACMappings {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /*
   * the name of the file
   */
  String filename;

  /*
   * The top level of all the categories
   */
  AACCategory topLevelCategory;

  /*
   * The current level/category
   */
  AACCategory currentCategory;

  /*
   * Associative array of strings (of category names) and categories
   */
  AssociativeArray<String, AACCategory> categories;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /*
   * Creates a new mappings with filename
   */
  public AACMappings(String filename) {
    this.filename = filename;
    this.categories = new AssociativeArray<String, AACCategory>();
    this.topLevelCategory = new AACCategory("topLevelCategory");
    this.currentCategory = new AACCategory("currentCategory");

    this.categories.set("topLevelCategory", this.topLevelCategory);
    this.categories.set("currentCategory", this.currentCategory);
  } // AACMappings(String fileName)

  // +------------------+--------------------------------------------
  // | Standard Methods |
  // +------------------+

  /*
   * Given the image location selected, it determines the associated text with the image. If the
   * image provided is a category, it also updates the AAC's current category to be the category
   * associated with that image
   */
  public String getText(String imageLoc) {
    String result = "";

    try {
      if (isCategory(imageLoc)) {
        result = (this.categories.get("topLevelCategory")).getText(imageLoc);
        this.categories.set("currentCategory", this.categories.get(imageLoc));
      } else {
        result = (this.categories.get("currentCategory")).getText(imageLoc);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return result;
  } // getText(String imageLoc)

  /*
   * Provides an array of all the images in the current category
   */
  public String[] getImageLocs() {
    String result[] = null;
    try {
      result = (this.categories.get("currentCategory")).getImages();
    } catch (KeyNotFoundException e) {
      e.printStackTrace();
    }

    return result;
  } // getImageLocs()

  /*
   * Resets the current category of the AAC back to the default category
   */
  public void reset() {
    this.categories.set("currentCategory", this.topLevelCategory);
  } // reset()

  /*
   * Returns the current category or the empty string if on the default category
   */
  public String getCurrentCategory() throws KeyNotFoundException {
    if ((this.categories.get("currentCategory")).equals((this.categories.get("topLevelCategory"))))
      return "";
    else
      return (this.categories.get("currentCategory")).name;
  } // getCurrentCategory()

  /*
   * Determines if the image represents a category or text to speak
   */
  public boolean isCategory(String imageLoc) {
    if (imageLoc.substring(0, 1).equals("i"))
      return true;
    else
      return false;
  }

  /*
   * Writes AACMappings to a file
   */
  public void writeToFile(String fileName) {
    // STUB
  } // writeToFile(String fileName)

  /*
   * Adds the mapping to the current category (or the default category if that is the current
   * category)
   */
  public void add(String imageLoc, String text) {
    if (isCategory(imageLoc)) {
      try {
        this.categories.set(imageLoc, new AACCategory(imageLoc));
        this.categories.get("topLevelCategory").addItem(imageLoc, text);
        System.out.println("top level");
      } catch (KeyNotFoundException e) {
        e.printStackTrace();
      }
    } else {
      try {
        this.categories.get("currentCategory").addItem(imageLoc, text);
        System.out.println("bottom level");
      } catch (KeyNotFoundException e) {
        e.printStackTrace();
      }
    }
  } // add(String imageLoc, String text)

} // class AACMappings
