import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BenTable<K, V> {

  private static final int DEFAULT_CAPACITY = 5;
  private static final double DEFAULT_LOAD_FACTOR = .75;

  private double maxLoadFactor;
  private int capacity, threshold, size = 0;
  private BenaryTree[] forest;

  public BenTable() {
    this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
  }

  public BenTable(int capacity, double maxLoadFactor) {
    if (capacity < 0)
      throw new IllegalArgumentException("Illegal capacity");
    if (maxLoadFactor <= 0 || Double.isNaN(maxLoadFactor) || Double.isInfinite(maxLoadFactor))
      throw new IllegalArgumentException("Illegal maxLoadFactor");
    this.maxLoadFactor = maxLoadFactor;
    this.capacity = Math.max(DEFAULT_CAPACITY, capacity);
    threshold = (int) (this.capacity * this.maxLoadFactor);
    forest = new BenaryTree[this.capacity];
  }

  public int hashCardinalizer(Entry entry) {
    return Math.abs(entry.getHash()) % capacity;
  }

  public boolean insert(K key, V value) {
    Entry entry = new Entry<K, V>(key, value);
    int index = hashCardinalizer(entry);
    if (forest[index] == null) {
      size++;
      forest[index] = new BenaryTree();
    }
    forest[index].insert(entry);
    checkSize();
    return true;
  }

  public boolean remove(Entry entry) {
    return forest[hashCardinalizer(entry)].remove(entry);
  }

  public void checkSize() {
    if (size > threshold) {
      resize();
    }
  }

  public void resize() {
    ArrayList<Entry> listOfAllEntries = new ArrayList<Entry>();
    int oldCap = capacity;
    capacity = capacity * 2; // arbitrary choice to double
    threshold = (int) (capacity * maxLoadFactor);

    for (int i = 0; i < oldCap; i++) {
      ArrayList<Entry> listOfIndexEntries = new ArrayList<Entry>();
      if (forest[i] != null) {
        listOfIndexEntries = forest[i].getAllEntries();
        for (int j = 0; j < listOfIndexEntries.size(); j++) {
          listOfAllEntries.add(listOfIndexEntries.get(j));
        }
        size--;
        forest[i] = null;
      }
    }

    forest = new BenaryTree[capacity];

    for (int i = 0; i < listOfAllEntries.size(); i++) {
      Entry entry = (Entry) listOfAllEntries.get(i);
      insert((K) entry.getKey(), (V) entry.getValue());
      listOfAllEntries.remove(i);
    }

  }

  public void printTable() {

    for (int i = 0; i < forest.length; i++) {
      if (forest[i] != null) {
        System.out.print("\n" + "Tree " + i + ":");
        forest[i].treePrint();
        System.out.print("\n");
      }
    }

  }

}