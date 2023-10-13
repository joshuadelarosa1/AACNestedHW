package structures;

import static java.lang.reflect.Array.newInstance;
import java.security.Key;

/**
 * A basic implementation of Associative Arrays with keys of type K and values of type V.
 * Associative Arrays store key/value pairs and permit you to look up values by key.
 *
 * @author Joshua De La Rosa
 * @author Samuel A. Rebelsky
 */
public class AssociativeArray<K, V> {
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

  /**
   * The size of the associative array (the number of key/value pairs).
   */
  int size;

  /**
   * The array of key/value pairs.
   */
  KVPair<K, V> pairs[];

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new, empty associative array.
   */
  @SuppressWarnings({"unchecked"})
  public AssociativeArray() {
    // Creating new arrays is sometimes a PITN.
    this.pairs = (KVPair<K, V>[]) newInstance((new KVPair<K, V>()).getClass(), DEFAULT_CAPACITY);
    this.size = 0;
  } // AssociativeArray()

  // +------------------+--------------------------------------------
  // | Standard Methods |
  // +------------------+

  /**
   * Create a copy of this AssociativeArray.
   */
  public AssociativeArray<K, V> clone() {
    AssociativeArray<K, V> associativeArrayClone = new AssociativeArray<K, V>();

    for (int i = 0; i < this.pairs.length; i++) {
      associativeArrayClone.pairs[i] = this.pairs[i];
    }
    associativeArrayClone.size = this.size;

    return associativeArrayClone;
  } // clone()

  /**
   * Convert the array to a string.
   */
  public String toString() {
    String result = "{ ";

    for (int i = 0; i < this.pairs.length; i++) {
      if (this.pairs[i] == null) {
        continue;
      } else {
        result = result + "key" + i + ": " + this.pairs[i].value + " ";
      }
    }

    result = result + " }";
    return result;
  } // toString()

  // +----------------+----------------------------------------------
  // | Public Methods |
  // +----------------+

  /**
   * Set the value associated with key to value. Future calls to get(key) will return value.
   */
  public void set(K key, V value) {
    if (this.size >= this.pairs.length) {
      this.expand();
    }

    if (this.hasKey(key)) {
      try {
        int j = find(key);
        this.pairs[j].value = value;
      } catch (KeyNotFoundException e) {
        e.printStackTrace();
      }
    }

    for (int i = 0; i <= this.size; i++) {
      if (this.pairs[i] == null) {
        this.pairs[i] = new KVPair<>();

        this.pairs[i].key = key;
        this.pairs[i].value = value;
      } else
        continue;
    }

    this.size++;

  } // set(K,V)

  /**
   * Get the value associated with key.
   *
   * @throws KeyNotFoundException when the key does not appear in the associative array.
   */
  public V get(K key) throws KeyNotFoundException {
    for (int i = 0; i < this.pairs.length; i++) {
      if (this.pairs[i] == null || this.pairs[i].key == null || this.pairs[i].value == null) {
        continue;
      } else {
        if (this.pairs[i].key == key) {
          return this.pairs[i].value;
        }
      }
    }

    throw new KeyNotFoundException();
  } // get(K)

  /**
   * Determine if key appears in the associative array.
   */
  public boolean hasKey(K key) {

    for (int i = 0; i < this.pairs.length; i++) {
      if (this.pairs[i] == null || this.pairs[i].key == null || this.pairs[i].value == null) {
        continue;
      } else {
        if (this.pairs[i].key.equals(key))
          return true;
      }
    }

    return false;
  } // hasKey(K)

  /**
   * Remove the key/value pair associated with a key. Future calls to get(key) will throw an
   * exception. If the key does not appear in the associative array, does nothing.
   */
  public void remove(K key) {
    if (!this.hasKey(key)) {
      return;
    }

    for (int i = 0; i < this.pairs.length; i++) {
      if (this.pairs[i] == null || this.pairs[i].key == null || this.pairs[i].value == null) {
        continue;
      } else {
        if (this.pairs[i].key.equals(key)) {
          this.pairs[i].key = null;
          this.pairs[i].value = null;
          this.size--;
        } else {
          continue;
        }
      }
    }

  } // remove(K)

  /**
   * Determine how many values are in the associative array.
   */
  public int size() {
    return this.size;
  } // size()

  /*
   * Gets all the keys of a given associative array
   
  @SuppressWarnings({"unchecked"})
  public K[] keys() {
    K allKs[] = (K[]) newInstance(((new KVPair<K, V>()).key).getClass(), DEFAULT_CAPACITY);
    int j = 0;

    for (int i = 0; i < this.pairs.length; i++) {
      if (this.pairs[i] == null || this.pairs[i].key == null || this.pairs[i].value == null) {
        continue;
      } else {
        allKs[j] = this.pairs[i].key;
        j++;
      }
    }

    return allKs;
  } // keys() */

  public String[] keyNames(){
    String result[] = new String[this.pairs.length];
    int j = 0;

    for(int i = 0; i < this.pairs.length; i++) { 
      if (this.pairs[i] == null || this.pairs[i].key == null || this.pairs[i].value == null) {
        continue;
      } else { 
        result[j] = this.pairs[i].key.toString();
        j++;
      }
    }
    
    return result;
  }

  // +-----------------+---------------------------------------------
  // | Private Methods |
  // +-----------------+

  /**
   * Expand the underlying array.
   */
  public void expand() {
    this.pairs = java.util.Arrays.copyOf(this.pairs, this.pairs.length * 2);
  } // expand()

  /**
   * Find the index of the first entry in `pairs` that contains key. If no such entry is found,
   * throws an exception.
   */
  public int find(K key) throws KeyNotFoundException {
    for (int i = 0; i < this.pairs.length; i++) {
      if (this.pairs[i] == null || this.pairs[i].key == null || this.pairs[i].value == null) {
        continue;
      }
      if (this.pairs[i].key.equals(key)) {
        return i;
      }
    }

    throw new KeyNotFoundException();
  } // find(K)

} // class AssociativeArray
