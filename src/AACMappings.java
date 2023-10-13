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
      result = this.currentCategory.getText(imageLoc);

      if (isCategory(result)) {
        this.currentCategory = this.categories.get(result);
        this.categories.set("currentCategory", this.currentCategory);
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
    String result[];
    result = this.currentCategory.getImages();

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
  public String getCurrentCategory() {
    if (currentCategory.equals(topLevelCategory))
      return "";
    else
      return currentCategory.name;
  } // getCurrentCategory()

  /*
   * Determines if the image represents a category or text to speak
   */
  public boolean isCategory(String imageLoc) {
    String temp[] = this.topLevelCategory.getImages();

    for (int i = 0; i < temp.length; i++) {
      if (temp[i].equals(imageLoc))
        return true;
    }

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
    try {
      this.categories.get("currentCategory").addItem(imageLoc, text);
    } catch (KeyNotFoundException e) {
      e.printStackTrace();
    }

    if(isCategory(imageLoc)) { 
      try {
        this.categories.get("topLevelCategory").addItem(imageLoc, text);
      } catch (KeyNotFoundException e) {
        e.printStackTrace();
      }
    }
  } // add(String imageLoc, String text)

} // class AACMappings
