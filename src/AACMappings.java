import structures.AssociativeArray;
public class AACMappings {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /*
   * the name of the file
   */
  String fileName;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /*
   * Creates a new mappings with filename
   */
  public AACMappings(String fileName) {
    this.fileName = fileName; // STUB
  } // AACMappings(String fileName)

  // +------------------+--------------------------------------------
  // | Standard Methods |
  // +------------------+

  /*
   * Given the image location selected, it determines the associated text with the image. If the
   * image provided is a category, it also updates the AAC's current category to be the category
   * associated with that image
   */
  public String getText(String actionCommand) {
    return "french fries"; // STUB
  } // getText(String actionCommand)

  /*
   * Provides an array of all the images in the current category
   */
  public String[] getImageLocs() {
    return new String[] {"img/food/icons8-french-fries-96.png",
        "img/food/icons8-watermelon-96.png"}; // STUB
  } // getImageLocs()

  /*
   * Resets the current category of the AAC back to the default category
   */
  public void reset() {
    // STUB
  } // reset()

  /*
   * Gets the current category
   */
  public String getCurrentCategory() {
    return "food"; // STUB
  } // getCurrentCategory()

  /*
   * Determines if the image represents a category or text to speak
   */
  public boolean isCategory(String imageLoc) {
    return true; // STUB
  } // isCategory(String imageLoc)

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
    // STUB
  } // add(String imageLoc, String text)

} // class AACMappings
